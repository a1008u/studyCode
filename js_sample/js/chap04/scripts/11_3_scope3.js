var scope = 'Global Variable';
console.log(this)
function getValue() {
  console.log(this.scope); // 変数の巻き上げ
  scope = 'Local Variable';
  return scope;
}

console.log(getValue());
console.log(scope);


// todo 解析すること