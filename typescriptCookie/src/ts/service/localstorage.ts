import { paramjson } from "../model/paramjson";

export namespace localstorage {

    export let storejsonInLocalStorage = (paramJson: paramjson ) => {
        let json : paramjson = JSON.parse(localStorage.getItem('_atpm')) || {};
        json = paramJson;
        localStorage.setItem('_atpm', JSON.stringify(json));
    };

    export let getLocalStrageJson = (key: string) : paramjson => {
        let value : string = localStorage.getItem(key);
        if (value !== null) {
            let jsonlocalStorage : paramjson = JSON.parse(value);
            return jsonlocalStorage;
        }
        return null;
    };

}
