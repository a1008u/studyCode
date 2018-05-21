import {formtag} from "../../../src/ts/service/formtag";

describe('【formtag】テスト', () =>  {

    // before
    let formId = 'testid';
    let beforeURL = 'http://example.com/';
    let form : HTMLFormElement = document.createElement("form");
    beforeEach(() =>  {
        form.action = beforeURL;
        form.method = 'post';
        form.id = formId;
        document.body.appendChild(form);
    });

    it('【formtagの設定確認】hiddenが設定されているかの確認', () =>  {
        // execute
        let value1 = 'aaaaaa';
        let value2 = 'bbbbbb';
        let value3 = 'cccccc';
        let beforequeryList  = [`test1=${value1}`, `test2=${value2}`, `test3=${value3}`];
        formtag.setFormtg(beforequeryList);

        // URLが設定されていることを確認
        [].forEach.call(document.getElementsByName('test1'), (afterFormtag) => {
            expect(afterFormtag.value).toEqual(value1);
        });
        [].forEach.call(document.getElementsByName('test2'), (afterFormtag) => {
            expect(afterFormtag.value).toEqual(value2);
        });
        [].forEach.call(document.getElementsByName('test3'), (afterFormtag) => {
            expect(afterFormtag.value).toEqual(value3);
        });

    });

});
