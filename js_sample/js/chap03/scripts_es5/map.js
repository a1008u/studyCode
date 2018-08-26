// http://127.0.0.1:8887/chap03/14_1.map.html

'use strict';

var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

/**
 * オブジェクトリテラルとの違い
 * 1.任意の型でキーを設定できる
 *  オブジェクトリテラル：キーは文字列だけ利用できる
 *  Mapオブジェクト：任意の型をキーとして利用できる
 * 
 * 2.マップのサイズを取得できる
 *  オブジェクトリテラル：取得できない
 *  Mapオブジェクト：sizeプロパティを使って、登録されたキー／値の個数を取得できる
 * 
 * 3.クリーンなマップを生成できる
 *  オブジェクトリテラル：Objectオブジェクトのため、Objectオブジェクトのプロパティを保持している
 *  Mapオブジェクト：完全にからの連想配列を生成できる
 */


/**
 *  初期化　
 * 1.setでくっ付ける
 * 2.newの際に引数とする
 */ 
var m = new Map();
m.set('dog', 'ワンワン');
m.set('cat', 'ニャー');
m.set('mouse', 'チュー');

//let m = new Map([['dog', 'ワンワン'],['cat', 'ニャー'],['mouse', 'チュー']]);

console.log(m.size);
console.log(m.get('dog'));
console.log(m.has('cat'));

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = m.keys()[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var key = _step.value;

    console.log(key);
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
  for (var _iterator2 = m.values()[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
    var value = _step2.value;

    console.log(value);
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

var _iteratorNormalCompletion3 = true;
var _didIteratorError3 = false;
var _iteratorError3 = undefined;

try {
  for (var _iterator3 = m[Symbol.iterator](), _step3; !(_iteratorNormalCompletion3 = (_step3 = _iterator3.next()).done); _iteratorNormalCompletion3 = true) {
    var _step3$value = _slicedToArray(_step3.value, 2);

    var _key = _step3$value[0];
    var _value = _step3$value[1];

    console.log(_value);
  }
} catch (err) {
  _didIteratorError3 = true;
  _iteratorError3 = err;
} finally {
  try {
    if (!_iteratorNormalCompletion3 && _iterator3.return) {
      _iterator3.return();
    }
  } finally {
    if (_didIteratorError3) {
      throw _iteratorError3;
    }
  }
}

m.delete('dog');
console.log(m.size);

m.clear();
console.log(m.size);
