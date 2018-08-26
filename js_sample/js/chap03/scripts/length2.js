// http://127.0.0.1:8887/chap03/4_2.length.html

/**
 * サロゲート文字を正しく判定する方法
 */
var msg = '𠮟る';
var len = msg.length;
var num = msg.split(/[\uD800-\uDBFF][\uDC00-\uDFFF]/g).length - 1;
console.log(msg.length - num);
