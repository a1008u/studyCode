let s = new Set(); 
s.add(10);
s.add(5);
s.add(100);
s.add(50);
s.add(5);

//let s = new Set([10, 5, 100, 50, 5]); 

console.log(s.has(100));
console.log(s.size);

for (let val of s.values()) {
  console.log(val);
}

for (let val of s) {
  console.log(val);
}

s.delete(100);
console.log(s.size);

s.clear();
console.log(s.size);