package JavaSE8.type2;

interface A1 {
  void method(); //抽象メソッド
}
interface X1 extends A1 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("X"); }
}
interface Y1 extends A1 { //Aインタフェースのサブインタフェース
  @Override
  default void method() { System.out.println("Y"); }
}
class MyClass1 implements X1, Y1 { } //このクラスが原因でコンパイルエラー

// method()に対し、どちらを呼べばいいか不明なため
