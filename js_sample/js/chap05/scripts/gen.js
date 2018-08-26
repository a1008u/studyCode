function* myGenerator() {
  yield 'あいうえお';
  yield 'かきくけこ';
  yield 'さしすせそ';
}

for(let t of myGenerator()) {
  console.log(t);
}
