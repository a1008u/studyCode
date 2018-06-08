import { localstorage } from './localstorage';
import { cookies } from './cookies';
import { paramjson } from '../model/paramjson';

export namespace storejson {
  export let setDeadline = (
    extractedParamJson: paramjson,
    deadline: number
  ): void => {
    let day = new Date();
    day.setDate(day.getDate() + deadline);
    extractedParamJson['deadline'] = [day.toISOString()];
  };

  export let deleteDeadline = (extractedParamJson: paramjson): void => {
    if (extractedParamJson['deadline'] !== undefined) {
      delete extractedParamJson['deadline'];
    }
  };

  let store = (deadline: number, extractedParamJson: paramjson): void => {
    localstorage.storeJsonInLocalStorage(
      extractedParamJson,
      deadline,
      setDeadline
    );
    cookies.storeJsonInCookie(extractedParamJson, deadline, deleteDeadline);
  };

  let createJson = (
    storeParamJson: paramjson,
    extractedParamJson: paramjson
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
        targetParamJson = createJson(localStorageParamJson, extractedParamJson);
        store(deadline, targetParamJson);
        return targetParamJson;
      }

      let cookiesParamJson: paramjson = cookies.getCookieJson('_atpm');
      if (cookiesParamJson !== null) {
        targetParamJson = createJson(cookiesParamJson, extractedParamJson);
        store(deadline, targetParamJson);
        return targetParamJson;
      }

      store(deadline, extractedParamJson);
      return extractedParamJson;
    }

    return extractedParamJson;
  };
}
