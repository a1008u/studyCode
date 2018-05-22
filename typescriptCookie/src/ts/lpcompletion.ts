import { itp }  from "./service/itp";
import { cookies } from "./service/cookies";
import { localstorage } from "./service/localstorage";
import { url } from "./service/url";
import { paramjson } from "./model/paramjson";
import { atag } from "./service/atag";
import { formtag } from "./service/formtag";

export namespace lpcompletion {

    //
    let getQueryParam = (paramJson: paramjson) : string[]  =>  {
        let formParam: string[] = [];
        Object.keys(paramJson).forEach((jsonKey) => {
            let key: string = jsonKey;
            let value: string = paramJson[jsonKey];
            if (decodeURIComponent(key) === '') return;
            if (decodeURIComponent(key) !== 'atnct') {
                formParam.push(`${key}=${value}`);
                return;
            }
            if (itp.hasITP(window.navigator.userAgent)) {
                formParam.push(`${key}=${value}`);
            }
        });
        return formParam;
    };

    //
    let confirmJson = (paramJson: paramjson) : boolean => {
        let count = 0;
        for (let i in paramJson) {
            ++count;
            if (paramJson[i] === undefined) {
                count = 0;
                break;
            }
        }
        return (count !== 0);
    };

    //
    let setParam = (keys : string[], paramJson: paramjson, beforeResult: boolean = false) : boolean => {
        if (!beforeResult) {
            if (!confirmJson(paramJson)) {
                return false;
            }

            let targetParamJson: paramjson = url.containKey(keys, paramJson);
            atag.setAtg(getQueryParam(targetParamJson));
            formtag.setFormtg(getQueryParam(targetParamJson));
            return true;
        }
        return false;
    };

    // 2-1 URLを取得の後ろにクエリがある場合は、URL取得処理 -> aタグやformタグ変換 -> localstorageとcookieに格納
    // 2-2 URLのクエリがない場合、localstorageを確認と取得 -> aタグやformタグ変換
    // 2-3　URLのクエリがないかつlocalstorageにもない場合、cookieを確認と取得 -> aタグやformタグ変換
    // ex:　2-1から3までで、ない場合はaタグやformタグ変換をせずに終了
    export let autoParamComplement = (keys : string[]) =>  {
        if (url.checkParam(location.search.substring(1))) {
            let paramJson: paramjson = url.getParam(location.search.substring(1));
            let result = setParam(keys, paramJson);
            if (result) {
                localstorage.storejsonInLocalStorage(paramJson);
                cookies.storeJsonInCookie(paramJson);
            }
            return 'we use URL';
        }

        let result = setParam(keys, localstorage.getLocalStorageJson('_atpm'));
        setParam(keys, cookies.getCookieJson('_atpm'), result);
        return 'we use localstorage or cookie';
    };

}

// 処理の流れ
// 1.jsのクエリを取得(検索用)
// 2.aタグやformタグのパラメータを変更
document.addEventListener('DOMContentLoaded',  (event)  => {

    // jsの後ろに付いているパラメータを取得
    let keys : string[] = (<any>window).keys || [];
    if (keys.length != 0) {
        console.log(lpcompletion.autoParamComplement(keys));
    }
}, false);

