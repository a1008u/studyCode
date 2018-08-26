// http://127.0.0.1:8887/chap03/15_1.set.html

"use strict";

/**
 * インデックス番号やキーなどで要素にアクセスできない
 * 取得する際は、for-ofやhas(val)やvalues()を利用
 */
var s = new Set();
s.add(10);
s.add(5);
s.add(100);
s.add(50);
s.add(5);

//let s = new Set([10, 5, 100, 50, 5]);

console.log(s.has(100));
console.log(s.size);

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = s.values()[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var val = _step.value;

    console.log(val);
  }
} catch (err) {
  _didIteratorError = true;
  _iteratorError = err;
} finally {
  try {
    if (!_iteratorNormalCompletion && _iterator.return) {
      _iterator.return();
    }
  } finally {
    if (_didIteratorError) {
      throw _iteratorError;
    }
  }
}

var _iteratorNormalCompletion2 = true;
var _didIteratorError2 = false;
var _iteratorError2 = undefined;

try {
  for (var _iterator2 = s[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
    var _val = _step2.value;

    console.log(_val);
  }
} catch (err) {
  _didIteratorError2 = true;
  _iteratorError2 = err;
} finally {
  try {
    if (!_iteratorNormalCompletion2 && _iterator2.return) {
      _iterator2.return();
    }
  } finally {
    if (_didIteratorError2) {
      throw _iteratorError2;
    }
  }
}

s.delete(100);
console.log(s.size);

s.clear();
console.log(s.size);
