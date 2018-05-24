import { formtag } from '../../../src/ts/service/formtag';

describe('【formtag】テスト', () => {
  // before
  let formId = 'testid';
  let beforeURL = 'http://example.com/';
  let form: HTMLFormElement = document.createElement('form');
  beforeEach(() => {
    form.action = beforeURL;
    form.method = 'post';
    form.id = formId;

    // すでにhiddenタグを保持している
    let inputElement: HTMLInputElement = document.createElement('input');
    inputElement.type = 'hidden';
    inputElement.name = 'test';
    inputElement.value = 'do not use';
    form.appendChild(inputElement);
    document.body.appendChild(form);
  });

  it('【formtagの設定確認】hiddenが設定されているかの確認', () => {
    // execute
    let value1 = 'aaaaaa';
    let value2 = 'bbbbbb';
    let value3 = 'cccccc';
    let beforequeryList = [
      `test1=${value1}`,
      `test2=${value2}`,
      `test3=${value3}`,
    ];
    formtag.setFormtg(beforequeryList);

    // URLが設定されていることを確認
    [].forEach.call(document.getElementsByName('test1'), afterFormtag1 => {
      expect(afterFormtag1.value).toEqual(value1);
    });
    [].forEach.call(document.getElementsByName('test2'), afterFormtag2 => {
      expect(afterFormtag2.value).toEqual(value2);
    });
    [].forEach.call(document.getElementsByName('test3'), afterFormtag3 => {
      expect(afterFormtag3.value).toEqual(value3);
    });
  });
});
