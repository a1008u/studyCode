// http://127.0.0.1:8887/chap03/3_3.substring2.html

/**
 * 引数 start／endに負の数を指定した場合
 * substringメソッドは無条件に0と見なしますが、
 * sliceメソッドは「文字列末尾からの文字数」と見なします。
 */
var str = 'WINGSプロジェクト';
console.log(`str ${str}`);
console.log(`str.substring(5, -2) ${str.substring(5, -2)}`); // WINGS
console.log(`str.slice(5, -2) ${str.slice(5, -2)}`); // プロジェ
