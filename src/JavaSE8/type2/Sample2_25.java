package JavaSE8.type2;

import java.util.function.Function;

class MyFunc implements Function<String, String> {
  public String apply(String str) {
    return "Hello " + str;
  }
}
public class Sample2_25 {
  public static void main(String[] args) {
    MyFunc obj = new MyFunc();
    String str = obj.apply("naoki");
    System.out.println(str);
  }
}

// Answer
// Hello naoki


/*関数型インタフェースとは定義されている抽象メソッドが1つだけのインタフェースです。
 * 
 * java.util.function パッケージ
 * インタフェース名：抽象：メソッド概要
 * Function<T,R>：Rapply(Tt) ：実装するメソッドは、引数としてTを受け取り、結果としてRを返す
 * Consumer<T>：void accept(Tt) ：実装するメソッドは、引数としてTを受け取り、結果を返さない
 * Predicate<T>：boolean test(Tt) ：実装するメソッドは、引数としてTを受け取り、boolean値を結果として返す
 * Supplier<T>：T get() ：実装するメソッドは、何も引数として受け取らず、結果としてTを返す
 * UnaryOperator<T>：T apply(Tt) ：実装するメソッドは、引数としてTを受け取り、結果としてTを返すものになる。Functionを拡張したもの
 * 
 */