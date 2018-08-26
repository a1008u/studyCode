function closure(init) {
  var counter = init;

  return function() {
    return ++counter;
  }
}

var myClosure = closure(1);
console.log(myClosure());
console.log(myClosure());
console.log(myClosure());
