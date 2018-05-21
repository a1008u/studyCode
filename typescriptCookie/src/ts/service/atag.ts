export namespace atag {
    export  let setAtg = (queryValues : string[]) => {
        [].forEach.call(document.getElementsByTagName("a"), (aTag) => {
            queryValues.forEach(queryValue => {
                console.log(`設定前(aタグ)：：：：：：${aTag.innerText}`);
                let query: string = aTag.href.indexOf('?') == -1 ? `?${queryValue}`: `&${queryValue}`;
                aTag.href += query;
                console.log(`設定後(aタグ)：：：：：：${aTag.href}`);
            })
        });
    };
}
