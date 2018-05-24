import { paramjson } from '../model/paramjson';

export namespace localstorage {
  /**
   *
   * @param {paramjson} paramJson
   */
  export let storejsonInLocalStorage = (paramJson: paramjson) => {
    localStorage.setItem('_atpm', JSON.stringify(paramJson));
  };

  /**
   *
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
