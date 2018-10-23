var value = [1, 2, 4, 8, 16];
function deleteElement(value) {
  value.pop();
  return value;
}

console.table(deleteElement(value));
console.table(value);

// 参照型とは「値そのものではなく、値を格納したメモリ上の場所（アドレス）だけを格納している型