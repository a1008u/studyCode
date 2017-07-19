package JavaSE8.type2;

class Outer1 {
  // インナークラス(非staticクラス)
  class A { }
  // staticクラス
  static class B { }
}

//ネストクラス
//	・インナークラス
//	 	・ローカルクラス
//	 	・匿名クラス
//	・staticクラス

//　ルール
//　staticクラス非staticクラス共通
//　・外側のクラスと同じ名前（クラス名）を使用できない
//　・アクセス修飾子（public、protected、private）を使用できる
//　・abstract修飾子、final修飾子を使用できる
//　staticクラスのみ
//　・非staticメンバ、staticメンバをもつことができる
//　・外側のクラスで定義したインスタンス変数にアクセスできない
//　非staticクラスのみ
//　・staticメンバをもつことができない
//　・外側のクラスで定義したインスタンス変数にアクセスできる
