'use strict';

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Member = function () {
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

var BusinessMember = function (_Member) {
  _inherits(BusinessMember, _Member);

  function BusinessMember(firstName, lastName, clazz) {
    _classCallCheck(this, BusinessMember);

    var _this = _possibleConstructorReturn(this, Object.getPrototypeOf(BusinessMember).call(this, firstName, lastName));

    _this.clazz = clazz;
    return _this;
  }

  _createClass(BusinessMember, [{
    key: 'getName',
    value: function getName() {
      return _get(Object.getPrototypeOf(BusinessMember.prototype), 'getName', this).call(this) + '／役職：' + this.clazz;
    }
  }]);

  return BusinessMember;
}(Member);

var bm = new BusinessMember('太郎', '山田', '課長');
console.log(bm.getName());
