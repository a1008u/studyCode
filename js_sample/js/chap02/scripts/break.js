// http://127.0.0.1:8887/chap02/49.break.html

/**
 * break命令：：：ループ全体を完全に脱出する
 */
var result = 0;
for (var i = 1; i <= 100; i++) {
  result += i;
  if (result > 1000) { break; }
}
console.log('合計値が1000を超えるのは' + i);
