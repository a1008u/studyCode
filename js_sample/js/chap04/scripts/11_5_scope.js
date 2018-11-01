scope = 'Global Variable';
function getValue() {
  console.log(scope); // 変数の巻き上げ
  var scope = 'Local Variable';
  return scope;
}

console.log(getValue());

console.log(' ------------------------------------ ')
var scope3 = 'Global Variable';
function getValue() {
  console.log(scope3); // 変数の巻き上げ
  var scope3 = 'Local Variable';
  return scope3;
}

console.log(getValue());
console.log(scope3);

console.log(' ------------------------------------ ')

// var scope2 = 'Global Variable';
function getValue2() {
  console.log(scope2); // 変数の巻き上げ
  var scope2 = 'Local Variable';
  return scope2;
}

console.log(getValue2());
console.log(scope2);