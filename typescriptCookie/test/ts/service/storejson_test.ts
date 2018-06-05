import { cookies } from '../../../src/ts/service/cookies';
import { paramjson } from '../../../src/ts/model/paramjson';
import { storejson } from '../../../src/ts/service/storejson';
import { localstorage } from '../../../src/ts/service/localstorage';
import { lpcompletion } from '../../../src/ts/lpcompletion';

describe('【storejson】テスト', () => {
  // before
  let paramjson: paramjson = {};
  paramjson['test'] = 'testtt';
  let keys: string[] = ['test', 'non', 'zozo'];
  let atpm: string = '_atpm';
  let at: string = '_at';

  beforeEach(() => {
    let date1: Date = new Date();
    date1.setTime(0);
    document.cookie = `${at}=;expires=${date1.toUTCString()}`;
    document.cookie = `${atpm}=;expires=${date1.toUTCString()}`;
    localStorage.clear();
  });

  it('【localstorageとcookieに保存】正常系', () => {
    // execute
    storejson.set(paramjson, 3);
    let localstorageResult = lpcompletion.setParam(
      keys,
      localstorage.getLocalStorageJson('_atpm')
    );
    expect(localstorageResult).toEqual(true);

    let cookieResult = lpcompletion.setParam(
      keys,
      cookies.getCookieJson('_atpm')
    );
    expect(cookieResult).toEqual(true);
  });

  it('【localStorageの存在確認】 localstorageに存在する + cookieに存在しない', () => {
    // execute
    storejson.set(paramjson, 5);

    let localstorageResult = lpcompletion.setParam(
      keys,
      localstorage.getLocalStorageJson('_atpm')
    );
    expect(localstorageResult).toEqual(true);

    let date1: Date = new Date();
    date1.setTime(0);
    document.cookie = `${at}=;expires=${date1.toUTCString()}`;
    document.cookie = `${atpm}=;expires=${date1.toUTCString()}`;
    let cookieResult = lpcompletion.setParam(
      keys,
      cookies.getCookieJson('_atpm')
    );
    expect(cookieResult).toEqual(false);
  });

  it('【localStorageの存在確認】過去日(現在日より-3日)を設定し、取得できないことを確認', () => {
    // execute
    storejson.set(paramjson, -3);

    let localstorageResult = lpcompletion.setParam(
      keys,
      localstorage.getLocalStorageJson('_atpm')
    );
    expect(localstorageResult).toEqual(false);

    let cookieResult = lpcompletion.setParam(
      keys,
      cookies.getCookieJson('_atpm')
    );
    expect(cookieResult).toEqual(false);
  });

  it('【cookieの存在確認】localstorageに存在しない + cookieに存在する', () => {
    // execute
    storejson.set(paramjson, 5);
    localStorage.clear();
    let localstorageResult = lpcompletion.setParam(
      keys,
      localstorage.getLocalStorageJson('_atpm')
    );
    expect(localstorageResult).toEqual(false);

    let cookieResult = lpcompletion.setParam(
      keys,
      cookies.getCookieJson('_atpm')
    );
    expect(cookieResult).toEqual(true);
  });

  // after(念の為、cookieを削除)
  afterEach(() => {
    let date1: Date = new Date();
    date1.setTime(0);
    document.cookie = `${at}=;expires=${date1.toUTCString()}`;
    document.cookie = `${atpm}=;expires=${date1.toUTCString()}`;
    localStorage.clear();
  });
});
