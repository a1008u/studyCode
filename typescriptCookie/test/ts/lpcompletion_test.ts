import { lpcompletion } from '../../src/ts/lpcompletion';
import { paramjson } from '../../src/ts/model/paramjson';
import { localstorage } from '../../src/ts/service/localstorage';
import { cookies } from '../../src/ts/service/cookies';
import { url } from '../../src/ts/service/url';

const deleteLocalStorageAndCookies = (): void => {
  history.replaceState('', '', '');
  localStorage.clear();
  let date1: Date = new Date();
  date1.setTime(0);
  document.cookie = `_atpm=;expires=${date1.toUTCString()}`;
};

describe('【lpcompleteion1】のテスト', () => {
  beforeEach(() => {
    let s: HTMLScriptElement = document.createElement('script');
    s.innerHTML = "__attp=['test','test2']";
  });

  it('【cookie利用の確認】', () => {
    // before
    history.replaceState('', '', '');
    let paramjson: paramjson = { key: ['test'] };
    cookies.storeJsonInCookie(paramjson, 90);

    // spyを用いて、cookie取得メソッドが動くようにする
    spyOn(lpcompletion, 'autoParamComplement').and.callThrough();
    spyOn(url, 'checkParam').and.returnValue(false);
    spyOn(localstorage, 'getLocalStorageJson').and.returnValue(false);

    // execute
    let beforequeryList = [];
    let after: string = lpcompletion.autoParamComplement(beforequeryList);
    expect(after).toEqual('we use cookie');
  });

  it('【localstorage利用の確認】', () => {
    // before
    history.replaceState('', '', '');
    let testParamJson: paramjson = { key: ['test'] };
    localstorage.storeJsonInLocalStorage(testParamJson, 90);

    // spyを用いて、localStorage取得メソッドが動くようにする
    spyOn(lpcompletion, 'autoParamComplement').and.callThrough();
    spyOn(url, 'checkParam').and.returnValue(false);

    // execute
    let beforequeryList = [];
    let after: string = lpcompletion.autoParamComplement(beforequeryList);
    expect(after).toEqual('we use localstorage');
  });

  it('【URL+localstorage+cookieを利用をしてない確認】', () => {
    // spyを用いて、URL+localstorage+cookieで取得できないようにする
    spyOn(lpcompletion, 'autoParamComplement').and.callThrough();
    spyOn(url, 'checkParam').and.returnValue(false);
    spyOn(lpcompletion, 'setParam').and.returnValue(false);

    // execute
    let beforequeryList = [];
    // let after: string = autoParamComplement(beforequeryList);
    let after: string = lpcompletion.autoParamComplement(beforequeryList);
    expect(after).toEqual('nothing');
  });

  afterEach(() => {
    deleteLocalStorageAndCookies();
  });
});

describe('【lpcompleteion2】のテスト', () => {
  beforeEach(() => {
    deleteLocalStorageAndCookies();
    history.pushState(
      '',
      '',
      '?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=thisistest&not=thisisnottest'
    );
    let s: HTMLScriptElement = document.createElement('script');
    s.innerHTML = "__attp=['test','test2']";
  });

  // execute
  it('【URL利用】URLのQueryを用いて、処理を行えていることの確認', () => {
    let value1 = 'atnct';
    let value2 = 'this';
    let value3 = 'not';
    let beforequeryList = [`${value1}`, `${value2}`, `${value3}`];
    let after: string = lpcompletion.autoParamComplement(beforequeryList);
    expect(after).toEqual('we use URL');
  });

  afterEach(() => {
    deleteLocalStorageAndCookies();
  });
});
