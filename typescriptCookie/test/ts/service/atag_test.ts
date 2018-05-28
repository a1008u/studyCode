import { atag } from '../../../src/ts/service/atag';

describe('【atag】作成テスト', () => {
  // before(事前にanchorタグを作成する) <a id="testid" href="http://example.com/"></a>
  let anchorId = 'testid';
  let beforeURL = 'http://example.com/';
  let anchor: HTMLAnchorElement = document.createElement('a');
  beforeEach(() => {
    anchor.href = beforeURL;
    anchor.id = anchorId;
    document.body.appendChild(anchor);
  });

  it('【atagの設定確認】?&を用いて、元々のaTagに設定ができているか確認', () => {
    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(http://example.com/?test=aaaaaa&test2=sssssss&test3=ddddddd)
    let aTag: HTMLElement = document.getElementById(anchorId);
    let afterURL: string = aTag.getAttribute('href');
    expect(afterURL).not.toEqual(beforeURL);

    // 設定されているクエリが設定のものと一致するか確認
    if (afterURL !== null) {
      let [_, querys]: string[] = afterURL.split('?');
      let afterqueryList: string[] = querys.split('&');
      expect(afterqueryList).toEqual(beforequeryList);
    }
  });

  it('【atagの設定確認】?&を用いて、元々のaTagに設定ができているか確認', () => {
    // before(事前にanchorタグを作成する) <a id="testid2" href="http://example2.com/"></a>
    let anchorId2 = 'testid2';
    let beforeURL = 'http://example2.com/';
    let anchor: HTMLAnchorElement = document.createElement('a');
    anchor.href = beforeURL;
    anchor.id = anchorId2;
    document.body.appendChild(anchor);

    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
    [].forEach.call(document.getElementsByTagName('a'), afterAtags => {
      if (afterAtags.id === anchorId2) {
        let afterAtag = afterAtags.toString();
        let [_, afterquerys]: string[] = afterAtag.split('?');
        if (afterquerys.length >= 50) {
          // すでに?がある場合は、&を付ける
          expect(afterAtag).toEqual(
            'http://example2.com/?test=aaaaaa&test2=sssssss&test3=ddddddd&test=aaaaaa&test2=sssssss&test3=ddddddd'
          );
          expect(afterquerys).toEqual(
            'test=aaaaaa&test2=sssssss&test3=ddddddd&test=aaaaaa&test2=sssssss&test3=ddddddd'
          );
        }
        if (afterquerys.length <= 50) {
          // ?がないので、?を付けているか確認
          expect(afterAtag).toEqual(
            'http://example2.com/?test=aaaaaa&test2=sssssss&test3=ddddddd'
          );
          expect(afterquerys).toEqual(
            'test=aaaaaa&test2=sssssss&test3=ddddddd'
          );
        }
      }
    });
  });

  it('【atagの設定】hrefが「https://ja.wikipedia.org/wiki/Kotlin?java=kotlin#test」', () => {
    // before(事前にanchorタグを作成する) <a id="testid8" href="https://ja.wikipedia.org/wiki/Kotlin?java=kotlin#test"></a>
    let anchorId8 = 'testid8';
    let beforeURL = 'https://ja.wikipedia.org/wiki/Kotlin?java=kotlin#test';
    let anchor: HTMLAnchorElement = document.createElement('a');
    anchor.href = beforeURL;
    anchor.id = anchorId8;
    document.body.appendChild(anchor);

    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
    [].forEach.call(document.getElementsByTagName('a'), afterAtags => {
      if (afterAtags.id === anchorId8) {
        let afterAtag = afterAtags.toString();
        let [_, afterquerys]: string[] = afterAtag.split('?');
        expect(afterAtag).not.toEqual(beforeURL);
        expect(afterAtag).toEqual(
          'https://ja.wikipedia.org/wiki/Kotlin?java=kotlin&test=aaaaaa&test2=sssssss&test3=ddddddd#test'
        );
      }
    });
  });

  it('【atagの設定】hrefが「https://ja.wikipedia.org/wiki/Kotlin#test」', () => {
    // before(事前にanchorタグを作成する) <a id="testid9" href="https://ja.wikipedia.org/wiki/Kotlin#test"></a>
    let anchorId9 = 'testid9';
    let beforeURL = 'https://ja.wikipedia.org/wiki/Kotlin#test';
    let anchor: HTMLAnchorElement = document.createElement('a');
    anchor.href = beforeURL;
    anchor.id = anchorId9;
    document.body.appendChild(anchor);

    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
    [].forEach.call(document.getElementsByTagName('a'), afterAtags => {
      if (afterAtags.id === anchorId9) {
        let afterAtag = afterAtags.toString();
        let [_, afterquerys]: string[] = afterAtag.split('?');
        expect(afterAtag).not.toEqual(beforeURL);
        expect(afterAtag).toEqual(
          'https://ja.wikipedia.org/wiki/Kotlin?test=aaaaaa&test2=sssssss&test3=ddddddd#test'
        );
      }
    });
  });

  it('【atagの設定できない確認】hrefが「javascript」', () => {
    // before(事前にanchorタグを作成する) <a id="testid3" href="javascript..."></a>
    let anchorId3 = 'testid3';
    let beforeURL = "javascript:alert('Hello');";
    let anchor: HTMLAnchorElement = document.createElement('a');
    anchor.href = beforeURL;
    anchor.id = anchorId3;
    document.body.appendChild(anchor);

    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
    [].forEach.call(document.getElementsByTagName('a'), afterAtags => {
      if (afterAtags.id === anchorId3) {
        let afterAtag = afterAtags.toString();
        let [_, afterquerys]: string[] = afterAtag.split('?');
        expect(afterAtag).toEqual(beforeURL);
      }
    });
  });

  it('【atagの設定できない確認】hrefが「mailto」', () => {
    // before(事前にanchorタグを作成する) <a id="testid5" href="mailto..."></a>
    let anchorId5 = 'testid5';
    let beforeURL = 'mailto:info@example.com';
    let anchor: HTMLAnchorElement = document.createElement('a');
    anchor.href = beforeURL;
    anchor.id = anchorId5;
    document.body.appendChild(anchor);

    // execute
    let beforequeryList = ['test=aaaaaa', 'test2=sssssss', 'test3=ddddddd'];
    atag.setAtg(beforequeryList);

    // URLが設定されていることを確認(?がある場合は、&とする。?がない場合は、?をつける)
    [].forEach.call(document.getElementsByTagName('a'), afterAtags => {
      if (afterAtags.id === anchorId5) {
        let afterAtag = afterAtags.toString();
        let [_, afterquerys]: string[] = afterAtag.split('?');
        expect(afterAtag).toEqual(beforeURL);
      }
    });
  });
});
