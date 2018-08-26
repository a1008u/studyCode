// http://127.0.0.1:8887/chap02/52.label.html

/**
 * 脱出先のループの先頭にラベルを指定するわけです。ラベルは以下の形式で指定します。
 */
kuku :
for (var i = 1; i < 10; i++) {
  for (var j = 1; j < 10; j++) {
    var k = i * j
    if (k > 30) { break kuku; }
    document.write(k + '&nbsp');
  }
  document.write('<br />');
}
