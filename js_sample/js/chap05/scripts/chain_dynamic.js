var Animal = function() {};

Animal.prototype = {
  walk : function() {
    console.log('トコトコ...');
  }
};

var SuperAnimal = function() {};
SuperAnimal.prototype = {
  walk : function() {
    console.log('ダダダダダ！ ');
  }
};

var Dog = function() {};
Dog.prototype = new Animal();
var d1 = new Dog();
d1.walk();

Dog.prototype = new SuperAnimal();
var d2 = new Dog();
d2.walk();
d1.walk();
