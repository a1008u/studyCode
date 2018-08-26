var ary1 = ['Sato', 'Takae', 'Osada', 'Hio', 'Saitoh','Sato'];
var ary2 = ['Yabuki', 'Aoki', 'Moriyama', 'Yamada'];

console.log(ary1.length);
console.log(Array.isArray(ary1));
console.log(ary1.toString());
console.log(ary1.indexOf('Sato'));
console.log(ary1.lastIndexOf('Sato'));

console.log(ary1.concat(ary2));
console.log(ary1.join('／'));
console.log(ary1.slice(1));
console.log(ary1.slice(1, 2));
console.log(ary1.splice(1, 2, 'Kakeya', 'Yamaguchi'));
console.log(ary1);
console.log(Array.of(20,40,60));
console.log(ary1.copyWithin(1, 3, 5));
console.log(ary1);
console.log(ary2.fill('Suzuki', 1, 3));
console.log(ary2);

console.log(ary1.pop());
console.log(ary1);
console.log(ary1.push('Kondo'));
console.log(ary1);
console.log(ary1.shift());
console.log(ary1);
console.log(ary1.unshift('Ozawa', 'Kuge'));
console.log(ary1);

console.log(ary1.reverse());
console.log(ary1);
console.log(ary1.sort());
console.log(ary1);
