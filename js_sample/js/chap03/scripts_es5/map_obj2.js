// http://127.0.0.1:8887/chap03/14_5.map_obj2.html
'use strict';

/**
 * オブジェクトを変数にすることで、利用することができる
 */
var key = {};
var m = new Map();
m.set(key, 'hoge');
console.log(m.get(key));
