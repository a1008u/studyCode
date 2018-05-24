import { paramjson } from '../model/paramjson';

export namespace url {
  /**
   * queryからparam(json状態)で取得
   * @param {string} query
   * @returns {paramjson}
   */
  export let getParam = (query: string): paramjson => {
    let json: paramjson = {};
    query.split('&').forEach(query => {
      let [key, value]: string[] = query.split('=');
      json[key] = value;
    });
    return json;
  };

  /**
   * 取得したqueryの確認
   * @param {string} query
   * @returns {boolean}
   */
  export let checkParam = (query: string): boolean => query !== '';

  /**
   * urlのクエリパラメータとjsのクエリパラメータが一致するか確認（完全一致）
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
      for (let paramJsonkey of paramJsonkeys) {
        if (paramJsonkey === key) {
          resultJson[paramJsonkey] = paramJson[paramJsonkey];
          break;
        }
      }
    }
    return resultJson;
  };
}
