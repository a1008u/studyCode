import { cookies } from '../src/ts/service/cookies';
import { paramjson } from '../src/ts/model/paramjson';
import { localstorage } from '../src/ts/service/localstorage';

document.addEventListener(
  'DOMContentLoaded',
  event => {
    // URL
    console.log('++++++++ URL ++++++++');
    let query: string = location.search.substring(1);
    console.log(`設定クエリ ----- ${query}`);

    // cookie
    console.log('++++++++ cookie ++++++++');
    let cookieparamJson: paramjson = cookies.getCookieJson('_atpm');
    if (cookieparamJson === null) {
      console.log('cookieは設定されていません');
    } else {
      Object.keys(cookieparamJson).forEach(key => {
        console.log(`key --- ${key} ___ value --- ${cookieparamJson[key]}`);
      });
    }

    // localstorage
    console.log('++++++++ localstorage ++++++++');
    let localstorageparamJson: paramjson = localstorage.getLocalStorageJson(
      '_atpm'
    );

    if (localstorageparamJson === null) {
      console.log('localstorageは設定されていません');
    } else {
      Object.keys(localstorageparamJson).forEach(key => {
        console.log(
          `key --- ${key} ___ value --- ${localstorageparamJson[key]}`
        );
      });
    }

    // atag
    console.log('++++++++ atag ++++++++');
    [].forEach.call(document.getElementsByTagName('a'), aTag => {
      console.log(
        `value --- ${aTag.innerText} ___ href --- ${aTag.getAttribute('href')}`
      );
    });

    // form
    console.log('++++++++ form(hidden) ++++++++');
    [].forEach.call(document.getElementsByTagName('input'), hiddenTag => {
      console.log(`name --- ${hiddenTag.getAttribute('name')} ___ value --- ${hiddenTag.getAttribute('value')}`);
    });

      console.log('++++++++ form(action) ++++++++');
    [].forEach.call(document.getElementsByTagName('form'), formTag => {
      console.log(`action --- ${formTag.getAttribute('action')}`);
    });

    console.log(
      '======================================================================='
    );
  },
  false
);
