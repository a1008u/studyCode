// http://127.0.0.1:8887/chap03/13.sort.html

var ary = [5, 25, 10];
console.log(ary.sort());

console.log(ary.sort(function(x, y) {
  return x - y;
}));

console.log(`アローの結果：：${ary.sort((x, y) =>  {
  return x - y;
})}`);
