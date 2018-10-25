function closure(init) {
  // 状態保持
  let counter = init;

  return () => {
    return ++counter;
  }

}
let myClosure = closure(1);
console.log(`1回目 ${myClosure()}`);
console.log(`2回目 ${myClosure()}`);
console.log(`3回目 ${myClosure()}`);


console.log('/* -------------------------------- */');

var myClosure1 = closure(10);
var myClosure2 = closure(100);
console.log(`1回目 ${myClosure1()}`);
console.log(`2回目 ${myClosure2()}`);
console.log(`3回目 ${myClosure1()}`);
console.log(`4回目 ${myClosure2()}`);


/**
 *  クロージャ
 *  ローカル変数を参照している関数内関数
 *  メソッドを 1 つだけ持つオブジェクトを使いたくなるような状況ならば、
 *  どんな時でもクロージャを使う事ができます。
 */

