"use strict";

function getTriangle() {
  var base = arguments.length <= 0 || arguments[0] === undefined ? 1 : arguments[0];
  var height = arguments[1];

  return base * height / 2;
}

console.log(getTriangle(10));
