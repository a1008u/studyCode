function closure(init) {
  var counter = init;

  return function() {
    return ++counter;
  }
}
var myClosure = closure(1);
console.log(`1回目 ${myClosure()}`);
console.log(`2回目 ${myClosure()}`);
console.log(`3回目 ${myClosure()}`);

/* -------------------------------- */
function closureX(init) {
  var counter = init;

  return function() {
    return ++counter;
  }
}
var myClosure1 = closureX(1);
var myClosure2 = closureX(100);
console.log(`1回目 ${myClosure1()}`);
console.log(`2回目 ${myClosure2()}`);
console.log(`3回目 ${myClosure1()}`);
console.log(`4回目 ${myClosure2()}`);
