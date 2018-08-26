// http://127.0.0.1:8887/chap03/11_3.array_queue.html

/**
 * キュー（待ち行列）
 *  - 先入れ先出し（FIFO:First In First Out）
 */
var data = [];
data.push(1);
data.push(2);
data.push(3);
console.log(data.shift());
console.log(data.shift());
console.log(data.shift());
