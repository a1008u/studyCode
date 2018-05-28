import { paramjson } from '../model/paramjson';

/**
 * localstorage用の操作を格納
 */
export namespace localstorage {
  /**
   * localstorageに値を格納する
   * @param {paramjson} paramJson
   */
  export let storejsonInLocalStorage = (paramJson: paramjson) => {
    localStorage.setItem('_atpm', JSON.stringify(paramJson));
  };

  /**
   * localstorageからjsonを取得する
   * @param {string} key
   * @returns {paramjson}
   */
  export let getLocalStorageJson = (key: string): paramjson => {
    let value: string = localStorage.getItem(key);
    if (value !== null) {
      return JSON.parse(value);
    } else {
      return null;
    }
  };
}
