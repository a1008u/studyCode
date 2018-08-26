"use strict";

var _marked = [genPrimes].map(regeneratorRuntime.mark);

function genPrimes() {
  var num;
  return regeneratorRuntime.wrap(function genPrimes$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          num = 2;

        case 1:
          if (!true) {
            _context.next = 8;
            break;
          }

          if (!isPrime(num)) {
            _context.next = 5;
            break;
          }

          _context.next = 5;
          return num;

        case 5:
          num++;
          _context.next = 1;
          break;

        case 8:
        case "end":
          return _context.stop();
      }
    }
  }, _marked[0], this);
}

function isPrime(value) {
  var prime = true;
  for (var i = 2; i <= Math.floor(Math.sqrt(value)); i++) {
    if (value % i === 0) {
      prime = false;
      break;
    }
  }
  return prime;
}

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = genPrimes()[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var value = _step.value;

    if (value > 100) {
      break;
    }
    console.log(value);
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
