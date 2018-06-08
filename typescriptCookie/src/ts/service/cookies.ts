import { paramjson } from '../model/paramjson';

/**
 * 目的：cookieの操作を行う
 */
export namespace cookies {
  /**
   * 正規表現を用いて、cookieに[_atpm]が存在しているか確認する
   * @param {string} sKey
   * @returns {boolean}
   */
  export let hasItem = (sKey: string) =>
    new RegExp(
      '(?:^|;\\s*)' + escape(sKey).replace(/[\-\.\+\*]/g, '\\$&') + '\\s*\\='
    ).test(document.cookie);

  let getItem = sKey => {
    if (!sKey || !hasItem(sKey)) {
      return null;
    }
    return unescape(
      document.cookie.replace(
        new RegExp(
          '(?:^|.*;\\s*)' +
            escape(sKey).replace(/[\-\.\+\*]/g, '\\$&') +
            '\\s*\\=\\s*((?:[^;](?!;))*[^;]?).*'
        ),
        '$1'
      )
    );
  };

  /**
   * CookieからJSONを取得する
   * @param {string} key
   * @returns {paramjson}
   */
  export let getCookieJson = (key: string): paramjson => {
    let value = getItem(key);
    if (value !== null) {
      return JSON.parse(value);
    }
    return null;
  };

  // cookieの有効期限を90日として保持させる
  let setItem = (
    sKey: string,
    sValue: string,
    deadline: number,
    sPath: string,
    sDomain: string,
    bSecure: boolean
  ): void => {
    if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) {
      return;
    }
    let date: Date = new Date();
    date.setDate(date.getDate() + deadline);
    document.cookie = `${escape(sKey)}=${escape(sValue)}; path=${
      sPath ? sPath : ''
    }; expires=${date.toUTCString()}${bSecure ? '; secure' : ''}`;
  };

  /**
   * jsonを保持
   * @param paramJson
   * @param deadline
   * @param deleteDeadline
   */
  export let storeJsonInCookie = (
    paramJson: paramjson,
    deadline: number,
    deleteDeadline: (extractedParamJson: paramjson) => void
  ): void => {
    deleteDeadline(paramJson);
    setItem(
      '_atpm',
      JSON.stringify(paramJson),
      deadline,
      '/',
      location.hostname,
      false
    );
  };
}
