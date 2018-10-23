var scope = 'Global Variable';
function getValue() {
  var scope = 'Local Variable';
  return scope;
}

console.log(getValue());
console.log(scope);

// var命令で定義された変数は、定義する場所によって変数のスコープが決まる
// スコープが異なる場合、それぞれの変数は（同名であっても）別物として認識されているわけです。
