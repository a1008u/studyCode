// http://127.0.0.1:8887/chap02/47_3.forin_array_ng.html

/**
 * ・for...in命令では処理の順序も保証されない
 * ・仮変数にはインデックス番号が格納されるだけなので、コードがあまりシンプルにならない
 * （＝値そのものでないので、かえって誤解を招く）
 */
var data = [ 'apple', 'orange', 'banana' ];
Array.prototype.hoge = function () {}
for (var key in data) {
  console.log(data[key]);
}
