// http://127.0.0.1:8887/chap02/53.try.html

/**
 * 例外処理は、確実に動作するスクリプトを記述するうえで欠かせないしくみですが、オーバーヘッドの大きい処理でもあります。
 * たとえば、ループ処理の中でtry...catchブロックを記述するのは避けるべきです。
 * まずは「try...catchブロックをループの外に配置できないか」を検討してください。 
 */
var i = 1;
try{
  i = i * j;
} catch(e) {
  console.log(e.message);
} finally {
  console.log('処理は完了しました。');
}