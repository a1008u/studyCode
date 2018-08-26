// http://127.0.0.1:8887/chap02/18.dest_rest.html
"use strict";

var data = [56, 40, 26, 82, 19, 17, 73, 99];
var x0 = data[0];
var x1 = data[1];
var x2 = data[2];
var other = data.slice(3);

let [xx0, xx1, xx2, ...xxOther] = data;

console.log(`x0=${x0}  xx0=${xx0}`);
console.log(`x1=${x1}  xx1=${xx1}`);
console.log(`x2=${x2}  xx2=${xx2}`);
console.log(`other=${other}  xxOther=${xxOther}`);
