// http://127.0.0.1:8887/chap02/26.logical.html

/**
 * 条件判定でfalseとみなされる一覧
 * ・空文字列（""）
 * ・数値の0、NaN（Not a Number）
 * ・null、undefined
 */

var x = 1;
var y = 2;
var z;

console.log(x === 1 && y === 1);
console.log(x === 1 || y === 1);

if (z) {
    console.log(`zは${z}`);
} else {
    console.log(`zは${z}`);
}

