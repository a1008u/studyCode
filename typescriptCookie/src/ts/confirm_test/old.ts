import { itp as ITP }  from "../service/itp";
import { cookies as COOKIES }  from "../service/cookies";
import { TargetObj } from "../model/TargetObj";

namespace lpcompletion {
    // urlのクエリパラメータからatnctを取得
    export let getAtnctParam = (query: string) : TargetObj => {
        let queryList : string[] = query.split("&");
        let tag: string ='';
        let rk: string ='';
        queryList.forEach( query => {
            // 各queryパラメタを取得
            let [key, value] : string[] = query.split("=")
            if (decodeURIComponent(key) === 'atnct') {
                let [tmptag, tmprk]: string[] = decodeURIComponent(value).split('_');
                tag = tmptag;
                rk = tmprk;
                return;
            }
        });
        return new TargetObj(tag, rk);
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

            // for (let tmptag in jsonlocalStorage) {
            //     console.log(`[localstorage][item] == ${tmptag}`);
            //     console.log(`[localstorage]][value] == ${jsonlocalStorage[tmptag]}`);
            //     tag = tmptag;
            //     rk = jsonlocalStorage[tmptag];
            // }
        }
        return new TargetObj(tag, rk);
    };

    // Cookieから値を取得する
    export let getCookieParam = (key: string) : TargetObj => {
        let value = COOKIES.getItem(key);
        let tag = '';
        let rk = '';
        if (value !== null) {
            let jsonCookies = JSON.parse(value);
            Object.keys(jsonCookies).forEach(tmptag =>  {
                console.log(`[localstorage][item] == ${tmptag}`);
                console.log(`[localstorage]][value] == ${jsonCookies[tmptag]}`);
                tag = tmptag;
                rk = jsonCookies[tmptag];
                return;
            });

            // for (let tmptag in jsonCookies) {
            //     if (tmptag !== '_hostname') {
            //         console.log(`[cookie][item] == ${tmptag}`);
            //         console.log(`[cookie][value] == ${jsonCookies[tmptag]}`);
            //         tag = tmptag;
            //         rk = jsonCookies[tmptag];
            //     }
            // }
        }
        return new TargetObj(tag, rk);
    };

    let trimFront = (hostname) :string => {
        let domains = hostname.split('.');
        let domainFirst = domains.shift();
        console.log(domainFirst);
        return domains.join('.');
    };

    // TODO:サブドメインのみで保持できるようにする
    //
    export let storeRkInCookie = (targetObj: TargetObj, hostname :string) => {
        if (COOKIES.hasItem('_atpm')) {
            // Cookie が取得できれば、以前保存できた hostname の値を使い domain を指定する
            let ck = JSON.parse(COOKIES.getItem('_atpm'));
            let hsname = ck._hostname || hostname;
            ck[targetObj.tag] = targetObj.rk;
            COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + hsname, false);
        } else {
            // Cookie が取得できない場合は、www.google.com など先頭部分を取り除いたドメインで Cookie を保存する
            // google.com など先頭を取り除いた場合うまく保存できなかった場合は、取り除かず保存する
            let ck = {};
            ck[targetObj.tag] = targetObj.rk;
            ck['_hostname'] = trimFront(hostname);
            COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + trimFront(hostname), false);
            if (!COOKIES.hasItem('_atpm')) {
                ck['_hostname'] = hostname;
                COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + hostname, false);
            }

            let count : string = new Date('2018/5/20 23:40').toUTCString();
            document.cookie = `test1=ttttttt; expires=${count}`;
        }
    };

    // export let storeRkInCookie = (targetObj: TargetObj, href :string) => {
    //     if (COOKIES.hasItem('_atpm')) {
    //         // Cookie が取得できれば、以前保存できた hostname の値を使い domain を指定する
    //         let ck = JSON.parse(COOKIES.getItem('_atpm'));
    //         let hsname = ck._hostname || hostname;
    //         ck[targetObj.tag] = targetObj.rk;
    //         COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + hsname, false);
    //     } else {
    //         // Cookie が取得できない場合は、www.google.com など先頭部分を取り除いたドメインで Cookie を保存する
    //         // google.com など先頭を取り除いた場合うまく保存できなかった場合は、取り除かず保存する
    //         let ck = {};
    //         ck[targetObj.tag] = targetObj.rk;
    //         ck['_hostname'] = trimFront(hostname);
    //         COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + trimFront(hostname), false);
    //         if (!COOKIES.hasItem('_atpm')) {
    //             ck['_hostname'] = hostname;
    //             COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + hostname, false);
    //         }
    //     }
    // };

    // localStorageに[atpm]として、連想配列（_atpm:::{jsonでパースした形の値({tag:rk})}）
    export let storeRkInLocalStorage = (targetObj: TargetObj) => {
        let ls = JSON.parse(localStorage.getItem('_atpm')) || {};
        ls[targetObj.tag] = targetObj.rk;
        localStorage.setItem('_atpm', JSON.stringify(ls));
    };

    // Anchorタグの設定
    export let setAtg = (targetObj: TargetObj) => {
        // a要素のタグ名を取得 ( → "A" )
        [].forEach.call(document.getElementsByTagName("a"), (aTag) => {
            console.log(aTag.innerText);
            let baseAtag : string = aTag.href;
            let query: string = '?' + "_atnct=" + targetObj.tag + "_" + targetObj.rk
            let changeAtagName : string = baseAtag + query;
            console.log(`設定後：：：：：：${changeAtagName}`);
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
document.addEventListener('DOMContentLoaded',  (event)  => {
    if (ITP.hasITP(window.navigator.userAgent)) {

        let targetObj : TargetObj = lpcompletion.getAtnctParam(location.search.substring(1));
        if (targetObj.rk !== '' && targetObj.tag !== '') {
            lpcompletion.storeRkInLocalStorage(targetObj);
            lpcompletion.storeRkInCookie(targetObj, location.href);
            lpcompletion.setAtg(targetObj);
            lpcompletion.setFormtg(targetObj);
        } else {
            let targetObj : TargetObj = lpcompletion.getLocalStrageParam('_atpm');
            if (targetObj.rk !== '' && targetObj.tag !== '') {
                lpcompletion.setAtg(targetObj);
                lpcompletion.setFormtg(targetObj);
            } else {
                let targetObj : TargetObj = lpcompletion.getCookieParam('_atpm');
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

interface atpmJson {
    tag : string;
    rk : string;
    hostname: string;
}
