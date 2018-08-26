// http://127.0.0.1:8887/chap03/6.number.html

var num1 = 255;
console.log(num1.toString(16));
console.log(num1.toString(8));

var num2 = 123.45678;
console.log(num2.toExponential(2)); // 結果：1.23e+2
console.log(num2.toFixed(3));    // 結果：123.457
console.log(num2.toFixed(7));    // 結果：123.4567800
console.log(num2.toPrecision(10));    // 結果：123.4567800
console.log(num2.toPrecision(6));   // 結果：123.457
