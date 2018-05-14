import {paramjson} from "../model/paramjson";

export namespace url  {
    //
    export let getParam = (query: string) : paramjson => {
        let queryList : string[] = query.split("&");
        let json: paramjson = {};
        queryList.forEach( query => {
            let [key, value] : string[] = query.split("=");
            json[key] = value;
        });
        return json;
    };

    export let checkParam = (query: string) : boolean => query !== '';

    export let containKey = (paramJson: paramjson, keys: string[]) => {
        let result = false;
        for (let key of keys) {
            if ((key in paramJson)) {
                result = true;
                break;
            }
        }
        return result;
    };

}
