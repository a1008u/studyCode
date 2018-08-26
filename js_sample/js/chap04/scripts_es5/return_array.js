"use strict";

var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

function getMaxMin() {
  return [Math.max.apply(Math, arguments), Math.min.apply(Math, arguments)];
}

var result = getMaxMin(10, 35, -5, 78, 0);
console.log(result);

var _getMaxMin = getMaxMin(10, 35, -5, 78, 0);

var _getMaxMin2 = _slicedToArray(_getMaxMin, 2);

var max = _getMaxMin2[0];
var min = _getMaxMin2[1];
//let [,min] = getMaxMin(10, 35, -5, 78, 0);

console.log(max);
console.log(min);
