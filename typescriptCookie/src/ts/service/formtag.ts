export namespace formtag {
  /**
   * formタグの場合は、hiddenとして保持させる
   * @param {string[]} formParam
   */
  export let setFormtg = (formParam: string[]) => {
    [].forEach.call(document.getElementsByTagName('form'), formTag => {
      formParam.forEach(param => {
        let [key, value]: string[] = param.split('=');
        let inputElement: HTMLInputElement = document.createElement('input');
        inputElement.type = 'hidden';
        inputElement.name = key;
        inputElement.value = value;
        formTag.appendChild(inputElement);
      });
    });
  };
}
