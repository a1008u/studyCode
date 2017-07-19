package JavaSE8.type4;

import java.util.*;
import java.util.function.*;
public class Sample4_1 {
  public static void main(String[] args) {
	  
    List<String> words = Arrays.asList("Tanaka", "Sato");
    
    /*  //匿名クラスで実装した場合
    words.replaceAll(new UnaryOperator<String>() {
      public String apply(String str) {
        return str.toUpperCase();
      }
    });  */
    
    // Listインタフェースに新しく追加されたreplaceALl()メソッドを上記は実装している
    // replaceAllの引数：　UnaryOperator<E> operator　抽象メソッド：T apply(T t)
    words.replaceAll( (String str) -> { return str.toUpperCase(); } );
    System.out.println(words);
    
  }
}

// ラムダ式
// (実装するメソッドの引数) -> {処理};

// Answer
// [TANAKA, SATO]

/*ラムダ式
インタフェース名	抽象メソッド	概要
Function<T,R>	R apply(T t)	実装するメソッドは、引数としてTを受け取り、結果としてRを返す
BiFunction<T,U,R>	R apply(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、結果としてR を返す
Consumer<T>	void accept(T t)	実装するメソッドは、引数としてT を受け取り、結果を返さない
BiConsumer<T,U>	void accept(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、結果を返さない
Predicate<T>	boolean test(T t)	実装するメソッドは、引数としてT を受け取り、boolean 値を結果として返す
BiPredicate<T,U>	boolean test(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、boolean 値を結果として返す
Supplier<T>	T get()	実装するメソッドは、何も引数として受け取らず、結果としてT を返す
UnaryOperator<T>	T apply(T t)	実装するメソッドは、引数としてTを受け取り、結果としてTを返すものになる。Function を拡張したもの
BinaryOperator<T>	T apply(T t1, T t2)	実装するメソッドは、引数としてT を2 つ受け取り、結果としてT を返すものになる。BiFunction を拡張したもの
*/