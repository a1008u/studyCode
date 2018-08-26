(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var AUTHOR = 'YAMADA, Yoshihiro';

var Member = exports.Member = function () {
  function Member(firstName, lastName) {
    _classCallCheck(this, Member);

    this.firstName = firstName;
    this.lastName = lastName;
  }

  _createClass(Member, [{
    key: 'getName',
    value: function getName() {
      return this.lastName + this.firstName;
    }
  }]);

  return Member;
}();

var Area = exports.Area = function () {
  function Area() {
    _classCallCheck(this, Area);
  }

  _createClass(Area, null, [{
    key: 'getTriangle',
    value: function getTriangle(base, height) {
      return base * height / 2;
    }
  }, {
    key: 'getDiamond',
    value: function getDiamond(width, height) {
      return width * height / 2;
    }
  }]);

  return Area;
}();

},{}],2:[function(require,module,exports){
'use strict';

var _Util = require('./lib/Util');

var app = _interopRequireWildcard(_Util);

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

var m = new app.Member('太郎', '山田');
console.log(m.getName());

},{"./lib/Util":1}]},{},[2,1]);
