/* 通常の引数 ---------------------------- */
function showMessage(value) {
  console.table(arguments)
  console.log(value);
}

showMessage();
showMessage('山田');
showMessage('山田', '鈴木');

console.log(' ---------------------------- ')

/* デフォルト引数 ---------------------------- */
function showMessage2(value = 'test') {
  console.table(arguments)
  console.log(value);
}

showMessage2();
showMessage2('山田');
showMessage2('山田', '鈴木');