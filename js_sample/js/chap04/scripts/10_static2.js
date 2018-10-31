/**
 * 関数リテラル／Functionコンストラクターは実行時（代入時）に評価される
 */
console.log('三角形の面積：' + getTriangle(5, 2));
let getTriangle = function(base, height) {
  return base * height / 2;
};


/**
 * functon命令はコードを解析／コンパイルするタイミングで、関数を登録している
 */
console.log('三角形の面積：' + getTriangle2(5, 2));
function getTriangle2(base, height) {
  return base * height / 2;
};

