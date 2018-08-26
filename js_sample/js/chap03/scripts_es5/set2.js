// http://127.0.0.1:8887/chap03/15_2.set.html

"use strict";

var s = new Set();
s.add(NaN);
s.add(NaN);
console.log(s.size);

s.add({});
s.add({});
console.log(s.size);
