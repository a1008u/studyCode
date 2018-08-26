// http://127.0.0.1:8887/chap02/11.undefined.html
/**
 * nullとundefinedの違い
 * http://tokidoki-web.com/2014/12/javascript%E3%81%AEnull%E3%81%A8undefined%E3%81%AE%E5%8C%BA%E5%88%A5%E3%81%A8%E4%BD%BF%E3%81%84%E5%88%86%E3%81%91%E3%82%92%E3%81%BE%E3%81%A8%E3%82%81%E3%81%A6%E3%82%84%E3%82%93%E3%82%88/
 * 
 * 未定義値（undefined）は、ある変数の値が定義されていないことを表す値
 * ・ある変数が宣言済みであるものの値を与えられていない
 * ・未定義のプロパティを参照しようとした
 * ・関数で値が返されなかった
 */
var x;
var obj = { a:12345 };
console.log(x);
console.log(obj.b);
