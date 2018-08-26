// http://127.0.0.1:8887/chap03/10.math.html

console.log(Math.abs(-100)); // 100
console.log(Math.clz32(1)); // 31
console.log(Math.min(20, 40, 60)); //20
console.log(Math.max(20, 40, 60)); // 60
console.log(Math.pow(5, 3)); // 125
console.log(Math.random()); // 
console.log(Math.sign(-100)); // -1
console.log(Math.ceil(1234.56)); // 1235
console.log(Math.ceil(-1234.56)); // -1234
console.log(Math.floor(1234.56)); // -1234
console.log(Math.floor(-1234.56)); // 1234
console.log(Math.round(1234.56)); // 1235
console.log(Math.round(-1234.56)); // -1235
console.log(Math.trunc(1234.56)); // 1234
console.log(Math.trunc(-1234.56)); // -1234
console.log(Math.sqrt(81)); // 9
console.log(Math.cbrt(81)); // 4.326748710922225
console.log(Math.hypot(3, 4)); // 5
console.log(Math.cos(1)); // 0.5403023058681398
console.log(Math.sin(1)); // 0.8414709848078965
console.log(Math.tan(1)); // 1.5574077246549023
console.log(Math.atan2(1, 3)); // 0.3217505543966422
console.log(Math.log(10)); // 2.302585092994046
console.log(Math.exp(3)); // 20.085536923187668
console.log(Math.expm1(1)); // 1.718281828459045

with(console) {
    log('【logの例】-------------------------------------')
    log(Math.abs(-100)); // 100
    log(Math.clz32(1)); // 31
    log(Math.min(20, 40, 60)); //20
}