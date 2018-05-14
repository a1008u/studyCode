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

    // COOKIES.setItem('_atpm', JSON.stringify(ck), Infinity, '/', '.' + hsname, false);
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

        let h : string = `${escape(sKey)}=${escape(sValue)};domain=${(sDomain ? sDomain : "")}; path=${(sPath ? sPath : "")}${(bSecure ? "; secure" : "")}` ;
        document.cookie = h;

        // %7B%22reden%22%3A%220100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142%22%2C%22_hostname%22%3A%22localhost%22%7D
        // _atpm = {"reden":"0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142","_hostname":"localhost"}　今の
        // _atpm = {"tag":"reden","rk":"0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142","hostname":"localhost"} ゴール
    };

    // hostnameを既存と同じにするなら、location.hostnameを利用する。。。
    // しかし、今回は サブドメインのみ利用するので、サブドメイン検索をする必要がある。
    export let storeJsonInCookie = (paramjson: paramjson) => {
        if (hasItem('_atpm')) {
            // Cookie が取得できれば、以前保存できた hostname の値を使い domain を指定する
            let json : paramjson = JSON.parse(getItem('_atpm'));
            json = paramjson;
            setItem('_atpm', JSON.stringify(json), Infinity, '/', location.hostname, false);
        } else {
            // Cookie が取得できない場合は、www.google.com など先頭部分を取り除いたドメインで Cookie を保存する
            // google.com など先頭を取り除いた場合うまく保存できなかった場合は、取り除かず保存する
            let json : paramjson = {};
            json = paramjson;
            setItem('_atpm', JSON.stringify(json), Infinity, '/', location.hostname, false);
        }
        console.log('cookie保持完了')
    };

};
