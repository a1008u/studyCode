import { localstorage } from "../../../src/ts/service/localstorage";
import {paramjson} from "../../../src/ts/model/paramjson";

describe('【localstorage】テスト1', () =>  {

    // before
    let testParamJson: paramjson = {key:'test'};
    beforeEach(() => {
        localstorage.storejsonInLocalStorage(testParamJson);
    });

    it('localStorageに保持できているか確認', () =>  {
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

describe('【localstorage】テスト2', () =>  {
    it('localStorageに保持されていない場合、nullとなる', () =>  {
        // execute
        let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
        expect(paramJson).toEqual(null);
    });
});

