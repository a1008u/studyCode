(function() {
  var i = 5;
  console.log(i);
}).call(this);

// 即時実行関数を用いることで、再利用を防ぐ
console.log(i);
