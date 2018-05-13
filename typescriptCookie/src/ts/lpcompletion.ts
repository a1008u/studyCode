import { itp as ITP }  from "./service/itp";
import {cookies, cookies as COOKIES} from "./service/cookies";
import { TargetObj } from "./model/TargetObj";
import { localstorage } from "./service/localstorage";
import { url } from "./service/url";

namespace lpcompletion {
    // Anchorタグの設定
    export let setAtg = (targetObj: TargetObj) => {
        // a要素のタグ名を取得 ( → "A" )
        [].forEach.call(document.getElementsByTagName("a"), (aTag) => {
            console.log(`設定前(aタグ)：：：：：：${aTag.innerText}`);
            let baseAtag : string = aTag.href;
            let query: string = `?_atnct=${targetObj.tag}_${targetObj.rk}`;
            let changeAtagName : string = baseAtag + query;
            console.log(`設定後(aタグ)：：：：：：${changeAtagName}`);
            aTag.href = changeAtagName;
        });
    };

    // Formタグの設定
    export let setFormtg = (targetObj: TargetObj) => {
        [].forEach.call(document.getElementsByTagName("form"), (formTag) => {
            console.log(formTag);
            let inputElement : HTMLInputElement = document.createElement('input');
            inputElement.type = 'hidden';
            inputElement.name = "_atnct";
            inputElement.value = targetObj.tag + "_" + targetObj.rk;
            formTag.appendChild(inputElement);
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
// TODO:document.domainとlocation.hostnameの違いを調べる
document.addEventListener('DOMContentLoaded',  (event)  => {
    if (ITP.hasITP(window.navigator.userAgent)) {
        let targetObj : TargetObj = url.getAtnctParam(location.search.substring(1));
        if (targetObj.rk !== '' && targetObj.tag !== '') {
            localstorage.storeRkInLocalStorage(targetObj);
            cookies.storeRkInCookie(targetObj, document.domain);
            lpcompletion.setAtg(targetObj);
            lpcompletion.setFormtg(targetObj);
        } else {
            let targetObj : TargetObj = localstorage.getLocalStrageParam('_atpm');
            if (targetObj.rk !== '' && targetObj.tag !== '') {
                lpcompletion.setAtg(targetObj);
                lpcompletion.setFormtg(targetObj);
            } else {
                let targetObj : TargetObj = cookies.getCookieParam('_atpm');
                if (targetObj.rk !== '' && targetObj.tag !== '') {
                    lpcompletion.setAtg(targetObj);
                    lpcompletion.setFormtg(targetObj);
                }
            }
        }
    }
    console.log(window.navigator.userAgent);
    console.log(' ______event: onLoad______');
});

