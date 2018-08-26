// http://127.0.0.1:8887/chap03/14_3.map_nan.html

'use strict';

/**
 * NaNは特別でない
 */
var m = new Map();
m.set(NaN, 'hoge');
console.log(m.get(NaN));
