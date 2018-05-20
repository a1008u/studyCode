import { cookies } from "../../../src/ts/service/cookies";
import {paramjson} from "../../../src/ts/model/paramjson";

describe('【cookie】テスト', () =>  {

    it('【cookieの設定および取得確認】存在するcookieを取得', () =>  {
        // before
        let paramjson: paramjson = {key:'test'};
        cookies.storeJsonInCookie(paramjson);

        let executeParamjston: paramjson = cookies.getCookieJson('_atpm');
        expect(executeParamjston).toEqual(paramjson);

        // after
        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_atpm=;expires="+date1.toUTCString();
    });

    it('【cookieの設定および取得確認】存在しないcookieを取得', () =>  {
        // before
        let paramjson: paramjson = {key:'test'};
        cookies.storeJsonInCookie(paramjson);

        let executeParamjston: paramjson = cookies.getCookieJson('_at');
        expect(executeParamjston).not.toEqual(paramjson);

        // after
        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_at=;expires="+date1.toUTCString();
        document.cookie = "_atpm=;expires="+date1.toUTCString();
    });


});
