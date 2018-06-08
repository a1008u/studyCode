import { itp } from './service/itp';
import { cookies } from './service/cookies';
import { localstorage } from './service/localstorage';
import { url } from './service/url';
import { paramjson } from './model/paramjson';
import { atag } from './service/atag';
import { formtag } from './service/formtag';
import { storejson } from './service/storejson';

export namespace lpcompletion {
  // パラメタ補完時にjsonのkeyとvalueをURLで利用するクエリの形「key=value」にする（itpの場合は、itp対応確認をする）
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

  /**
   * defaultとoptionで設定しているkeyだけを抽出し、localStorageとcookieに保持するために抽出したparamjsonを作成する
   * @param keys
   * @param paramJson
   */
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

  // AnchorタグとFormタグにパラメタ補完を実施する。
  // falseが返る場合：locaStorageからJSONが取得できている。または、取得したJSONのkeyまたはvalueがに値がない。
  export let setParam = (keys: string[], paramJson: paramjson): boolean => {
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
   * 1-1. URLを取得の後ろにクエリがある場合は、URL取得処理 -> localstorageとcookieに格納 -> aタグやformタグ変換 <br />
   * 1-2. URLのクエリがない場合、localstorageを確認と取得 -> aタグやformタグ変換 <br />
   * 1-3. URLのクエリがないかつlocalstorageにもない場合、cookieを確認と取得 -> aタグやformタグ変換 <br />
   * ex:　1-1または、1-2と3で該当がない場合は、aタグとformタグは補完されない<br />
   * @param {string[]} keys
   * @returns {string}
   */
  export let autoParamComplement = (keys: string[]) => {
    let query: string = location.search.substring(1);
    if (url.checkParam(query)) {
      let originalParamJson: paramjson = url.getParam(query);
      const extractedParamJson: paramjson = extractJson(
        keys,
        originalParamJson
      );
      let p: paramjson = storejson.set(extractedParamJson, 90, notConfirmJson);
      if (setParam(keys, p)) {
        return 'we use URL';
      }
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
 * 1.defaultの動作 事前に指定している値でパラメータの保持やパラメタ補完処理を実施する。<br />
 * 2.scriptタグで設定されている__attpを取得、パラメタ補完処理を実施。取得できない場合は、処理を実施しない。<br />
 */
document.addEventListener(
  'DOMContentLoaded',
  event => {
    // default
    let def: string[] = ['atnct'];
    lpcompletion.autoParamComplement(def);

    // option(lpページの__attpの設定値を確認する)
    let keys: string[] = (window as any)._keys || [];
    if (keys.length !== 0) {
      lpcompletion.autoParamComplement(keys);
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
