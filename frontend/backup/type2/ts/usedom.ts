// 入力された内容をローカルストレージに保存する
export function saveText() {
    // 時刻をキーにして入力されたテキストを保存する
    let text:HTMLInputElement = <HTMLInputElement>document.getElementById("formText");
    var time = new Date();
    localStorage.setItem(time, text.value);

    // テキストボックスを空にする
    text.value=""
}

// ローカルストレージに保存した値を再描画する
export function showText() {
    // すでにある要素を削除する
    let list:HTMLInputElement = <HTMLInputElement>document.getElementById("list");
    while (list.firstChild) list.removeChild(list.firstChild)

    // ローカルストレージに保存された値すべてを要素に追加する
    Object.keys(localStorage).forEach((key) => { let pTag = document.createElement("p")
                                                           pTag.textContent = localStorage.getItem(key)
                                                           list.appendChild(pTag)
                                                         })

    // let key, value, html = [];
    // for(let i=0, len=localStorage.length; i<len; i++) {
    //     key = localStorage.key(i);
    //     value = localStorage.getItem(key);
    //
    //     let pTag = document.createElement("p")
    //     pTag.textContent = value
    //     list.appendChild(pTag);
    // }
}