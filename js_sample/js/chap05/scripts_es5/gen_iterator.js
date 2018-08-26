'use strict';

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var MyIterator = function MyIterator(data) {
  _classCallCheck(this, MyIterator);

  this.data = data;
  this[Symbol.iterator] = regeneratorRuntime.mark(function _callee() {
    var current, that;
    return regeneratorRuntime.wrap(function _callee$(_context) {
      while (1) {
        switch (_context.prev = _context.next) {
          case 0:
            current = 0;
            that = this;

          case 2:
            if (!(current < that.data.length)) {
              _context.next = 7;
              break;
            }

            _context.next = 5;
            return that.data[current++];

          case 5:
            _context.next = 2;
            break;

          case 7:
          case 'end':
            return _context.stop();
        }
      }
    }, _callee, this);
  });
};

var itr = new MyIterator(['one', 'two', 'three']);
var _iteratorNormalCompletion = true;
var _didIteratorError = false;
var _iteratorError = undefined;

try {
  for (var _iterator = itr[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
    var value = _step.value;

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
