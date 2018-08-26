// http://127.0.0.1:8887/chap02/22.dest_obj3.html
'use strict';

var book = { title: 'Javaポケットリファレンス '
            , publish: '技術評論社' };
var name = book.title;
var company = book.publish;

let { btitle, bpublish } = book;

console.log(`nameは${name} btitleは${btitle}`);
console.log(`companyは${company} bpublishは${bpublish}`);
