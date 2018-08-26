function getMaxMin(...nums) {
  return [Math.max(...nums), Math.min(...nums)];
}

let result = getMaxMin(10, 35, -5, 78, 0);
console.log(result);

let [max, min] = getMaxMin(10, 35, -5, 78, 0);
//let [,min] = getMaxMin(10, 35, -5, 78, 0);
console.log(max);
console.log(min);
