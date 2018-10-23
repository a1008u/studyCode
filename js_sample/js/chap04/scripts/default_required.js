function show(x, y = 1) {
  console.log('x = ' + x);
  console.log('y = ' + y);
}
show();

/* -------------------------------- */
function required() {
  throw new Error('引数が不足しています');
}
function hoge(value = required()) {
  return value;
}
hoge();
