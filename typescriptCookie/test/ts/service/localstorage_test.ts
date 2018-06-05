import { localstorage } from '../../../src/ts/service/localstorage';
import { paramjson } from '../../../src/ts/model/paramjson';

describe('【localstorage】保持と取得確認_正常系', () => {
  // before
  let testParamJson: paramjson = { key: 'test' };
  let deadline: number = 90;
  let day = new Date();
  day.setDate(day.getDate() + deadline);
  beforeEach(() => {
    localstorage.storeJsonInLocalStorage(testParamJson, 90);
  });

  it('localStorageに保持できているか確認', () => {
    // execute
    let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(paramJson).toEqual(testParamJson);
    for (let key in paramJson) {
      if (key === 'key') expect(paramJson[key]).toBe('test');
      if (key === 'deadline') {
        paramJson['deadline'] = day.toISOString();
        let afterTime = new Date(paramJson[key]);
        expect(afterTime.getTime()).toBe(day.getTime());
      }
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
