// http://127.0.0.1:8887/chap02/29.delete.html

/**
 * delete演算子
 * オペランドに指定した変数や配列要素、オブジェクトのプロパティを破棄します。
 * 
 * 削除に
 * 成功した場合 true
 * 失敗した場合 false
 */
var ary = ['JavaScript', 'Ajax', 'ASP.NET'];
console.log(delete ary[0]);
console.log(ary);

var obj = {x:1, y:2};
console.log(delete obj.x);
console.log(obj.x);

var obj2 = {x:obj, y:2};
console.log(delete obj2.x);
console.log(obj);

var data1 = 1;
console.log(delete data1);
console.log(data1);

data2 = 10;
console.log(delete data2);
console.log(data2);

var obj3 = {x:1, y:2};
var obj4 = delete obj3.x;
console.log(obj4);