import { itp as ITP }  from "./service/itp";
import { cookies } from "./service/cookies";
import { localstorage } from "./service/localstorage";
import { url } from "./service/url";
import { paramjson } from "./model/paramjson";

namespace lpcompletion {
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
            if (ITP.hasITP(window.navigator.userAgent)) {
                formParam.push(`${key}=${value}`);
            }
        });
        return formParam;
    };

    let setAtg = (paramJson: paramjson) => {
        let queryValues : string[] = getQueryParam(paramJson);
        [].forEach.call(document.getElementsByTagName("a"), (aTag) => {
            queryValues.forEach(queryValue => {
                console.log(`設定前(aタグ)：：：：：：${aTag.innerText}`);
                let baseAtag : string = aTag.href;
                let query: string = aTag.href.indexOf('?') == -1 ? `?${queryValue.slice( 0, -1 )}`: `&${queryValue.slice( 0, -1 )}`;
                aTag.href += query;
                console.log(`設定後(aタグ)：：：：：：${aTag.href}`);
            })  
        });
    };

    let setFormtg = (paramJson: paramjson) => {
        let formParam : string[] = getQueryParam(paramJson);
        [].forEach.call(document.getElementsByTagName("form"), (formTag) => {
            console.log(formTag);
            formParam.forEach(param => {
                let [key ,value] : string[] = param.split("=");
                let inputElement : HTMLInputElement = document.createElement('input');
                inputElement.type = 'hidden';
                inputElement.name = key;
                inputElement.value = value;
                formTag.appendChild(inputElement);
            });
        });
    };

    let getParam = (keys : string[], paramJson: paramjson, beforeResult: boolean = false) : boolean => {
        if (paramJson && !beforeResult ) {
            let x: paramjson = url.containKey(keys, paramJson);
            setAtg(x);
            setFormtg(x);
            return true;
        }
        return false;
    };

    // jsの後ろについているクエリを取得する
    export let getJsParams = () => {
        let keys: string[] = [];
        [].forEach.call(document.getElementsByTagName('script'), (script) => {
            let scriptSrc: string = script.src;
            if (scriptSrc !== '') {
                let [jsfiles, querys] = scriptSrc.split('?');
                let jsfile: string[] = jsfiles.split('/');
                if (jsfile[jsfile.length - 1] === 'ts_bundle.js') {
                    querys.split('&').forEach(query => {
                        let [_, value]: string[] = query.split('=');
                        keys.push(value);
                    });
                    console.log(`jsに記載されているクエリ:::${keys}`);
                }
            }
        });
        return keys;
    };

    export let autoParamComplement = (keys : string[]) =>  {
        //　URL取得
        if (url.checkParam(location.search.substring(1))) {
            let paramJson: paramjson = url.getParam(location.search.substring(1));
            if (true) {
                localstorage.storejsonInLocalStorage(paramJson);
                cookies.storeJsonInCookie(paramJson);
                getParam(keys, paramJson);
            }
           return 'we use URL';
        }

        // localStorage or cookieから取得
        let result = getParam(keys, localstorage.getLocalStrageJson('_atpm'));
        getParam(keys, cookies.getCookieJson('_atpm'), result);

        return 'we use localstorage or cookie';
    };

}

// HTMLの解釈が終了した時点で発火するイベント
// 1.ITP対応のブラウザ確認
// 2.atnctにひもづく情報(tagとrk)を保持
// 3.localStrageに保持
// 4.Cookieに保持
// 5.atag確認 + 設定
// 6.form確認 + 設定
document.addEventListener('DOMContentLoaded',  (event)  => {

    // jsの後ろに付いているパラメータを取得（）
    let keys : string[] = lpcompletion.getJsParams();
    if (keys.length != 0) {
        console.log(lpcompletion.autoParamComplement(keys));
    }

    console.log(window.navigator.userAgent);
    console.log(' ______event: onLoad______');
}, false);

