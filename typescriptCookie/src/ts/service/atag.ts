export namespace atag {
  // クエリを修正する必要があるか確認
  let modifyQuerry = (ahref: string): boolean => {
    if (ahref.indexOf('javascript') !== -1) {
      return false;
    }

    if (ahref.indexOf('mailto') !== -1) {
      return false;
    }

    if (ahref.slice(0, 1) === '#') {
      return false;
    }

    return true;
  };

  /**
   *
   * @param {string[]} queryValues
   */
  export let setAtg = (queryValues: string[]) => {
    [].forEach.call(document.getElementsByTagName('a'), aTag => {
      queryValues.forEach(queryValue => {
        let targetAtagHref: string = aTag.getAttribute('href');
        let need = modifyQuerry(targetAtagHref);
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
