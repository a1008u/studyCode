'use strict';

var member = {
  name: '山田太郎',
  birth: new Date(1970, 5, 25),
  toString: function toString() {
    return this.name + '／誕生日：' + this.birth.toLocaleDateString();
  }
};

console.log(member.toString());
