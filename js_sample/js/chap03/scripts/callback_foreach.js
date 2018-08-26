// http://127.0.0.1:8887/chap03/12.callback_foreach.html

var data = [2, 3, 4, 5];
data.forEach(function(value, index, array) {
  console.log(value * value);
});

// アロー
data.forEach((value, index, array) => {
  console.log(value * value);
});
