var scope = 'Global Variable';
function getValue() {
  console.log(scope); // 変数の巻き上げ
  var scope = 'Local Variable';
  return scope;
}

console.log(getValue());
console.log(scope);
