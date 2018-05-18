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
    export let containKey = (keys: string[], paramJson: paramjson) : paramjson => {
        let paramJsonkeys : string[] = [];
        Object.keys(paramJson).forEach((paramJsonKey) => {
            paramJsonkeys.push(paramJsonKey);
        });

        let x : paramjson = {};
        for (let key of keys) {
            for (let paramJsonkey of paramJsonkeys) {
                if (paramJsonkey === key) {
                    x[paramJsonkey] = paramJson[paramJsonkey];
                    break;
                }
            }
        }
        return x;
    };

}
