import {atag} from "../../../src/ts/service/atag";

describe('【atag】テスト', () =>  {

    let anchorId = 'testid';
    let beforeURL = 'http://example.com/';
    let anchor : HTMLAnchorElement = document.createElement("a");
    beforeEach(() =>  {
        anchor.href = beforeURL;
        anchor.id = anchorId;
        document.body.appendChild(anchor);
    });

    it('【atagの設定確認】?&を用いて、元々のaTagに設定ができているか確認', () =>  {
        // execute
        let beforequeryList  = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
        atag.setAtg(beforequeryList);

        // URLが設定されていることを確認
        let aTag : HTMLElement = document.getElementById(anchorId);
        let afterURL : string = aTag.getAttribute('href');
        expect(afterURL).not.toEqual(beforeURL);

        // 設定されているクエリが設定のものと一致するか確認
        if (afterURL !== null ) {
            let [url, querys] : string[] = afterURL.split('?');
            let afterqueryList :string[] = querys.split('&');
            expect(afterqueryList).toEqual(beforequeryList);
        }

    });

    it('【atagの設定確認】?&を用いて、元々のaTagに設定ができているか確認', () =>  {
        // before
        let anchorId2 = 'testid2';
        let beforeURL = 'http://example.com/';
        let anchor : HTMLAnchorElement = document.createElement("a");
        anchor.href = beforeURL;
        anchor.id = anchorId2;
        document.body.appendChild(anchor);

        // execute
        let beforequeryList  = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
        atag.setAtg(beforequeryList);

        // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
        [].forEach.call(document.getElementsByTagName("a"), (afterAtags) => {
            if (afterAtags.id == anchorId2) {
                let afterAtag = afterAtags.toString();
                let [url, afterquerys] : string[] = afterAtag.split('?');
                if (afterquerys.length >= 50) {
                    expect(afterAtag).toEqual('http://example.com/?test=aaaaaa&test2=sssssss&test3=ddddddd&test=aaaaaa&test2=sssssss&test3=ddddddd');
                    expect(afterquerys).toEqual('test=aaaaaa&test2=sssssss&test3=ddddddd&test=aaaaaa&test2=sssssss&test3=ddddddd');
                }
                if (afterquerys.length <= 50) {
                    expect(afterAtag).toEqual('http://example.com/?test=aaaaaa&test2=sssssss&test3=ddddddd');
                    expect(afterquerys).toEqual('test=aaaaaa&test2=sssssss&test3=ddddddd');
                }
            }
        });
    });
});
