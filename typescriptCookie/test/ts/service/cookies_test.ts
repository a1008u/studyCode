import { cookies } from "../../../src/ts/service/cookies";
import {paramjson} from "../../../src/ts/model/paramjson";

describe('【cookie】テスト', () =>  {


    // before
    let paramjson: paramjson = {key:'test'};
    beforeEach(() =>  {
        cookies.storeJsonInCookie(paramjson);
    });

    it('【cookieの設定および取得確認】存在するcookieを取得', () =>  {
        // execute
        let executeParamjston: paramjson = cookies.getCookieJson('_atpm');
        expect(executeParamjston).toEqual(paramjson);
    });

    it('【cookieの設定および取得確認】存在しないcookieを取得', () =>  {
        // execute
        let executeParamjston: paramjson = cookies.getCookieJson('_at');
        expect(executeParamjston).not.toEqual(paramjson);
    });

    // after
    afterEach(() =>  {
        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_at=;expires="+date1.toUTCString();
        document.cookie = "_atpm=;expires="+date1.toUTCString();
    });
});
