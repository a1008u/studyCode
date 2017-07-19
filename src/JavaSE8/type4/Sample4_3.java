package JavaSE8.type4;

import java.util.function.Function;

public class Sample4_3 {
  public static void main(String[] args) {
	  
	// Function<T,R>	R apply(T t)	
	// 実装するメソッドは、引数としてTを受け取り、結果としてRを返す
    
	  //匿名クラスを使用した場合----------------------
    String str1 = new Function<String, String>() {
      public String apply(String str) {
        return "Hello " + str;
      }
    }.apply("naoki");
    System.out.println("匿名クラス" + str1);
    
    //ラムダ式（省略なし）--------------------------
    Function<String, String> f2 = (String str) -> {
      return "Hello " + str;
    };
    // これも可能
    Function<String, String> f4 = (str) -> {
        return "Hello " + str;
      };
    String str2 = f2.apply("naoki");
    System.out.println("ラムダ式（省略なし）" + str2);
    
    //ラムダ式（省略あり）--------------------------
    Function<String, String> f3 = str -> "Hello " + str;
    String str3 = f3.apply("naoki");
    System.out.println("ラムダ式（省略あり）" + str3);
  }
}

// Answer
// 匿名クラスHello naoki
// ラムダ式（省略なし）Hello naoki
// ラムダ式（省略あり）Hello naoki

/*ラムダ式
インタフェース名	抽象メソッド	概要
Function<T,R>	R apply(T t)	実装するメソッドは、引数としてTを受け取り、結果としてRを返す
BiFunction<T,U,R>	R apply(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、結果としてR を返す
Consumer<T>	void accept(T t)	実装するメソッドは、引数としてT を受け取り、結果を返さない
BiConsumer<T,U>	void accept(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、結果を返さない
Predicate<T>	boolean test(T t)	実装するメソッドは、引数としてT を受け取り、boolean 値を結果として返す
BiPredicate<T,U>	boolean test(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、boolean 値を結果として返す
Supplier<T>	T get()	実装するメソッドは、何も引数として受け取らず、結果としてT を返す
UnaryOperator<T>	T apply(T t)	実装するメソッドは、引数としてT を受け取り、結果としてT を返すものになる。Function を拡張したもの
BinaryOperator<T>	T apply(T t1, T t2)	実装するメソッドは、引数としてT を2 つ受け取り、結果としてT を返すものになる。BiFunction を拡張したもの
*/