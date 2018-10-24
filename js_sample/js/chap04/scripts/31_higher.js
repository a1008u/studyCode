// high order function

function arrayWalk(ary, f) {
  for (var key in ary) {
    f(ary[key], key);
  }
}

// コールバック関数
function showElement(value, key) {
  console.log(key + '：' + value);
}
var ary = [1, 2, 4, 8, 16];
arrayWalk(ary, showElement);

/* -------------------------------- */
function arrayWalk2(ary2, f) {
  for (let key of ary2) {
    f(val, key);
  }
}
var result2= 0;
function sumElement2(value, key) {
  result2 += value;
}
var ary2 = [1, 2, 4, 8, 16];
arrayWalk(ary2, sumElement2);
console.log('合計値：' + result2);
