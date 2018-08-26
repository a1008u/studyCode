// http://127.0.0.1:8887/chap03/12_4.callback_filter.html

var data = [4, 9, 16, 25];

var result = data.filter(function(value, index, array) {
  return value % 2 === 1;
});
console.log(result);

// アロー
var result2 = data.filter((value, index, array) => {
  return value % 2 === 1;
});
console.log(result2);