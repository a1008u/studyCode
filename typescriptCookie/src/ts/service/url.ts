// urlのクエリパラメータからatnctを取得
import {TargetObj} from "../model/TargetObj";

export namespace url  {
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
}
