package JavaSE8.type2;

interface MyInter4 { void methodA(); }

class Outer4 {
  void method() {
    new MyInter4() {
      public void methodA() {
        System.out.println("methodA()");
      }
    }.methodA(); // 匿名クラスのメソッド呼び出し
  }
}

class Sample2_23 {
  public static void main(String[] args) {
    new Outer4().method();
  }
}

// Answer
// methodA()

// 匿名クラスのルール
//・アクセス修飾子（public、protected、private）を使用できない
//・static修飾子を使用できない
//・abstract修飾子、final修飾子を使用できない
//・外側のクラスのメンバにアクセスできる
//・外側のクラスのメソッドの引数およびローカル変数にアクセスできる（ただし、暗黙的にfinal）
//・コンストラクタを定義できない