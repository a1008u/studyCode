export namespace formtag {
  /**
   * formタグの場合は、hiddenとして保持させる
   * @param {string[]} formParam
   */
  export let setFormtg = (formParam: string[]) => {
    [].forEach.call(document.getElementsByTagName('form'), formTag => {
      if (formTag.method === 'post') {
        formParam.forEach(param => {
          let [key, value]: string[] = param.split('=');
          let inputElement: HTMLInputElement = document.createElement('input');
          inputElement.type = 'hidden';
          inputElement.name = key;
          inputElement.value = value;
          formTag.appendChild(inputElement);
        });
      } else {
        formParam.forEach(queryValue => {
          let formAction: string = formTag.action;
          if (formAction.indexOf('#') !== -1) {
            let [url, hash] = formAction.split('#');
            formTag.action =
              formAction.indexOf('?') !== -1
                ? `${url}&${queryValue}#${hash}`
                : `${url}?${queryValue}#${hash}`;
          } else {
            formTag.action =
              formAction.indexOf('?') === -1
                ? `${formAction}?${queryValue}`
                : `${formAction}&${queryValue}`;
          }
        });
      }
    });
  };
}
