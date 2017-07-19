package JavaSE8.type2;

interface A2 {
  void method(); //抽象メソッド
}

interface X2 extends A2 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("X"); }
}

interface Y2 extends A2 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("Y"); }
}

class MyClass2 implements X2, Y2 {
  @Override
  public void method() { System.out.println("MyClass"); }
}

class Sample2_14 {
  public static void main(String[] args) {
    MyClass2 obj = new MyClass2();
    obj.method();
  }
}

// Answer
// MyClass