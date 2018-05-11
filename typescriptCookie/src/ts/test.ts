namespace  dddom {
    export const useCookie = () =>{

        let [b, c] : string[] = getURL();
        console.log(`変更後::::${b}`);
        console.log(`変更後::::${c}`);

        // Cookie(作成(保持) - 確認 - 有効期限で削除)
        let count : string = new Date('2018/5/10 23:40').toUTCString();
        document.cookie = `test1=${b}; expires=${count}`;
        document.cookie = `test2=${c}; expires=${count}`;

        let cookieList : string[] = document.cookie.split(';');

        cookieList.forEach((cookie) => {
            let [_, value] : string[] = cookie.split('=');
            console.log( `cookieのバリュー：：：：${value}` );
        });
    };

    export const useLocalStorage = () =>{
        let [b, c] : string[] = getURL();
        console.log(`変更後::::${b}`);
        console.log(`変更後::::${c}`);

        // localstrage(作成(保持) - 確認 - 削除)
        let localKey1 : string = 'localStorageTest1';
        let localKey2 : string = 'localStorageTest2';

        localStorage.setItem(localKey1, `${b}`);
        localStorage.setItem(localKey2, `${c}`);

        console.log(`cookieのバリュー：：：：${localStorage.getItem(localKey1)}`);
        console.log(`cookieのバリュー：：：：${localStorage.getItem(localKey2)}`);

        localStorage.clear();
    };

    
    // 1.処理の流れ　aタグ formタグを見つける
    // 2.&で区切る(クエリーを区切る)
    // 3.=で区切る(key valueを分ける)
    // 4.atnctが付与しているvalueを取得
    // 5.valueをtagとrkに分けて保持
    // 6.
    export const aTagChange = () => {

        let a: string = location.search;
        console.log(`変更前::::${a}`)
        let queryList : string[] = a.substring(1).split("&");

        queryList.forEach( query => {

            let [b, c] : string[] = query.split("=")

            // 要素を取得
            let aElement : NodeListOf<HTMLAnchorElement> =  document.getElementsByTagName("a") ;

            // a要素のタグ名を取得 ( → "A" )
            let atagName : string = aElement[0].href;
            let changeName : string = atagName + '?' + b + '_' + c
            console.log(changeName);
            aElement[0].href = changeName;

        })
    }

    let getURL = () =>   {
        // URLからクエリパラメタを取得
        let a: string = location.search;
        console.log(`変更前::::${a}`)

        // クエリパラメタから必要な情報を取得
        return a.substring(1).split("=")
    };

    // HTMLの解釈が終了した時点で発火するイベント
    document.addEventListener('DOMContentLoaded',  (event)  => {
        console.log(' ______event: onLoad______');
    });
}

dddom.useCookie();
dddom.useLocalStorage();
dddom.aTagChange();



