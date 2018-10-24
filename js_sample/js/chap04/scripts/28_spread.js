// Mathの関数を使うよ
console.log(`Math.max(15, -3, 78, 1) ${Math.max(15, -3, 78, 1)}`);
console.log(`Math.max([15, -3, 78, 1]) ${Math.max([15, -3, 78, 1])}`);

console.log(`Math.max.apply(null, [15, -3, 78, 1]) ${Math.max.apply(null, [15, -3, 78, 1])}`);
console.log(`Math.max(...[15, -3, 78, 1]) ${Math.max(...[15, -3, 78, 1])}`);
