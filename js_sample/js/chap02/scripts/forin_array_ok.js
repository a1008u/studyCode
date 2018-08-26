// http://127.0.0.1:8887/chap02/47_4.forin_array_ok.html

/**
 * 配列の列挙にはfor命令 or for-of
 */
var data = [ 'apple', 'orange', 'banana' ];
for (var i = 0, len = data.length; i < len; i++) {
//for (var i = 0; i < data.length; i++) {
  console.log(data[i]);
}
