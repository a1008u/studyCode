import { localstorage } from '../../../src/ts/service/localstorage';
import { paramjson } from '../../../src/ts/model/paramjson';

describe('【localstorage】保持と取得確認_正常系', () => {
  // before
  let testParamJson: paramjson = { key: 'test' };
  beforeEach(() => {
    localstorage.storeJsonInLocalStorage(testParamJson, 90);
  });

  it('localStorageに保持できているか確認', () => {
    // execute
    let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(paramJson).toEqual(testParamJson);
    for (let key in paramJson) {
      if (key === 'key') expect(paramJson[key]).toBe('test');
    }
  });

  // after
  afterEach(() => {
    localStorage.clear();
  });
});

describe('【localstorage】保持と取得確認_異常系', () => {
  it('localStorageに保持されていない場合、nullとなる', () => {
    // execute
    let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(paramJson).toEqual(null);
  });
});
