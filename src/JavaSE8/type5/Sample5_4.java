package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_4 {
  public static void main(String[] args) {
	  
	// count()メソッドは要素の個数を返す
	// long count()	
    // 要素の個数を返す	 有	  
    long result1 = Stream.of("a", "b", "c").count();
    System.out.println(result1);
    
    // forEach()メソッドは引数で指定されたアクションを各要素に対して実行します。
    // void forEach(Consumer<? super T> action)	
	// 各要素に対して指定されたアクションを実行する	無
    Stream<String> stream1 = Stream.of("a", "b", "c");
    stream1.forEach(System.out::print);
    
    // コンパイルエラー(StreamインタフェースはIterableを継承してないため)
    //　for(String s : stream1) { System.out.print(s); }
  }
}

// Answer
// 3
// abc

/*
  	
	
*/