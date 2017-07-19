package JavaSE8.type2;

interface A4 {
  void method(); //抽象メソッド
}
interface X4 extends A4 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("X"); }
}
class Y4 implements A4 { //Aインタフェースの実装クラス
  @Override
  public void method() { System.out.println("Y"); }
}
class MyClass4 extends Y4 implements X4{ }
  
class Sample2_16 {
  public static void main(String[] args) {
    MyClass4 obj = new MyClass4();
    obj.method();
  }
}

// Answer
// Y (Java言語では常に実装クラスが優先される)

