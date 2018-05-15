import { itp as ITP }  from "./service/itp";
import { cookies } from "./service/cookies";
import { localstorage } from "./service/localstorage";
import { url } from "./service/url";
import { paramjson } from "./model/paramjson";

namespace lpcompletion {

    // jsの後ろについているクエリを取得する
    export let getTargetParams = () => {
        let keys: string[] = [];
        [].forEach.call(document.getElementsByTagName('script'), (script) => {
            let scriptSrc: string = script.src;
            if (scriptSrc != '') {
                let [jsfiles, querys] = scriptSrc.split('?');
                let jsfile: string[] = jsfiles.split('/');
                if (jsfile[jsfile.length - 1] === 'ts_bundle.js') {
                    let queryList: string[] = querys.split('&');
                    queryList.forEach(query => {
                        let [key, value]: string[] = query.split('=');
                        keys.push(value);
                    });
                    console.log(keys);
                }
            }
        });
        return keys;
    };


    export let setAtg = (paramJson: paramjson, keys: string[]) => {

        let queryValue : string = '';
        Object.keys(paramJson).forEach((jsonKey) => {
            let key: string = jsonKey;
            let value: string = paramJson[jsonKey];
            if (decodeURIComponent(key) !== '') {
                if (decodeURIComponent(key) === 'atnct') {
                    if(ITP.hasITP(window.navigator.userAgent)) {
                        queryValue += `${key}=${value}&`;
                    }
                } else {
                    queryValue += `${key}=${value}&`;
                }
            }
        });

        // a要素のタグ名を取得 ( → "A" )
        [].forEach.call(document.getElementsByTagName("a"), (aTag) => {
            console.log(`設定前(aタグ)：：：：：：${aTag.innerText}`);
            let baseAtag : string = aTag.href;
            let query: string = baseAtag.indexOf('?') == -1 ? `&${queryValue.slice( 0, -1 )}`: `?${queryValue.slice( 0, -1 )}`;
            let changeAtagName : string = baseAtag + query;
            console.log(`設定後(aタグ)：：：：：：${changeAtagName}`);
            aTag.href = changeAtagName;
        });
    };

    // Formタグの設定
    export let setFormtg = (paramJson: paramjson, keys: string[]) => {

        let formParam: string[] = [];
        Object.keys(paramJson).forEach((jsonKey) => {
            let key: string = jsonKey;
            let value: string = paramJson[jsonKey];
            if (decodeURIComponent(key) !== '') {
                if (decodeURIComponent(key) === 'atnct') {
                    if(ITP.hasITP(window.navigator.userAgent)) {
                        formParam.push(`${key}=${value}`);
                    }
                } else {
                    formParam.push(`${key}=${value}`);
                }
            }
        });

        // formタグ
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


}

// HTMLの解釈が終了した時点で発火するイベント
// 1.ITP対応のブラウザ確認
// 2.atnctにひもづく情報(tagとrk)を保持
// 3.localStrageに保持
// 4.Cookieに保持
// 5.atag確認 + 設定
// 6.form確認 + 設定
document.addEventListener('DOMContentLoaded',  (kes)  => {

    let keys = lpcompletion.getTargetParams();
    if (keys.length != 0) {
        let checkResult: boolean = url.checkParam(location.search.substring(1));
        // URLから取得
        if (checkResult) {
            let paramJson : paramjson = url.getParam(location.search.substring(1));
            if (url.containKey(paramJson, keys)) {
                localstorage.storejsonInLocalStorage(paramJson);
                cookies.storeJsonInCookie(paramJson);
                lpcompletion.setAtg(paramJson, keys);
                lpcompletion.setFormtg(paramJson, keys);
            }
        }　else {
            // localstorageから取得
            let paramJson : paramjson = localstorage.getLocalStrageJson('_atpm');
            if(paramJson) {
                lpcompletion.setAtg(paramJson, keys);
                lpcompletion.setFormtg(paramJson, keys);
            } else {
                // cookieから取得
                let paramJson2 : paramjson = cookies.getCookieJson('_atpm');
                if(paramJson2) {
                    lpcompletion.setAtg(paramJson2, keys);
                    lpcompletion.setFormtg(paramJson2, keys);
                }
            }
        }
    }
    console.log(window.navigator.userAgent);
    console.log(' ______event: onLoad______');
}, false);

