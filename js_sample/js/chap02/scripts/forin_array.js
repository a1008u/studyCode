// http://127.0.0.1:8887/chap02/47_2.forin_array.html

var data = [ 'apple', 'orange', 'banana' ];
for (var key in data) {
  console.log(data[key]);
}