'use strict';

var data_ary = ['one', 'two', 'three'];
var itr = data_ary[Symbol.iterator]();
var d = void 0;
while (d = itr.next()) {
  if (d.done) {
    break;
  }
  console.log(d.done);
  console.log(d.value);
}
