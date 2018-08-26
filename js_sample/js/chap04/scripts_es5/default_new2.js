"use strict";

function multi(a) {
  var b = arguments.length <= 1 || arguments[1] === undefined ? a : arguments[1];

  return a * b;
}
console.log(multi(10, 5));
console.log(multi(3));
