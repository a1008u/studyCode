import { paramjson } from "../model/paramjson";

export namespace cookies  {

    // 正規表現を用いて、cookieに[_atpm]が存在しているか確認する
    export let hasItem = (sKey : string) => {
        return (new RegExp("(?:^|;\\s*)"
                + escape(sKey).replace(/[\-\.\+\*]/g, "\\$&")
                + "\\s*\\="))
                .test(document.cookie);
    };

    export let getItem = (sKey) => {
        if (!sKey || !hasItem(sKey)) { return null; }
        return unescape(document.cookie
                .replace(new RegExp("(?:^|.*;\\s*)"
                 + escape(sKey).replace(/[\-\.\+\*]/g, "\\$&")
                 + "\\s*\\=\\s*((?:[^;](?!;))*[^;]?).*")
                 , "$1"));
    };

    // Cookieから値を取得する
    export let getCookieJson = (key: string) : paramjson => {
        let value = getItem(key);
        if (value !== null) {
            let jsonCookies = JSON.parse(value);
            return jsonCookies;
        }
        return null;
    };

    export let setItem = (sKey, sValue, vEnd, sPath, sDomain, bSecure) => {
        if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) { return; }
        let sExpires = "";
        if (vEnd) {
            switch (vEnd.constructor) {
                case Number:
                    sExpires = vEnd === Infinity ? "; expires=Tue, 19 Jan 2038 03:14:07 GMT" : "; max-age=" + vEnd;
                    break;
                case String:
                    sExpires = "; expires=" + vEnd;
                    break;
                case Date:
                    sExpires = "; expires=" + vEnd.toGMTString();
                    break;
            }
        }
        // let h : string = `${escape(sKey)}=${escape(sValue)};domain=${(sDomain ? sDomain : "")}; path=${(sPath ? sPath : "")}${(bSecure ? "; secure" : "")}` ;
        document.cookie = `${escape(sKey)}=${escape(sValue)}; path=${(sPath ? sPath : "")}${(bSecure ? "; secure" : "")}` ;
    };

    // jsonを保持
    export let storeJsonInCookie = (paramjson: paramjson) => {
        setItem('_atpm', JSON.stringify(paramjson), Infinity, '/', location.hostname, false);
    };

}
