package JavaSE8.type2;

interface A3 {
  void method(); //抽象メソッド
}
interface X3 extends A3 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("X"); }
}
interface Y3 extends A3 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("Y"); }
}
class MyClass3 implements X3, Y3 {
  @Override
  public void method() { X3.super.method(); }
}
class Sample2_15 {
  public static void main(String[] args) {
    MyClass3 obj = new MyClass3();
    obj.method();
  }
}

// Answer
// X (親インタフェース名.super.メソッド名())
