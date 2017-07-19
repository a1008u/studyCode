package JavaSE8.type4;

import java.util.*;

public class Sample4_8 {
  public static void main(String[] args) {
	  
    List<Integer> list = Arrays.asList(3, 1, 2);
    
    // forEachを使用しない
    for(int a : list) { System.out.print(a); }
    
    // forEachを使用、かつラムダ式を引数に渡す
    list.forEach( a -> System.out.print(a) );
    
    // インスタンスメソッド参照
    list.forEach(System.out::print);
  }
}

// Answer
// 312

// インスタンスメソッド参照の記述は、
// 呼び出すメソッドがインスタンスメソッドの場合、「インスタンスメソッド名:: メソッド名」とします。

// IterableインタフェースのforEachメソッド
// java.lang.Iterableインタフェースはオブジェクトをfor-eachループ文の対象にすることができ、
// CollectionインタフェースはIterableインタフェースを継承しています。
// そして、Iterableインタフェースではデフォルトメソッドとして、forEach()が実装いる。
//
// 実際のソース
// 72. default void forEach(Consumer<? super T> action) {
// 73.   Objects.requireNonNull(action);
// 74.     for (T t : this) {
// 75.       action.accept(t);
// 76.     @ }
// 77.   }
//
// よって、Consumerインタフェースのacceptメソッドを設定する。