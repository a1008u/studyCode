'use strict';

function required() {
  throw new Error('引数が不足しています');
}

function hoge() {
  var value = arguments.length <= 0 || arguments[0] === undefined ? required() : arguments[0];

  return value;
}

hoge();
