import { localstorage } from './localstorage';
import { cookies } from './cookies';
import { paramjson } from '../model/paramjson';

export namespace storejson {
  let store = (deadline: number, extractedParamJson: paramjson): void => {
    let day = new Date();
    day.setDate(day.getDate() + deadline);
    extractedParamJson['deadline'] = [day.toISOString()];
    localstorage.storeJsonInLocalStorage(extractedParamJson, deadline);
    cookies.storeJsonInCookie(extractedParamJson, deadline);
  };

  let createJson = (
    storeParamJson: paramjson,
    extractedParamJson: paramjson,
    deadline
  ): paramjson => {
    for (let tempjs in storeParamJson) {
      if (
        extractedParamJson[tempjs] === undefined &&
        storeParamJson[tempjs] !== undefined
      ) {
        extractedParamJson[tempjs] = storeParamJson[tempjs];
      }
    }

    return extractedParamJson;
  };

  /**
   * パラメタから生成したJsonをlocalStorageとCookieに保持させる<br />
   * libraryにする為に、保持処理をまとめる <br />
   * @param {paramjson} paramJson
   * @param {number} deadline
   */
  export let set = (
    extractedParamJson: paramjson,
    deadline: number,
    notConfirmJson: (paramJson: paramjson) => boolean
  ): paramjson => {
    if (!notConfirmJson(extractedParamJson)) {
      let targetParamJson: paramjson = null;
      let localStorageParamJson: paramjson = localstorage.getLocalStorageJson(
        '_atpm'
      );
      if (localStorageParamJson !== null) {
        targetParamJson = createJson(
          localStorageParamJson,
          extractedParamJson,
          deadline
        );
        store(deadline, targetParamJson);
        return targetParamJson;
      }

      let cookiesParamJson: paramjson = cookies.getCookieJson('_atpm');
      if (cookiesParamJson !== null) {
        targetParamJson = createJson(
          cookiesParamJson,
          extractedParamJson,
          deadline
        );
        store(deadline, targetParamJson);
        return targetParamJson;
      }

      store(deadline, extractedParamJson);
      return extractedParamJson;
    }

    return extractedParamJson;
  };
}
