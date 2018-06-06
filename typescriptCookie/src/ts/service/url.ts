import { paramjson } from '../model/paramjson';

export namespace url {
  /**
   * パラメータを連想配列として今後利用する為、URLを連想配列に変更する
   * @param {string} query
   * @returns {paramjson}
   */
  export let getParam = (query: string): paramjson => {
    let json: paramjson = {};
    query.split('&').forEach(query => {
      let [key, value]: string[] = query.split('=');

      if (!Object.keys(json).length) {
        json[key] = [value];
      } else {
        if (Object.keys(json).indexOf(key) === -1) {
          json[key] = [value];
        } else {
          json[key].push(value);
        }
      }
    });
    return json;
  };

  /**
   * URLのクエリパラメータを取得できているか確認
   * @param {string} query
   * @returns {boolean}
   */
  export let checkParam = (query: string): boolean =>
    query !== undefined && query !== null && query !== '' && query !== ' ';

  /**
   * 連想配列の設定値を、aタグやformタグに設定する為、 <br />
   * urlのクエリパラメータと連想配列の設定値が完全一致するのもだけを取得する<br />
   * @param {string[]} keys
   * @param {paramjson} paramJson
   * @returns {paramjson}
   */
  export let containKey = (keys: string[], paramJson: paramjson): paramjson => {
    let paramJsonkeys: string[] = [];
    Object.keys(paramJson).forEach(paramJsonKey => {
      paramJsonkeys.push(paramJsonKey);
    });

    let resultJson: paramjson = {};

    for (let key of keys) {
      paramJsonkeys
        .filter(paramJsonkey => paramJsonkey === key)
        .map(paramJsonkey => {
          resultJson[paramJsonkey] = paramJson[paramJsonkey];
        });
    }

    return resultJson;
  };
}
