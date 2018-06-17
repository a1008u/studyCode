import { browser, element, by } from 'protractor';
import { paramjson } from '../../../src/ts/model/paramjson';
let fs = require('fs');

const writeScreenShot = (data, filename) => {
  let stream = fs.createWriteStream('./capture/safari/test1nesAndeu/' + filename);
  stream.write(new Buffer(data, 'base64'));
  stream.end();
};

const screeenShot = (i: number | string) => {
  browser.takeScreenshot().then(png => {
    writeScreenShot(png, `case_${i}.png`);
  });
};

describe('localStorageとCookieに未設定かつ[href="./html/bye.html?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google&not=thisisnottest"]】', () => {
  let width: number = 1440;
  let height: number = 900;
  beforeEach(function() {
    browser.driver
      .manage()
      .window()
      .setSize(width, height);

    // 非Angularのページの場合に必要
    browser.ignoreSynchronization = true;

    browser.get('https://localhost/');
    screeenShot('index');
  });

  // index.htmlの確認
  pageTitle('Hello');

  // ページ遷移の確認
  let exceptUrl: string = 'https://localhost/';
  checkUrl(exceptUrl);

  // storageの確認
  checkCookie('test1');
  checkLocalStorage('test1');

  it('atagの確認(answer1)', () => {
    let domainWiki: string = 'https://ja.wikipedia.org/wiki/TypeScript';
    let querry: string = '';
    let id : string = '#型アノーテーション';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer1'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =`${domainWiki}${querry}?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer1')).click();
        browser.sleep(1500);
        screeenShot('answer1');
      });
  });

  it('atagの確認(answer2)', () => {
    let domainWiki: string = 'https://ja.wikipedia.org/wiki/Kotlin';
    let querry: string = '?java=kotlin';
    let id: string = '#特徴';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer2'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =`${domainWiki}${querry}&atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer2')).click();
        browser.sleep(1000);
        screeenShot('answer2');
        console.log(' answer2------------ ' + targetHref);
      });
  });

  it('atagの確認(answer3)', () => {
    let domainWiki: string = 'https://localhost/index.html';
    let querry: string = '';
    let id: string = '';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer3'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domainWiki}${querry}?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer3')).click();
        browser.sleep(500);
        screeenShot('answer3');
        console.log(' answer3------------ ' + targetHref);
      });
  });

  it('atagの確認(answer4)', () => {
    let domainWiki: string = 'https://localhost/index.html';
    let querry: string = '?tomlike';
    let id: string = '';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer4'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domainWiki}${querry}&atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer4')).click();
        browser.sleep(500);
        screeenShot('answer4');
        console.log(' answer4------------ ' + targetHref);
      });
  });

  it('atagの確認(answer5)', () => {
    let domainWiki: string = 'https://localhost/index.html';
    let querry: string = '?rrr=test1243';
    let id: string = '';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer5'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domainWiki}${querry}&atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer5')).click();
        browser.sleep(500);
        screeenShot('answer5');
        console.log(' answer5------------ ' + targetHref);
      });
  });



  it('atagの確認(answer6)', () => {
    let domainWiki: string = 'https://localhost/index.html';
    let querry: string = '';
    let id: string = '#test';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer6'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domainWiki}${querry}?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer6')).click();
        browser.sleep(500);
        screeenShot('answer6');
        console.log(' answer6------------ ' + targetHref);
      });
  });

  it('atagの確認(answer7)', () => {
    let domain: string = 'https://localhost/index.html';
    let querry: string = '?te=tetete';
    let id: string = '#test';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer7'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domain}${querry}&atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer7')).click();
        browser.sleep(500);
        screeenShot('answer7');
        console.log(' answer7------------ ' + targetHref);
      });
  });

  it('atagの確認(answer8)', () => {
    let domain: string = '';
    let querry: string = '';
    let id: string = '#test';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer8'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${id}`;
        // expect(targetHref).toBe(exceptHref);
        element(by.id('answer8')).click();
        browser.sleep(500);
        screeenShot('answer8');
        console.log(' answer8------------ ' + targetHref);
      });
  });

  it('atagの確認(answer9)', () => {
    let domain: string = '';
    let querry: string = '';
    let id: string = '';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer9'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domain}${querry}mailto:info@example.com?subject=問い合わせ&body=ご記入ください${id}`;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer9')).click();
        browser.sleep(500);
        screeenShot('answer9');
        console.log(' answer9------------ ' + targetHref);
      });
  });

  it('atagの確認(answer10)', () => {
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer10'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = "javascript:alert('Hello');";
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer10')).click();
        browser.sleep(500);
        browser
          .switchTo()
          .alert()
          .accept();
        screeenShot('answer10');
        console.log(' answer10------------ ' + targetHref);
      });
  });

  it('atagの確認(answer11)', () => {
    let domain: string = 'https://localhost/img/ts.png';
    let querry: string = '';
    let id: string = '';
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element(by.id('answer11'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = `${domain}${querry}?atnct=reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142&test=microsoft&test=apple&test=google${id}`;;
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer11')).click();
        browser.sleep(500);
        screeenShot('answer11');
        console.log(' answer11------------ ' + targetHref);
      });
  });

  it('formの確認', () => {
    pageTitle('Hello');
    element(by.id('test1')).click();
    browser.sleep(500);
    element
      .all(by.name('atnct'))
      .getAttribute('value')
      .then((values: string) => {
      console.log(' answer11------------ ' + values);
      let exceptValues = [
        'reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142',
        'reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142'
      ];
      expect(values.length).toBe(exceptValues.length);
      expect(values).toEqual(exceptValues);
    });

    element
      .all(by.name('test'))
      .getAttribute('value')
      .then((values: string) => {
        console.log(' answer11------------ ' + values);
        let exceptValues = [
          'microsoft',
          'apple',
          'google',
          'microsoft',
          'apple',
          'google',
        ];
        expect(values.length).toBe(exceptValues.length);
        expect(values).toEqual(exceptValues);
      });
  });
});

function pageTitle(expectTitle: string) {
  it('画面遷移時の動作', () => {
    browser.getTitle().then(res => {
      expect(res).toEqual(expectTitle);
    });
  });
}

function checkUrl(exceptUrl: string) {
  it('遷移の確認', () => {
    element(by.id('test1')).click();
    browser.sleep(1000);

    //urlの確認
    browser
    .getCurrentUrl()
    .then(targetUrl => {
      expect(targetUrl).toEqual(exceptUrl);
    });
  });
}

function checkCookie(targetId: string) {
  it('Cookieの確認', () => {
    element(by.id(targetId)).click();
    browser.sleep(500);

    browser
      .manage()
      .getCookie('_atpm')
      .then(atpm => {
        let jsonData: paramjson = JSON.parse(unescape(atpm.value));
        const jsonkeys: string[] = Object.keys(jsonData);
        expect(jsonkeys.length).toBe(2);
        jsonkeys.forEach(key => {
          console.dir(`log ========== ${key} ---- ${jsonData[key]}`);
          if (key === 'test') {
            let except: string[] = ['microsoft', 'apple', 'google'];
            expect(jsonData[key]).toEqual(except);
          }
          if (key === 'atnct') {
            let except: string[] = [
              'reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142',
            ];
            expect(jsonData[key]).toEqual(except);
          }
        });
      });

    browser.manage().deleteAllCookies();

    browser
      .manage()
      .getCookie('_atpm')
      .then(atpm => {
        expect(atpm).toBe(null);
      });

    screeenShot('cookie');
  });
}

function checkLocalStorage(targetId: string) {
  it('localStorageの確認', () => {
    element(by.id(targetId)).click();
    browser.sleep(500);

    browser
      .executeScript("return window.localStorage.getItem('_atpm');")
      .then((atpm: string) => {
        let jsonData: paramjson = JSON.parse(atpm);
        console.log(` ++=++++++++== ${jsonData}`);
        const jsonkeys: string[] = Object.keys(jsonData);
        expect(jsonkeys.length).toBe(3);
        jsonkeys.forEach(key => {
          console.dir(`log ========== ${key} ---- ${jsonData[key]}`);
          if (key === 'test') {
            let except: string[] = ['microsoft', 'apple', 'google'];
            expect(jsonData[key]).toEqual(except);
          }
          if (key === 'atnct') {
            let except: string[] = [
              'reden_0100mn87000005-2ad9c0efe7e45eaa4895c28506c7a142',
            ];
            expect(jsonData[key]).toEqual(except);
          }
          if (key === 'deadline') {
            expect(jsonData[key]).not.toBeNull();
          }
        });
      });

    browser.executeScript('window.localStorage.clear();');

    browser
      .executeScript("return window.localStorage.getItem('_atpm');")
      .then((atpm: string) => {
        expect(atpm).toBe(null);
      });

    screeenShot('localStorage');
  });
}
