// http://127.0.0.1:8887/chap03/12_2.callback_map.html

var data = [2, 3, 4, 5];
var result = data.map(function(value, index, array) {
  return value * value;
});

var result2 = data.map((value, index, array) => {
  return value * value;
});

console.log(result);
console.log(result2);
