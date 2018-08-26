// http://127.0.0.1:8887/chap03/14_2.map_equal.html

'use strict';

/**
 * キーは「===」演算子で比較される
 */
var m = new Map();
m.set('1', 'hoge');
console.log(`m.get(1) ${m.get(1)}`);
console.log(`m.get('1') ${m.get('1')}`);