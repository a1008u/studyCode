// http://127.0.0.1:8887/chap02/38.if_omit_ok.html

var x = 1;
var y = 2;
if (x === 1) {
  if (y === 1) {
    console.log('変数x、yは共に1です。');
  }
} else {
  console.log('変数xは1ではありません。');
}
