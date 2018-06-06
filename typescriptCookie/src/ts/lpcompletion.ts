import { itp } from './service/itp';
import { cookies } from './service/cookies';
import { localstorage } from './service/localstorage';
import { url } from './service/url';
import { paramjson } from './model/paramjson';
import { atag } from './service/atag';
import { formtag } from './service/formtag';
import { storejson } from './service/storejson';

export namespace lpcompletion {
  // jsonのkeyとvalueを「key=value」にする（itpの場合は、itp対応確認をする）
  let getQueryParam = (paramJson: paramjson): string[] => {
    let formParam: string[] = [];
    Object.keys(paramJson).forEach(jsonKey => {
      let key: string = jsonKey;
      let values: string[] = paramJson[jsonKey];
      if (
        decodeURIComponent(key) === undefined ||
        decodeURIComponent(key) === null ||
        decodeURIComponent(key) === '' ||
        decodeURIComponent(key) === ' '
      ) {
        return;
      }
      if (decodeURIComponent(key) !== 'atnct') {
        values.forEach(value => {
          formParam.push(`${key}=${value}`);
        });
        return;
      }
      if (itp.hasITP(window.navigator.userAgent)) {
        values.forEach(value => {
          formParam.push(`${key}=${value}`);
        });
      }
    });
    return formParam;
  };

  // 連想配列(URLのクエリパラメタまたはcookieやlocalstorage)のvalueに値があるかを確認する。
  // keyに値がない場合は、forの処理を行わない。
  let notConfirmJson = (paramJson: paramjson): boolean => {
    let count = 0;
    for (let i in paramJson) {
      ++count;
      if (paramJson[i] === undefined || paramJson[i] === null) {
        count = 0;
        break;
      }
    }
    return count === 0;
  };

  let extractJson = (keys: string[], paramJson: paramjson): paramjson => {
    let resultJson: paramjson = {};
    for (let key of keys) {
      Object.keys(paramJson)
        .filter(paramJsonkey => paramJsonkey === key)
        .forEach(
          paramJsonkey => (resultJson[paramJsonkey] = paramJson[paramJsonkey])
        );
    }

    return resultJson;
  };

  // AnchorタグとFormタグにパラメタを付与する。
  // falseが返る場合：locaStorageからJSONが取得できている。または、取得したJSONのkeyまたはvalueがに値がない。
  export let setParam = (keys: string[], paramJson: paramjson): boolean => {
    if (paramJson === undefined || paramJson === null) {
      return false;
    }

    if (notConfirmJson(paramJson)) {
      return false;
    }

    let targetParamJson: paramjson = url.containKey(keys, paramJson);
    atag.setAtg(getQueryParam(targetParamJson));
    formtag.setFormtg(getQueryParam(targetParamJson));
    return true;
  };

  /**
   * 【処理パターン】
   * 1-1. URLを取得の後ろにクエリがある場合は、URL取得処理 -> aタグやformタグ変換 -> localstorageとcookieに格納 <br />
   * 1-2. URLのクエリがない場合、localstorageを確認と取得 -> aタグやformタグ変換 <br />
   * 1-3. URLのクエリがないかつlocalstorageにもない場合、cookieを確認と取得 -> aタグやformタグ変換 <br />
   * ex:　1-1または、1-2と3で該当がないい場合は、aタグとformタグは補完ず、notingを返す<br />
   * @param {string[]} keys
   * @returns {string}
   */
  export let autoParamComplement = (keys: string[]) => {
    let originalParamJson: paramjson = url.getParam(location.search.substring(1));
    let extractedParamJson: paramjson = extractJson(keys, originalParamJson);
    if (url.checkParam(location.search.substring(1))) {
      storejson.set(extractedParamJson, 90, notConfirmJson);
    }

    if (setParam(keys, extractedParamJson)) {
      return 'we use URL';
    }

    if (setParam(keys, localstorage.getLocalStorageJson('_atpm'))) {
      return 'we use localstorage';
    }

    if (setParam(keys, cookies.getCookieJson('_atpm'))) {
      return 'we use cookie';
    }
    return 'nothing';
  };
}

/**
 * 【処理の流れ】<br />
 * 1.scriptタグで設定されている_keyを取得する。取得できない場合は、空の配列。<br />
 * 2.配列が取得できている場合のみ、パラメタ補完処理を実行する<br />
 */

document.addEventListener(
  'DOMContentLoaded',
  event => {

    // default
    let def: string[] = ['atnct'];
    console.log(lpcompletion.autoParamComplement(def));

    // option
    let keys: string[] = (window as any)._keys || [];
    if (keys.length !== 0) {
      console.log(lpcompletion.autoParamComplement(keys));
    }
  },
  false
);

// declare let _keys: string[] ;
//
// document.addEventListener(
//     'DOMContentLoaded',
//     event => {
//         // jsの後ろに付いているパラメータを取得
//
//         let keys: string[] = _keys || [];
//         if (keys.length !== 0) {
//             console.log(lpcompletion.autoParamComplement(keys));
//         }
//     },
//     false
// );
