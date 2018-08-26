"use strict";

function getTriangle() {
  var base = arguments.length <= 0 || arguments[0] === undefined ? 1 : arguments[0];
  var height = arguments.length <= 1 || arguments[1] === undefined ? 1 : arguments[1];

  return base * height / 2;
}

console.log(getTriangle(5));
//console.log(getTriangle(5, null));
//console.log(getTriangle(5, undefined));
