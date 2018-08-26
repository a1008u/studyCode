// http://127.0.0.1:8887/chap03/11_2.array_stack.html

/**
 * スタック（データ構造）＊下記の特性をもつ
 *  - 後入れ先出し（LIFO:Last In First Out）
 *  - 先入れ後出し（FILO:First In Last Out）
 */
var data = [];
data.push(1);
data.push(2);
data.push(3);
console.log(data.pop());
console.log(data.pop());
console.log(data.pop());
