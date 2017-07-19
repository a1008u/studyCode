package JavaSE8.type2;

class Outer { // 外側のクラス
  private int val1 = 100; // インスタンス変数
  private static int val2 = 200; //static 変数
  
  class A { // 非static クラス( インナークラス)
    void method1() { // 非static メソッド
      System.out.println("instance val :" + val1); }
    // static メソッド　
    // static void method2() {System.out.println("static val :" + val2); }
  }
  
  static class B { // static クラス
	// 非static メソッド
    //void method1() {System.out.println("instance val :" + val1); }
    static void method2() { //static メソッド
      System.out.println("static val :" + val2); }
  }
}

class Sample2_19 { // 外部のクラス
  public static void main(String[] args) {
    Outer.A a = new Outer().new A(); // 非static クラスのインスタンス化
    Outer.B b = new Outer.B(); // static クラスのインスタンス化
    a.method1(); 
    b.method2();
  }
}

//　Answer
//　instance val :100
//　static val :200

// ネストクラスへのアクセス
//　①外部クラスでネストクラスをインスタンス化する
//　②外側のクラスのメソッド内でネストクラスをインスタンス化する