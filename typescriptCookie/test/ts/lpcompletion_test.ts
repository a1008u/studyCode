import {lpcompletion} from "../../src/ts/lpcompletion";
import autoParamComplement = lpcompletion.autoParamComplement;

describe('【lpcompleteion】のテスト', () =>  {
    beforeEach(() =>  {
        history.pushState('', '', '?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=thisistest&not=thisisnottest');
        let s: HTMLScriptElement = document.createElement("script");
        s.innerHTML = "keys=['test','test2']";
    });

    it('【url利用の確認】', () =>  {
        // execute
        let value1 = 'atnct';
        let value2 = 'this';
        let value3 = 'not';
        let beforequeryList  = [`${value1}`, `${value2}`, `${value3}`];
        let after : string = autoParamComplement(beforequeryList);
        expect(after).toEqual('we use URL');


    });

    afterEach(() =>  {
        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_atpm=;expires="+date1.toUTCString();
        localStorage.clear();
    });
});