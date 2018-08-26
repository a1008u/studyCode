'use strict';

var _marked = [myGenerator].map(regeneratorRuntime.mark);

function myGenerator() {
  return regeneratorRuntime.wrap(function myGenerator$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.next = 2;
          return 'あいうえお';

        case 2:
          _context.next = 4;
          return 'かきくけこ';

        case 4:
          _context.next = 6;
          return 'さしすせそ';

        case 6:
        case 'end':
          return _context.stop();
      }
    }
  }, _marked[0], this);
}

var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = myGenerator()[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var t = _step.value;

    console.log(t);
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
