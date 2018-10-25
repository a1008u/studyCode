var y = 'Global(Globalオブジェクト)';
function outerFunc() {
  var y = 'Local Outer(Callオブジェクト)';

  function innerFunc() {
    var z = 'Local Inner(Callオブジェクト)';
    console.log(z);
    console.log(y);
    console.log(x);
  }
  innerFunc();
}

outerFunc();

/**
 * Globalオブジェクト
 * グローバル変数やグローバル関数を管理するためのオブジェクト
 *
 * Activationオブジェクト(Callオブジェクト)
 * 関数呼び出しの都度、内部的に自動生成されるオブジェクト
 *
 * スコープチェーン(レキシカルスコープ)
 * グローバルオブジェクト、Callオブジェクトを生成の順に連結したリストのこと
 * Callオブジェクト -> グローバルオブジェクトに変数が存在するか確認する
 */
