
/**
 * Objectオブジェクトは全てのオブジェクトの親
 *  プロパティ
 *  プロトタイプ
 */

/**
 * ・toStringメソッド　→ 　文字列を返す
 * ・valueOfメソッド 　→ 　文字列以外の基本型の値が返されることを「期待して」使われる
 * 
 * toStirng()は意味ある情報を返さないので自分で返すように実装しましょう。
 */
var obj = new Object();
console.log(obj.toString()); 
console.log(obj.valueOf());

var dat = new Date();
console.log(dat.toString());
console.log(dat.valueOf());

var ary = ['prototype.js', 'jQuery', 'Yahoo! UI'];
console.log(ary.toString());
console.log(ary.valueOf());

var num = 10;
console.log(num.toString());
console.log(num.valueOf());

var reg = /[0-9]{3}-[0-9]{4}/g;
console.log(reg.toString());
console.log(reg.valueOf());