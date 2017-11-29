(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const usedom_1 = require("./usedom");
const usedom_2 = require("./usedom");
let calculateBirthday = function () {
    usedom_1.saveText();
    usedom_2.showText();
};
// 実行
let formButtonk = document.getElementById("formButtonk");
formButtonk.addEventListener("click", calculateBirthday, false);

},{"./usedom":2}],2:[function(require,module,exports){
"use strict";
// export class UseDom{
//
//     constructor(){}
//
//     // 入力された内容をローカルストレージに保存する
//     public saveText() {
//         // 時刻をキーにして入力されたテキストを保存する
//         let text:HTMLInputElement = <HTMLInputElement>document.getElementById("formText");
//         var time = new Date();
//         localStorage.setItem(time, text.value);
//         // テキストボックスを空にする
//         text.value=""
//     }
//
// // ローカルストレージに保存した値を再描画する
//     public showText() {
//         // すでにある要素を削除する
//         let list:HTMLInputElement = <HTMLInputElement>document.getElementById("list");
//         while (list.firstChild) list.removeChild(list.firstChild)
//
//         // ローカルストレージに保存された値すべてを要素に追加する
//         let key, value, html = [];
//         for(let i=0, len=localStorage.length; i<len; i++) {
//             key = localStorage.key(i);
//             value = localStorage.getItem(key);
//
//             let pTag = document.createElement("p")
//             pTag.textContent = value
//             list.appendChild(pTag);
//         }
//     }
// }
Object.defineProperty(exports, "__esModule", { value: true });
// 入力された内容をローカルストレージに保存する
function saveText() {
    // 時刻をキーにして入力されたテキストを保存する
    let text = document.getElementById("formText");
    var time = new Date();
    localStorage.setItem(time, text.value);
    // テキストボックスを空にする
    text.value = "";
}
exports.saveText = saveText;
// ローカルストレージに保存した値を再描画する
function showText() {
    // すでにある要素を削除する
    let list = document.getElementById("list");
    while (list.firstChild)
        list.removeChild(list.firstChild);
    // ローカルストレージに保存された値すべてを要素に追加する
    Object.keys(localStorage).forEach((key) => {
        let pTag = document.createElement("p");
        pTag.textContent = localStorage.getItem(key);
        list.appendChild(pTag);
    });
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
exports.showText = showText;

},{}]},{},[1])

//# sourceMappingURL=all.js.map
