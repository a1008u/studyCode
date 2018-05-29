/**
 * 目的：Anchorタグを取得し、クエリ要素を追加する
 */
export namespace atag {
  // 早期リターンには、クエリ要素追加不可の条件を指定する
  let modifyQuerry = (ahref: string): boolean => {
    if (ahref.indexOf('javascript') !== -1) {
      return false;
    }

    if (ahref.indexOf('mailto') !== -1) {
      return false;
    }

    if (ahref.indexOf('ftp') !== -1) {
      return false;
    }

    if (ahref.indexOf('tel') !== -1) {
      return false;
    }

    if (ahref.indexOf('://') !== -1) {
      if (ahref.slice(0, 4) !== 'http' && ahref.slice(0, 5) !== 'https') {
        return false;
      }
    }

    if (ahref.length === 0) {
      return false;
    }

    return ahref.slice(0, 1) !== '#';
  };

  /**
   * クエリ要素を追加する必要があるか判定の上、ページ内遷移（ハッシュでの遷移）を考慮して、href属性に値を追加させる。
   * @param {string[]} queryValues
   */
  export let setAtg = (queryValues: string[]) => {
    [].forEach.call(document.getElementsByTagName('a'), aTag => {
      queryValues.forEach(queryValue => {
        let targetAtagHref: string = aTag.getAttribute('href');
        let need: boolean = modifyQuerry(targetAtagHref);
        if (need) {
          if (targetAtagHref.indexOf('#') !== -1) {
            let [url, hash] = aTag.getAttribute('href').split('#');
            aTag.href =
              targetAtagHref.indexOf('?') !== -1
                ? `${url}&${queryValue}#${hash}`
                : `${url}?${queryValue}#${hash}`;
          } else {
            aTag.href =
              targetAtagHref.indexOf('?') === -1
                ? `${targetAtagHref}?${queryValue}`
                : `${targetAtagHref}&${queryValue}`;
          }
        }
      });
    });
  };
}
