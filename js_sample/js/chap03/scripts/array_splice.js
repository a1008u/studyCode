// http://127.0.0.1:8887/chap03/11_4.array_splice.html

/**
 * splice
 *  配列の任意の箇所に要素を追加したり、
 *  既存の要素を置き換えたり削除したり、
 *  といった操作を行います
 */
var data = ['Sato', 'Takae', 'Osada', 'Hio', 'Saitoh'];  

// 置き換え
console.log(data.splice(3, 2, 'Yamada', 'Suzuki')); // 結果：["Hio", "Saitoh"]
console.log(data); // 結果：["Sato", "Takae", "Osada", "Yamada", "Suzuki"]

// 指定された範囲の要素を削除する
console.log(data.splice(3, 2)); // 結果：["Yamada", "Suzuki"]
console.log(data); // 結果：["Sato", "Takae", "Osada"]

// 引数indexで指定されたいちに要素を挿入する
console.log(data.splice(1, 0, 'Tanaka'));  // 結果：[]
console.log(data); // 結果：["Sato", "Tanaka", "Takae", "Osada"]