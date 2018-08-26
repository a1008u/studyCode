// http://127.0.0.1:8887/chap02/21.dest_obj2.html
'use strict';

var book = { title: 'Javaポケットリファレンス '
            , publish: '技術評論社'
            , price: 2680
            , other: { keywd: 'Java SE 8', logo: 'logo.jpg' } };
var title = book.title;
var other = book.other;
var keywd = book.other.keywd;

let {xtitle, xother, xother2:{keywd}} = book;

console.log(`titleは${title} xtitleは${xtitle}`);
console.log(`otherは${other} xotherは${xother}`);
console.log(`keywdは${keywd} xother2.keywdは${xother2.keywd}`);
