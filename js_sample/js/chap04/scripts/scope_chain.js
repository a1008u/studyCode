var y = 'Global';
function outerFunc() {
  var y = 'Local Outer';

  function innerFunc() {
    var z = 'Local Inner';
    console.log(z);
    console.log(y);
    console.log(x);
  }
  innerFunc();
}
outerFunc();
