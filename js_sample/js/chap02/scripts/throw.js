// http://127.0.0.1:8887/chap02/54.throw.html

var x = 1;
var y = 0;
try{
  if (y === 0) { throw new Error('0で除算しようとしました。'); }
  var z = x / y;
} catch(e) {
  console.log(e.message);
}
