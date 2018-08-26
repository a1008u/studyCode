// http://127.0.0.1:8887/chap02/7.template.html
'use strict';

var name = '鈴木';
var str = 'こんにちは、' + name + 'さん。\n今日も良い天気ですね！';
console.log(str);

let strTemp = `こんにちは、${name}さん。\n今日も良い天気ですね！`
console.log(strTemp);

let strTemp2 = `こんにちは、${name}さん。
今日も良い天気ですね！`
console.log(strTemp2);