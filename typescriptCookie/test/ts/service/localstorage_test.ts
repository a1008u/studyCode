import { localstorage } from "../../../src/ts/service/localstorage";
import {paramjson} from "../../../src/ts/model/paramjson";

describe('【localstorage】テスト', () =>  {

    it('localStorageに保持できているか確認', () =>  {

        // before
        let testParamJson: paramjson = {key:'test'};
        localstorage.storejsonInLocalStorage(testParamJson);

        // execute
        let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
        expect(paramJson).toEqual(testParamJson);
        for (let key in paramJson) {
            if (key === 'key') expect(paramJson[key]).toBe('test');
        }

        // after
        localStorage.clear();
    });

    it('localStorageに保持されていない場合、nullとなる', () =>  {
        // execute
        let paramJson: paramjson = localstorage.getLocalStorageJson('_atpm');
        expect(paramJson).toEqual(null);
    });

});

