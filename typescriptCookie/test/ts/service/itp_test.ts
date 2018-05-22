import { itp }  from "../../../src/ts/service/itp";

describe('【itp】containKeyのテスト1', () =>  {
    it('【mac_safari以外のブラウザ】', () =>  {
        let result: boolean  = itp.hasITP(window.navigator.userAgent);
        let ua = window.navigator.userAgent.toLowerCase();

        console.log(ua + ' ======== ' + result);
        if ((ua.indexOf('macintosh') === 1 || ua.indexOf('iphone') === 1 || ua.indexOf('ipad') === 1)
            && ua.indexOf('safari') !== 1) {
            expect(result).toBe(false);
        }
    });
});

describe('【itp】containKeyのテスト2', () =>  {
    it('【mac_safari】OSX10.3以上', () =>  {
        let result: boolean  = itp.hasITP(window.navigator.userAgent);
        let ua = window.navigator.userAgent.toLowerCase();

        console.log(ua);
        if ((ua.indexOf('macintosh') === 1 ) && ua.indexOf('safari') === 1) {

            let macVersion = ua.match(/mac os x 10_(\d{2})/);
            if (macVersion !== null && +macVersion[1] >= 13) {
                expect(result).toBe(true);
            }
        }
    });
});

describe('【itp】containKeyのテスト3', () =>  {
    it('【iphoneやipad_safari】OSX10.3以上', () =>  {
        let result: boolean  = itp.hasITP(window.navigator.userAgent);
        let ua = window.navigator.userAgent.toLowerCase();

        console.log(ua);
        if ((ua.indexOf('iphone') === 1 || ua.indexOf('ipad') === 1)
            && ua.indexOf('safari') === 1) {

            let iosVersion = ua.match(/os (\d{2})_/);
            if (iosVersion !== null && +iosVersion[1] >= 11) {
                expect(result).toBe(true);
            }
        }
    });
});

describe('【itp】containKeyのテスト4', () =>  {
    it('【mac以外_safari以外のブラウザ】', () =>  {
        let result: boolean  = itp.hasITP(window.navigator.userAgent);
        let ua = window.navigator.userAgent.toLowerCase();

        console.log(ua);
        if ((ua.indexOf('macintosh') === -1 || ua.indexOf('iphone') === -1 || ua.indexOf('ipad') === -1)
            && ua.indexOf('safari') === 1) {
            expect(result).toBe(false);
        }
    });
});

