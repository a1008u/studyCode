// http://127.0.0.1:8887/chap02/51.label_no.html

/**
 * document.writeよりtextContent/innerHTMLを優先する
 * 問題点：ドキュメントをすべて出力したあとに呼び出した場合には、ページがいったんクリアされてしまう
 */
for (var i = 1; i < 10; i++) {
  for (var j = 1; j < 10; j++) {
    var k = i * j
    if (k > 30) { break; }
    document.write(k + '&nbsp');
  }
  document.write('<br />');
}
