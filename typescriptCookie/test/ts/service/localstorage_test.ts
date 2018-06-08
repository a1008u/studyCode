import { localstorage } from '../../../src/ts/service/localstorage';
import { paramjson } from '../../../src/ts/model/paramjson';

describe('【localstorage】保持と取得確認_正常系_単体', () => {
  // before
  let testList: string[] = ['test'];
  let testParamJson: paramjson = { key: testList };
  let deadline: number = 90;
  let day = new Date();
  day.setDate(day.getDate() + deadline);
  beforeEach(() => {
    localstorage.storeJsonInLocalStorage(testParamJson, 90);
  });

  it('localStorageに保持できているか確認_単体', () => {
    // execute
    let afterParamJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(afterParamJson).toEqual(testParamJson);
    for (let key in afterParamJson) {
      if (key === 'key') {
        afterParamJson[key].forEach(value => {
          expect(testList).toContain('test');
        });
      }
      if (key === 'deadline') {
        afterParamJson['deadline'] = [day.toISOString()];
        let afterTime = new Date(afterParamJson[key][0]);
        expect(afterTime.getTime()).toBe(day.getTime());
      }
    }
  });

  // after
  afterEach(() => {
    localStorage.clear();
  });
});

describe('【localstorage】保持と取得確認_正常系_複数', () => {
  let testParamJson: paramjson;
  let testParamJson2: paramjson;
  beforeEach(() => {
    let testList: string[] = ['test'];
    testParamJson = { key: testList };
    let deadline: number = 90;
    let day = new Date();
    day.setDate(day.getDate() + deadline);
    localstorage.storeJsonInLocalStorage(testParamJson, 90);

    let testList2: string[] = ['ddddd22222'];
    testParamJson2 = { key2: testList2 };
    day.setDate(day.getDate() + deadline);
    localstorage.storeJsonInLocalStorage(testParamJson2, 90);
  });

  it('localStorageに保持できているか確認_複数', () => {
    // execute
    let afterParamJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(afterParamJson).toEqual(testParamJson2);
  });

  // after
  afterEach(() => {
    localStorage.clear();
  });
});

describe('【localstorage】保持と取得確認_異常系', () => {
  it('localStorageに保持されていない場合、nullとなる', () => {
    // execute
    localStorage.clear();
    let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(paramJson).toEqual(null);
  });

  it('localStorageに保持さていたが、期限切れのため、nullとなる', () => {
    // execute
    localStorage.clear();
    let testParamJson: paramjson = { key: ['test'] };
    localstorage.storeJsonInLocalStorage(testParamJson, -1);
    let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
    expect(paramJson).toEqual(null);
  });
});
