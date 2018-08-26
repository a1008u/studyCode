'use strict';

var pet = {
  type: 'スノーホワイトハムスター',
  name: 'キラ',
  description: {
    birth: '2014-02-15'
  }
};

var pet2 = {
  name: '山田きら',
  color: '白',
  description: {
    food: 'ひまわりのタネ'
  }
};

var pet3 = {
  weight: 42,
  photo: 'http://www.wings.msn.to/img/ham.jpg'
};

Object.assign(pet, pet2, pet3);
console.log(pet);

// let merged = Object.assign({}, pet, pet2, pet3);
// console.log(merged);
