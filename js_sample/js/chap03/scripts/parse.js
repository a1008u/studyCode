var n = '123xxx';
console.log(Number(n));
console.log(Number.parseFloat(n));
console.log(Number.parseInt(n));

var d = new Date();
console.log(Number(d));
console.log(Number.parseFloat(d));
console.log(Number.parseInt(d));

var h = '0x10';
console.log(Number(h));
console.log(Number.parseFloat(h));
console.log(Number.parseInt(h));

var b = '0b11';
console.log(Number(b));
console.log(Number.parseFloat(b));
console.log(Number.parseInt(b));

var e = '1.01e+2';
console.log(Number(e));
console.log(Number.parseFloat(e));
console.log(Number.parseInt(e));
