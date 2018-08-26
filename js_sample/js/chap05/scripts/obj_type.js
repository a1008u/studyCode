var Animal = function() {};
var Hamster = function() {};
Hamster.prototype = new Animal();

var a = new Animal();
var h = new Hamster();
console.log(a.constructor === Animal);
console.log(h.constructor === Animal);
console.log(h.constructor === Hamster);

console.log(h instanceof Animal);
console.log(h instanceof Hamster);

console.log(Hamster.prototype.isPrototypeOf(h));
console.log(Animal.prototype.isPrototypeOf(h));