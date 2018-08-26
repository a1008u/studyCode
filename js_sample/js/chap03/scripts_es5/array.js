// http://127.0.0.1:8887/chap03/11_1.array.html

'use strict';

var ary1 = ['Sato', 'Takae', 'Osada', 'Hio', 'Saitoh', 'Sato'];
var ary2 = ['Yabuki', 'Aoki', 'Moriyama', 'Yamada'];

console.log(ary1.length);  // 結果：6
console.log(Array.isArray(ary1)); // 結果：true
console.log(ary1.toString()); // 結果：Sato,Takae,Osada,Hio,Saitoh,Sato
console.log(ary1.indexOf('Sato')); // 結果：0
console.log(ary1.lastIndexOf('Sato')); // 結果：5

console.log(`ary1は ${ary1}`);
console.log(`ary2は ${ary2}`)
console.log(ary1.concat(ary2));// 結果：["Sato", "Takae", "Osada", "Hio", "Saitoh", "Sato", "Yabuki", "Aoki", "Moriyama", "Yamada"]
console.log(ary1.join('／'));// 結果：Sato／Takae／Osada／Hio／Saitoh／Sato 
console.log(ary1.slice(1));// 結果：["Takae", "Osada", "Hio", "Saitoh", "Sato"]
console.log(ary1.slice(1, 2));// 結果：["Takae"]
console.log(ary1.splice(1, 2, 'Kakeya', 'Yamaguchi'));// 結果：["Takae", "Osada"]（置き換え対象の要素を取得）
console.log(ary1);// 結果：["Sato", "Kakeya", "Yamaguchi", "Hio", "Saitoh", "Sato"]（置き換え後の配列）
console.log(Array.of(20, 40, 60));// 結果：[20, 40, 60]
console.log(ary1.copyWithin(1, 3, 5));// 結果：["Sato", "Hio", "Saitoh", "Hio", "Saitoh", "Sato"]（4～5番目の要素を2～3番目の位置へコピー）
console.log(ary1);// 結果：["Sato", "Hio", "Saitoh", "Hio", "Saitoh", "Sato"]（コピー後の配列）
console.log(ary2.fill('Suzuki', 1, 3));// 結果：["Yabuki", "Suzuki", "Suzuki", "Yamada"]（2～3番目の要素を"Suzuki"で置換）
console.log(ary2);// 結果：["Yabuki", "Suzuki", "Suzuki", "Yamada"]（置換後の配列)

console.log(ary1.pop()); // 結果：Sato（削除した要素）
console.log(ary1); // 結果：["Sato", "Hio", "Saitoh", "Hio", "Saitoh"]（削除後の配列）
console.log(ary1.push('Kondo')); // 結果：6（追加後の要素数）
console.log(ary1); // 結果：["Sato", "Hio", "Saitoh", "Hio", "Saitoh", "Kondo"]（追加後の配列）
console.log(ary1.shift()); // 結果：Sato（削除した要素）
console.log(ary1); // 結果：["Hio", "Saitoh", "Hio", "Saitoh", "Kondo"]（削除後の配列)
console.log(ary1.unshift('Ozawa', 'Kuge')); // 結果：7（追加後の要素数）
console.log(ary1); // 結果：["Ozawa", "Kuge", "Hio", "Saitoh", "Hio", "Saitoh", "Kondo"]（追加後の配列）

console.log(ary1.reverse()); // 結果：["Kondo", "Saitoh", "Hio", "Saitoh", "Hio", "Kuge", "Ozawa"]（反転後の配列）
console.log(ary1); // 結果：["Kondo", "Saitoh", "Hio", "Saitoh", "Hio", "Kuge", "Ozawa"]（反転後の配列）
console.log(ary1.sort()); // 結果：["Hio", "Hio", "Kondo", "Kuge", "Ozawa", "Saitoh", "Saitoh"]（ソート後の配列）
console.log(ary1); // 結果：["Hio", "Hio", "Kondo", "Kuge", "Ozawa", "Saitoh", "Saitoh"]（ソート後の配列）
