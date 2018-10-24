function sum() {
  var result = 0;
  for (var i = 0, len = arguments.length; i < len; i++) {
    var tmp = arguments[i];
    if (typeof tmp !== 'number') {
      throw new Error('引数が数値ではありません：' + tmp);
    }
    result += tmp;
  }
  return result;
}

try {
  const sumValue = sum(1, 3, 5, 7, 9);
  console.log(sumValue);
} catch(e) {
  window.alert(e.message);
}
