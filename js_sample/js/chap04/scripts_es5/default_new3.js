"use strict";

function multi() {
  var a = arguments.length <= 0 || arguments[0] === undefined ? b : arguments[0];
  var b = arguments.length <= 1 || arguments[1] === undefined ? 5 : arguments[1];

  return a * b;
}

console.log(multi());
