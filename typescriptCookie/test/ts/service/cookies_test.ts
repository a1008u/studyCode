import { cookies } from '../../../src/ts/service/cookies';
import { paramjson } from '../../../src/ts/model/paramjson';
import { storejson } from '../../../src/ts/service/storejson';

describe('【cookie】テスト_配列の中身が単体', () => {
  // before
  let paramjson: paramjson = { key: ['test'] };
  storejson.setDeadline(paramjson, 90);
  beforeEach(() => {
    cookies.storeJsonInCookie(paramjson, 90, storejson.deleteDeadline);
  });

  let atpm: string = '_atpm';
  let at: string = '_at';

  it('【cookieの設定および取得確認】cookieに存在する値(Json)を取得', () => {
    // execute
    let executeParamjston: paramjson = cookies.getCookieJson(atpm);
    Object.keys(executeParamjston).forEach(key => {
      expect(executeParamjston[key][0]).toEqual('test');
      expect(executeParamjston['deadline']).toEqual(undefined);
    });
  });

  it('【cookieの設定および取得確認】cookieに存在しない値(Json)を取得', () => {
    // execute
    let executeParamjston: paramjson = cookies.getCookieJson(at);
    expect(executeParamjston).not.toEqual(paramjson);
  });

  // after(念の為、cookieを削除)
  afterEach(() => {
    let date1: Date = new Date();
    date1.setTime(0);
    document.cookie = `${at}=;expires=${date1.toUTCString()}`;
    document.cookie = `${atpm}=;expires=${date1.toUTCString()}`;
  });
});

describe('【cookie】テスト_配列の中身が複数', () => {
  // before
  let testlist: string[] = ['test1', 'test2'];
  let paramjson: paramjson = { key: testlist };
  beforeEach(() => {
    cookies.storeJsonInCookie(paramjson, 90, storejson.deleteDeadline);
  });

  let atpm: string = '_atpm';
  let at: string = '_at';

  it('【cookieの設定および取得確認】cookieに存在する値(Json)を取得', () => {
    // execute
    let executeParamjston: paramjson = cookies.getCookieJson(atpm);
    expect(executeParamjston['deadline']).toEqual(undefined);
    executeParamjston['key'].forEach(value => {
      expect(testlist).toContain(value);
    });
  });

  // after(念の為、cookieを削除)
  afterEach(() => {
    let date1: Date = new Date();
    date1.setTime(0);
    document.cookie = `${at}=;expires=${date1.toUTCString()}`;
    document.cookie = `${atpm}=;expires=${date1.toUTCString()}`;
  });
});
