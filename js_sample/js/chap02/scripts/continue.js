// http://127.0.0.1:8887/chap02/50.continue.html

var result = 0;
for (var i = 1; i < 100; i++) {
  if (i % 2 === 0) { continue; }
  result += i;
}
console.log('合計：' + result);
