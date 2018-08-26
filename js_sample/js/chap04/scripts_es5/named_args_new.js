"use strict";

function getTriangle(_ref) {
  var _ref$base = _ref.base;
  var base = _ref$base === undefined ? 1 : _ref$base;
  var _ref$height = _ref.height;
  var height = _ref$height === undefined ? 1 : _ref$height;

  return base * height / 2;
}

console.log(getTriangle({ base: 5, height: 4 }));
