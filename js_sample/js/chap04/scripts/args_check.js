function showMessage(value) {
  if (arguments.length !== 1) {
    throw new Error('引数の数が間違っています：' + arguments.length);
  }
  console.log(value);
}

try {
  showMessage(' 山田', ' 鈴木');
} catch(e) {
  window.alert(e.message);
}
