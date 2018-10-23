var scope = 'Global Variable';

function checkScope() {
  var scope = 'Local Variable';

  var f_lit = function() { return scope; };
  console.log(f_lit());

  var f_con = new Function('return scope;');
  console.log(f_con());
}

checkScope();
