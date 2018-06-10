import { browser, element, by } from 'protractor';
import { paramjson } from '../../src/ts/model/paramjson';
let fs = require('fs');

const writeScreenShot = (data, filename) => {
  let stream = fs.createWriteStream('./capture/test4nesAndeu/' + filename);
  stream.write(new Buffer(data, 'base64'));
  stream.end();
};

const screeenShot = (i: number | string) => {
  browser.takeScreenshot().then(png => {
    writeScreenShot(png, `StrongestCSSDesign_${i}.png`);
  });
};

describe('【localStorageとCookieに未設定かつ[href="./html/bye.html?test=apple&test=google" ]】', () => {
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
  let exceptUrl: string =
    'https://localhost/html/bye.html?test=apple&test=google';
  let clickId = 'test4';
  checkUrl(exceptUrl, clickId);

  // storageの確認
  checkCookie(clickId);
  checkLocalStorage(clickId);

  it('atagの確認(answer1)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest1'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://ja.wikipedia.org/wiki/TypeScript?test=apple&test=google#型アノーテーション';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer1')).click();
        screeenShot('answer1');
      });
  });

  it('atagの確認(answer2)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest2'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://ja.wikipedia.org/wiki/Kotlin?java=kotlin&test=apple&test=google#特徴';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer2')).click();
        screeenShot('answer2');
        console.log(' answer2------------ ' + targetHref);
      });
  });

  it('atagの確認(answer3)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest3'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = 'https://localhost/index.html?test=apple&test=google';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer3')).click();
        screeenShot('answer3');
        console.log(' answer3------------ ' + targetHref);
      });
  });

  it('atagの確認(answer4)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest4'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://localhost/index.html?tomlike&test=apple&test=google';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer4')).click();
        screeenShot('answer4');
        console.log(' answer4------------ ' + targetHref);
      });
  });

  it('atagの確認(answer5)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest5'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://localhost/index.html?rrr=test1243&test=apple&test=google';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer5')).click();
        screeenShot('answer5');
        console.log(' answer5------------ ' + targetHref);
      });
  });

  it('atagの確認(answer6)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest6'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://localhost/index.html?test=apple&test=google#test';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer6')).click();
        screeenShot('answer6');
        console.log(' answer6------------ ' + targetHref);
      });
  });

  it('atagの確認(answer7)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest7'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'https://localhost/index.html?te=tetete&test=apple&test=google#test';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer7')).click();
        screeenShot('answer7');
        console.log(' answer7------------ ' + targetHref);
      });
  });

  it('atagの確認(answer8)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.id('answer8'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = '#test';
        // expect(targetHref).toBe(exceptHref);
        element(by.id('answer8')).click();
        screeenShot('answer8');
        console.log(' answer8------------ ' + targetHref);
      });
  });

  it('atagの確認(answer9)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.linkText('atagTest9'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref =
          'mailto:info@example.com?subject=問い合わせ&body=ご記入ください';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer9')).click();
        screeenShot('answer9');
        console.log(' answer9------------ ' + targetHref);
      });
  });

  it('atagの確認(answer10)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.id('answer10'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = "javascript:alert('Hello');";
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer10')).click();
        browser.sleep(1000);
        browser
          .switchTo()
          .alert()
          .accept();
        screeenShot('answer10');
        console.log(' answer10------------ ' + targetHref);
      });
  });

  it('atagの確認(answer11)', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element(by.id('answer11'))
      .getAttribute('href')
      .then(targetHref => {
        let exceptHref = 'https://localhost/img/ts.png?test=apple&test=google';
        expect(unescape(decodeURIComponent(targetHref))).toBe(exceptHref);
        element(by.id('answer11')).click();
        browser.sleep(1000);
        screeenShot('answer11');
        console.log(' answer11------------ ' + targetHref);
      });
  });

  it('formの確認', () => {
    pageTitle('Hello');
    element(by.id(clickId)).click();
    element
      .all(by.name('test'))
      .getAttribute('value')
      .then((values: string) => {
        console.log(' answer11------------ ' + values);
        let exceptValues = ['apple', 'google', 'apple', 'google'];
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

function checkUrl(exceptUrl: string, clickId: string) {
  it('遷移の確認', () => {
    element(by.id(clickId)).click();

    // urlの確認
    browser.getCurrentUrl().then(targetUrl => {
      expect(targetUrl).toEqual(exceptUrl);
    });
  });
}

function checkCookie(targetId: string) {
  it('Cookieの確認', () => {
    element(by.id(targetId)).click();
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
            let except: string[] = ['apple', 'google'];
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
            let except: string[] = ['apple', 'google'];
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
