package JavaSE8.type2;

interface MyInter5 { void methodA(); }
class Outer5 {
  void method() {
    MyInter5 obj = new MyInter5() {
      public void methodA() {
        System.out.println("methodA()");
      }
    };
    obj.methodA(); // 匿名クラスのメソッド呼び出し
  }
}

class Sample2_24 {
  public static void main(String[] args) {
    new Outer5().method();
  }
}

// Answer
// methodA()

// 匿名クラスは、再利用することがなく、特定の場所のみで実装したい場合に使用します。
// したがって、クラス名をつけずにクラス定義とインスタンス化を同時に行います。