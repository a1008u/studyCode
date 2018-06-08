import { paramjson } from '../model/paramjson';

/**
 * localstorage用の操作を格納
 */
export namespace localstorage {
  /**
   * localstorageからjsonを取得 + 有効期限内かを確認する
   * @param {string} key
   * @returns {paramjson}
   */
  export let getLocalStorageJson = (key: string): paramjson => {
    let value: string = localStorage.getItem(key);

    if (
      value === undefined ||
      value === null ||
      value === '' ||
      value === ' '
    ) {
      return null;
    }

    let js: paramjson = JSON.parse(value);
    let deadlineISO: string = js['deadline'][0];

    if (
      deadlineISO === undefined ||
      deadlineISO === null ||
      deadlineISO === '' ||
      deadlineISO === ' '
    ) {
      localStorage.removeItem('_atpm');
      return null;
    }

    let deadline = new Date(deadlineISO);
    let nowDay = new Date();
    if (nowDay.getTime() > deadline.getTime()) {
      localStorage.removeItem('_atpm');
      return null;
    }

    return JSON.parse(value);
  };

  /**
   * localstorageに値 + localstorageの有効期限を格納する
   * @param {paramjson} paramJson
   * @param deadline
   */
  export let storeJsonInLocalStorage = (
    paramJson: paramjson,
    deadline: number
  ) => {
    localStorage.setItem('_atpm', JSON.stringify(paramJson));
  };
}
