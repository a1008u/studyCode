// http://127.0.0.1:8887/chap03/14_4.map_obj.html
'use strict';

/**
 * オブジェクトでは参照での比較となる
 */
var m = new Map();
m.set({}, 'hoge');
console.log(m.get({}));
