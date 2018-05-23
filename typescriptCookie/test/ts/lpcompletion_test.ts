import {lpcompletion} from "../../src/ts/lpcompletion";
import autoParamComplement = lpcompletion.autoParamComplement;

describe('【lpcompleteion1】のテスト', () =>  {
    beforeEach(() =>  {
        history.pushState('', '', '');
        let s: HTMLScriptElement = document.createElement("script");
        s.innerHTML = "keys=['test','test2']";

        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_atpm=;expires="+date1.toUTCString();
        localStorage.clear();
    });

    // TODO
    it('【cookie利用の確認】', () =>  {
        // execute

    });

    // TODO
    it('【localstorage利用の確認】', () =>  {
        // execute

    });

    afterEach(() =>  {
        let date1 : Date = new Date();
        date1.setTime(0);
        document.cookie = "_atpm=;expires="+date1.toUTCString();
        localStorage.clear();
        history.replaceState('', '', '');
    });
});

describe('【lpcompleteion2】のテスト', () =>  {
    beforeEach(() =>  {
        history.pushState('', '', '?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=thisistest&not=thisisnottest');
        let s: HTMLScriptElement = document.createElement("script");
        s.innerHTML = "keys=['test','test2']";
    });

    it('【URL利用】URLのQueryを用いて、処理を行う', () =>  {
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
        history.replaceState('', '', '');
    });
});

