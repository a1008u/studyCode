scope = 'Global Variable';
function getValue() {
  scope = 'Local Variable';
  return scope;
}

console.log(getValue());
console.log(scope);
