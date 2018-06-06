import { localstorage } from './localstorage';
import { cookies } from './cookies';
import { paramjson } from '../model/paramjson';

export namespace storejson {
  /**
   * パラメタから生成したJsonをlocalStorageとCookieに保持させる<br />
   * libraryにする為に、保持処理をまとめる <br />
   * @param {paramjson} paramJson
   * @param {number} deadline
   */
  export let set = (
    paramJson: paramjson,
    deadline: number,
    notConfirmJson: (paramJson: paramjson) => boolean
  ): void => {
    if (!notConfirmJson(paramJson)) {
      localstorage.storeJsonInLocalStorage(paramJson, deadline);
      cookies.storeJsonInCookie(paramJson, deadline);
    }
  };
}
