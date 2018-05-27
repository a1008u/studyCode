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
  export let hasItem = (sKey: string) => {
    return new RegExp(
      '(?:^|;\\s*)' + escape(sKey).replace(/[\-\.\+\*]/g, '\\$&') + '\\s*\\='
    ).test(document.cookie);
  };

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

  // cookieの有効期限を1年として保持させる
  let setItem = (sKey, sValue, vEnd, sPath, sDomain, bSecure): void => {
    if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) {
      return;
    }
    let date: Date = new Date();
    date.setFullYear(date.getFullYear() + 1);
    let sExpires = date.toUTCString();
    document.cookie = `${escape(sKey)}=${escape(sValue)}; path=${
      sPath ? sPath : ''
    }; expires=${sExpires}${bSecure ? '; secure' : ''}`;
  };

  /**
   * jsonを保持
   * @param {paramjson} paramjson
   */
  export let storeJsonInCookie = (paramjson: paramjson): void => {
    setItem(
      '_atpm',
      JSON.stringify(paramjson),
      Infinity,
      '/',
      location.hostname,
      false
    );
  };
}
