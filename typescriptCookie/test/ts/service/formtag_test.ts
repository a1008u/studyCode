import { formtag } from '../../../src/ts/service/formtag';


let makeForm = (formId:string,beforeURL:string,method:string, form: HTMLFormElement) =>  {
    form.action = beforeURL;
    form.method = method;
    form.id = formId;

    // すでにhiddenタグを保持している
    if (method === 'post') {
        let inputElement: HTMLInputElement = document.createElement('input');
        inputElement.type = 'hidden';
        inputElement.name = 'test';
        inputElement.value = 'do not use';
        form.appendChild(inputElement);
    }
    document.body.appendChild(form);
}

describe('【formtag】テスト', () => {
  // before
  let beforeURL = 'http://example.com/';
    let beforeURL2 = 'http://example.com?test=kkkk';
    let beforeURL3 = 'http://example.com?test=kkkk#test';
    let beforeURL4 = 'http://example.com#test';
    let beforeURL5 = 'http://example.com';
  beforeEach(() => {
      makeForm('testformid', beforeURL,'post' ,document.createElement('form'));
      makeForm('testformid2', beforeURL2,'get' ,document.createElement('form'));
      makeForm('testformid3', beforeURL3,'get' ,document.createElement('form'));
      makeForm('testformid4', beforeURL4,'get' ,document.createElement('form'));
      makeForm('testformid5', beforeURL5,'get' ,document.createElement('form'));
  });

  it('【formtagの設定確認】hiddenが設定されているかの確認', () => {
    // execute
    let value1 = 'aaaaa';
    let value2 = 'bbbbb';
    let value3 = 'ccccc';
    let beforequeryList = [
      `testform1-1=${value1}`,
      `testform1-2=${value2}`,
      `testform1-3=${value3}`,
    ];
    formtag.setFormtg(beforequeryList);

    // URLが設定されていることを確認
    [].forEach.call(document.getElementsByName('testform1-1'), afterFormtag1 => {
      expect(afterFormtag1.value).toEqual(value1);
    });
    [].forEach.call(document.getElementsByName('testform1-2'), afterFormtag2 => {
      expect(afterFormtag2.value).toEqual(value2);
    });
    [].forEach.call(document.getElementsByName('testform1-3'), afterFormtag3 => {
      expect(afterFormtag3.value).toEqual(value3);
    });

  });

    it('【formtagの設定確認】actionが設定されているかの確認', () => {
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

        [].forEach.call(document.getElementById('testformid2'), afterFormtag => {
            expect(afterFormtag.action).toEqual('http://example.com?test=kkkk&test1=aaaaaa&test2=bbbbbb&test3=cccccc');
        });
        [].forEach.call(document.getElementById('testformid3'), afterFormtag => {
            expect(afterFormtag.action).toEqual('http://example.com?test=kkkk&test1=aaaaaa&test2=bbbbbb&test3=cccccc#test');
        });
        [].forEach.call(document.getElementById('testformid4'), afterFormtag => {
            expect(afterFormtag.action).toEqual('http://example.com?test1=aaaaaa&test2=bbbbbb&test3=cccccc#test');
        });
        [].forEach.call(document.getElementById('testformid5'), afterFormtag => {
            expect(afterFormtag.action).toEqual('http://example.com?test1=aaaaaa&test2=bbbbbb&test3=cccccc');
        });

    });

});

// describe('【formtag】テスト(methodがget)', () => {
//     // before
//     let beforeURL2 = 'http://example.com?test=kkkk';
//     let beforeURL3 = 'http://example.com?test=kkkk#test';
//     beforeEach(() => {
//
//     });
//
//     it('【formtagの設定確認】actionの確認', () => {
//         // execute
//         let value1 = 'aaaaaa';
//         let value2 = 'bbbbbb';
//         let value3 = 'cccccc';
//         let beforequeryList = [
//             `test1=${value1}`,
//             `test2=${value2}`,
//             `test3=${value3}`,
//         ];
//         formtag.setFormtg(beforequeryList);
//
//         // URLが設定されていることを確認
//         [].forEach.call(document.getElementById('testid2'), afterFormtag => {
//             expect(afterFormtag.action).toEqual('http://example.com?test=kkkk&test1=aaaaaa&test2=bbbbbb&test3=cccccc');
//         });
//         [].forEach.call(document.getElementById('testid3'), afterFormtag => {
//             expect(afterFormtag.action).toEqual('http://example.com?test=kkkk&test1=aaaaaa&test2=bbbbbb&test3=cccccc#test');
//         });
//     });
// });
