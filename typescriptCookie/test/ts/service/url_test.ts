import { url } from "../../../src/ts/service/url";
import {paramjson} from "../../../src/ts/model/paramjson";

describe('【url】getParamのテスト', () =>  {
    it('?を除くクエリパラメータを取得した場合、&と=でパラメタを連想配列にできている', () =>  {

        let paramJson : paramjson = url.getParam("key=test&key2=tom&iam3=sam");
        for (let key in paramJson) {
            if (key === 'key') expect(paramJson[key]).toBe('test');
            if (key === 'key2') expect(paramJson[key]).toBe('tom');
            if (key === 'iam3') expect(paramJson[key]).toBe('sam');
        }
    });

    it('?を除くクエリパラメータを取得した場合、&と=でパラメタを連想配列にするがkeyが同じ場合は上書きされる', () =>  {
        let paramJson : paramjson = url.getParam("key=test&key=tom&iam3=sam");
        for (let key in paramJson) {
            if (key === 'key') {
                expect(paramJson[key]).not.toBe('test');
                expect(paramJson[key]).toBe('tom');
                break;
            }
            if (key === 'iam3') expect(paramJson[key]).toBe('sam');
        }
    });
});

describe('【url】checkParamのテスト', () =>  {
    it('checkParamの引数設定場合trueを返す', () =>  {
        expect(url.checkParam("test")).toBe(true);
    });

    it('checkParamの引数設定しない場合falseを返す', () =>  {
        expect(url.checkParam("")).toBe(false);
    });
});

describe('【url】containKeyのテスト', () =>  {

    it('【keysとpreparaParamJsonのkeyに不一致の値を含む】keysに任意の値を入れて、任意のkeyだけを設定したjsonが取得できている確認', () =>  {
        let keys = ['key','key2','tom'];
        let prepareParamJson : paramjson = url.getParam("key=test&key2=tom&iam3=sam");
        let paramJson : paramjson = url.containKey(keys, prepareParamJson);

        // 取得元と取得先のjsonが同じでないことを確認
        expect(paramJson).not.toEqual(prepareParamJson);

        // keysで取得したくない値が設定していないことを確認
        expect(paramJson).not.toContain('tom');

        // paramJsonの方でも要求されていないkeyを含んでいないか確認
        expect(paramJson).not.toContain('iam3');

        // paramJsonには要求された　keyが取得されていること
        for (let key in paramJson) {
            if (key === 'key') expect(paramJson[key]).toBe('test');
            if (key === 'key2') expect(paramJson[key]).toBe('tom');
        }
    });

    it('【keysよりpreparaParamJsonのkeyが多い一致】keysに任意の値を入れて、任意のkeyだけを設定したjsonが取得できている確認', () =>  {
        let keys = ['key','key2'];
        let prepareParamJson : paramjson = url.getParam("key=test&key2=tom&iam3=sam");
        let paramJson : paramjson = url.containKey(keys, prepareParamJson);

        // 取得元と取得先のjsonが同じでないことを確認
        expect(paramJson).not.toEqual(prepareParamJson);

        // keysで取得したくない値が設定していないことを確認
        expect(paramJson).not.toContain('tom');

        // paramJsonの方でも要求されていないkeyを含んでいないか確認
        expect(paramJson).not.toContain('iam3');

        // paramJsonには要求された　keyが取得されていること
        for (let key in paramJson) {
            if (key === 'key') expect(paramJson[key]).toBe('test');
            if (key === 'key2') expect(paramJson[key]).toBe('tom');
        }
    });

    it('【keysとpreparaParamJsonのkeyが一致】keysに任意の値を入れて、任意のkeyだけを設定したjsonが取得できている確認', () =>  {
        let keys = ['key','key2','iam3'];
        let prepareParamJson : paramjson = url.getParam("key=test&key2=tom&iam3=sam");
        let paramJson : paramjson = url.containKey(keys, prepareParamJson);

        // 取得元と取得先のjsonが同じでないことを確認
        expect(paramJson).toEqual(prepareParamJson);

        // paramJsonには要求された　keyが取得されていること
        for (let key in paramJson) {
            if (key === 'key') expect(paramJson[key]).toBe('test');
            if (key === 'key2') expect(paramJson[key]).toBe('tom');
            if (key === 'iam3') expect(paramJson[key]).toBe('sam');
        }
    });
});

