package JavaSE8.type2;

class Sample2_20 {  // 外側のクラス
  class A {  // 非static クラス
    void methodA() {System.out.println("methodA()"); }
  }
  static class B {  // static クラス
    public final String message = "akira";
    static void methodB() {System.out.println("methodB()"); }
  }
  public static void main(String[] args) {
    new Sample2_20().new A().methodA(); //new A().methodA(); はNG
    new B().methodB();  //new B().methodB(); でもOK
    B.methodB();        //B.methodB(); でもOK
    System.out.println(new B().message);
    // コンパイルエラー System.out.println(new Sample2_20.B.message);
  }
}

//ネストクラスへのアクセス
//①外部クラスでネストクラスをインスタンス化する
//②外側のクラスのメソッド内でネストクラスをインスタンス化する

// Answer
// methodA()
// methodB()
// methodB()