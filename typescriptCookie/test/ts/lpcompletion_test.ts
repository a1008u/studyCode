import { lpcompletion } from "../../src/ts/lpcompletion";

describe('【lpcompletion】テスト', () =>  {

    it('【jsの後ろのquery取得】正確に取得できている', () =>  {
        // before
        [].forEach.call(document.getElementsByTagName("head"), (head) => {
            let scriptElement : HTMLScriptElement = document.createElement('script');
            scriptElement.src = './ts_bundle.js?key=&key=test2';
            head.appendChild(scriptElement);
        });
        let params : string[] =lpcompletion.getJsParams();
        console.log(params);
        expect(params.length).toBe(2);
        for (let param of params) {
            if (param === '') {
                expect(param).toBe('');
                break;
            }
            expect(param).toBe('test2');
        }


    });

    // it('【jsの後ろのquery取得】正確に取得できない', () =>  {
    //     // before
    //     [].forEach.call(document.getElementsByTagName("head"), (head) => {
    //         let scriptElement : HTMLScriptElement = document.createElement('script');
    //         scriptElement.src = './ts_bundle.js?key=test2&key=test2&key=test2';
    //         head.appendChild(scriptElement);
    //     });
    //     let params : string[] =lpcompletion.getJsParams();
    //     expect(params.length).toBe(3);
    // });
});


