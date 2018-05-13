import {TargetObj} from "../model/TargetObj";
import { localstorageatpmjson as localStorageAtpmJson } from "../model/localstorageatpmjson";

export namespace localstorage {

    // localStorageに[atpm]として、連想配列（_atpm:::{jsonでパースした形の値({tag:rk})}）
    export let storeRkInLocalStorage = (targetObj: TargetObj) => {
        let lsJson : localStorageAtpmJson = JSON.parse(localStorage.getItem('_atpm')) || new localStorageAtpmJson();
        lsJson.tag = targetObj.tag;
        lsJson.rk = targetObj.rk;
        localStorage.setItem('_atpm', JSON.stringify(lsJson));
    };

    // localstorageから値を取得する
    export let getLocalStrageParam = (key: string) : TargetObj => {
        let value : string = localStorage.getItem(key);
        let tag: string ='';
        let rk: string ='';
        if (value !== null) {
            let jsonlocalStorage = JSON.parse(value);
            console.log(`cookieのバリュー：：：：${jsonlocalStorage}`);

            Object.keys(jsonlocalStorage).forEach(tmptag =>  {
                console.log(`[localstorage][item] == ${tmptag}`);
                console.log(`[localstorage]][value] == ${jsonlocalStorage[tmptag]}`);
                tag = tmptag;
                rk = jsonlocalStorage[tmptag];
                return;
            });
        }
        return new TargetObj(tag, rk);
    };

}
