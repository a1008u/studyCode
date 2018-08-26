// http://127.0.0.1:8887/chap02/48.forof.html
'use strict';

var data = ['apple', 'orange', 'banana'];

/**
 * イテレーター／ジェネレーターなども処理できるためです。
 * これらを総称して列挙可能なオブジェクトなどとも呼びます
 */
Array.prototype.hoge = function() {}
for (var value of data) {
  console.log(value);
}     // 結果：「apple」「orange」「banana」を順に出力


// Array.prototype.hoge = function () {};
// var _iteratorNormalCompletion = true;
// var _didIteratorError = false;
// var _iteratorError = undefined;

// try {
//   for (var _iterator = data[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
//     var j = _step.value;

//     console.log(j);
//   }
// } catch (err) {
//   _didIteratorError = true;
//   _iteratorError = err;
// } finally {
//   try {
//     if (!_iteratorNormalCompletion && _iterator.return) {
//       _iterator.return();
//     }
//   } finally {
//     if (_didIteratorError) {
//       throw _iteratorError;
//     }
//   }
// }

