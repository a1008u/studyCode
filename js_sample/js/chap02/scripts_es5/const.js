// http://127.0.0.1:8887/chap02/6.const.html
"use strict";

// ミュータブルはよろしくないので、イミュータブルにしましょうよって、constを
var TAX = 1.08;
var price = 100;
console.log(price * TAX);

const CTAX = 1.08;
const Cprice = 100;
console.log(Cprice * CTAX);