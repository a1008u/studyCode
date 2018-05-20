export namespace formtag {
    export let setFormtg = (formParam: string[]) => {
        [].forEach.call(document.getElementsByTagName("form"), (formTag) => {
            console.log(formTag);
            formParam.forEach(param => {
                let [key, value]: string[] = param.split("=");
                let inputElement: HTMLInputElement = document.createElement('input');
                inputElement.type = 'hidden';
                inputElement.name = key;
                inputElement.value = value;
                formTag.appendChild(inputElement);
            });
        });
    };
}
