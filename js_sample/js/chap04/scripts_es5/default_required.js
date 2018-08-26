'use strict';

function show(x) {
  var y = arguments.length <= 1 || arguments[1] === undefined ? 1 : arguments[1];

  console.log('x = ' + x);
  console.log('y = ' + y);
}

show();
