function getTriangle(base = 1, height = 1) {
  return base * height / 2;
}

console.log(getTriangle(5));
//console.log(getTriangle(5, null));
//console.log(getTriangle(5, undefined));

/* -------------------------------- */
function multi(a, b = a) {
  return a * b;
}
console.log(multi(10, 5));
console.log(multi(3));

/* -------------------------------- */
function multi2(a = b, b = 5) {
  return a * b;
}
console.log(multi2());

/* -------------------------------- */
function getTriangle2(base = 1, height = 1) {
  return base * height / 2;
}
console.log(getTriangle2(5, null));     // 結果：0

/* -------------------------------- */
function getTriangle3(base = 1, height) {
  return base * height / 2;
}
console.log(getTriangle3(10));

