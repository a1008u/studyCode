// http://127.0.0.1:8887/chap02/10.object.html
/**
 * オブジェクトとは、名前をキーにアクセスできる配列です。
 * ハッシュ、連想配列などと呼ばれる場合もあります。
 * 
 * 通常の配列がインデックス番号しかキーにできないのに対して、
 * オブジェクトでは文字列をキーにアクセスできるため、
 * データの視認性（可読性）が高いのが特長です。
 */
var obj = { x:1, y:2, z:3, 123:test };
console.log(obj.x);
console.log(`obj['x']の結果は${obj['x']}`);
console.log(`obj.x]の結果は${obj.x}`);
console.log(`obj[0]の結果は${obj[0]}`);

console.log(`obj['123']の結果は${obj[123]}`);
// console.log(`obj.123]の結果は${obj.123}`);