// 再帰関数

function factorial(n) {
  if (n != 0) {
    console.log(n)
    return n * factorial(n - 1);
  }
  return 1;
}

console.log(factorial(5));
