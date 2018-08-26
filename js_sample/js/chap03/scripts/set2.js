let s = new Set();
s.add(NaN);
s.add(NaN);
console.log(s.size);

s.add({});
s.add({});
console.log(s.size);