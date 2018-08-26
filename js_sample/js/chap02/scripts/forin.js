// http://127.0.0.1:8887/chap02/47_1.forin.html

/**
 * for-inでは仮変数に連想配列のキーを一時的に格納する
 */
var data = { apple:150, orange:100, banana: 120 };
for (var key in data) {
  console.log(key + '=' + data[key]);
}
