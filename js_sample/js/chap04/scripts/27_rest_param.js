function sum(...nums) {
  let result = 0;
  for (let num of nums) {
    if (typeof num !== 'number') {
      throw new Error('指定値が数値ではありません：' + num);
    }
    result += num;
  }
  return result;
}

try {
  const sumValue = sum(1, 3, 5, 7, 9);
  console.log(sumValue);
} catch(e) {
  window.alert(e.message);
}
