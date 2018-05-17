import {paramjson} from "../model/paramjson";

export namespace url  {
    export let getParam = (query: string) : paramjson => {
        let json: paramjson = {};
        query.split("&").forEach( query => {
            let [key, value] : string[] = query.split("=");
            json[key] = value;
        });
        return json;
    };

    export let checkParam = (query: string) : boolean => query !== '';

    // urlのクエリパラメータとjsのクエリパラメータが一致するか確認（完全一致）
    export let containKey = (paramJson: paramjson, keys: string[]) : boolean => {
        let result = true;

        let paramJsonkeys : string[] = [];
        Object.keys(paramJson).forEach((paramJsonKey) => {
            paramJsonkeys.push(paramJsonKey);
        });

        for (let key of keys) {
            if (paramJsonkeys.indexOf(key) == -1) {
                result = false;
                break;
            }
        }
        return result;
    };

}
