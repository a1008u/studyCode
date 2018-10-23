this.data = 'this is within global';
function func() {
  // 実行時のレシーバであるオブジェクトをthisとして定義する
  console.log(this.data);
}

const arrowFunc = () => {
  // 宣言時のスコープを持つオブジェクトをthisとして定義する
  // ここではグローバルオブジェクト
  console.log(this.data);
};



const f = {
  data: 'within object',
  execute: func
};
f.execute();
// => 'this is within object'



const af = {
  data: 'this is within object',
  execute: arrowFunc
};
af.execute();
// => 'this is within global'