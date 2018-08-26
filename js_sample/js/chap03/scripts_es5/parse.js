// http://127.0.0.1:8887/chap03/7.parse.html
'use strict';

var n = '123xxx';
console.log(`nは ${n}`)
console.log(`new Number(n).valueOf() ${new Number(n).valueOf()}`); //NaN
console.log(`Number.parseFloat(n) ${Number.parseFloat(n)}`); //123
console.log(`Number.parseInt(n) ${Number.parseInt(n)}`); // 123

var d = new Date();
console.log(`dは ${d}`)
console.log(`new Number(d).valueOf() ${new Number(d).valueOf()}`); //日付の数値が出る
console.log(`Number.parseFloat(d) ${Number.parseFloat(d)}`); //NaN
console.log(`Number.parseInt(d) ${Number.parseInt(d)}`); //NaN

var h = '0x10';
console.log(`hは ${h}`)
console.log(`new Number(h).valueOf() ${new Number(h).valueOf()}`); // 16
console.log(`Number.parseFloat(h) ${Number.parseFloat(h)}`); // 0
console.log(`Number.parseInt(h) ${Number.parseInt(h)}`);// 16

var e = '1.01e+2';
console.log(`eは ${e}`)
console.log(`new Number(e).valueOf() ${new Number(e).valueOf()}`); //101
console.log(`Number.parseFloat(e) ${Number.parseFloat(e)}`); //101
console.log(`Number.parseInt(e) ${Number.parseInt(e)}`); //1
