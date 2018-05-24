export namespace atag {
  /**
   *
   * @param {string[]} queryValues
   */
  export let setAtg = (queryValues: string[]) => {
    [].forEach.call(document.getElementsByTagName('a'), aTag => {
      queryValues.forEach(queryValue => {
        console.log(`設定前(aタグ)：：：：：：${aTag.innerText}`);
        aTag.href +=
          aTag.href.indexOf('?') === -1 ? `?${queryValue}` : `&${queryValue}`;
        console.log(`設定後(aタグ)：：：：：：${aTag.href}`);
      });
    });
  };
}
