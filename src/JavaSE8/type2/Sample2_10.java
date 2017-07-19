package JavaSE8.type2;

interface MyInter1a {
  double methodA(int num);
  default void methodB() { System.out.println("methodB()"); }
}

interface MyInter2a {
  int methodC(int val1, int val2);
  static void methodD() { System.out.println("methodD()"); }
}

class MyClassa implements MyInter1a, MyInter2a {
  @Override
  public double methodA(int num){ return num * 0.3; }
  @Override
  public int methodC(int val1, int val2){ return val1 + val2; }
}

class Sample2_10 {
  public static void main(String[] args) {
    MyClassa obj = new MyClassa();
    System.out.println("methodA()" + obj.methodA(10));
    System.out.println("methodC()" + obj.methodC(10, 20));
    obj.methodB();        //デフォルトメソッドの呼び出し
    MyInter2a.methodD();  //staticメソッドの呼び出し
    //obj.methodD();
  }
}

// Answer
/*
 * methodA()3.0
 * methodC()30
 * methodB()
 * methodD()
*/


// デフォルトメソッドSE8から処理を記述したメソッド（具象メソッド）が定義できるようになりました。
// これをデフォルトメソッドと呼びます。1つのインタフェースに複数定義することも可能です。