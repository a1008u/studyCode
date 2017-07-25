package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_7 {
  public static void main(String[] args) {
	  
	// 構文3 rangeメソッドは終値を含まない
    int[] ary1 = IntStream.range(1, 10).toArray();
    
    // 構文3 rangeClsedメソッドは終値を含む
    int[] ary2 = IntStream.rangeClosed(1, 10).toArray();
    
	// 構文1 toArray()メソッドは、ストリームから配列に変換します。
	// Object[] toArray() 要素を含む配列を返す	無
    Object[] ary3 = Stream.of("a", "b").toArray();
    
    // 構文2 <A> A[] toArray(IntFunction<A[]> generator)
    // 引数に結果となる配列の要素の型を指定し、配列を返す	無
    String[] ary4 = Stream.of("a", "b").toArray(String[]::new);
    
    System.out.println("ary1 : " + ary1.length);
    System.out.println("ary2 : " + ary2.length);
    System.out.println("ary3 : " + ary3.getClass());
    System.out.println("ary4 : " + ary4.getClass());
  }
}

// Answer
// ary1 : 9
// ary2 : 10
// ary3 : class [Ljava.lang.Object;
// ary4 : class [Ljava.lang.String;

// 構文 　Streamインタフェースで提供
// 構文1：Object[] toArray()
// 構文2：<A> A[] toArray(IntFunction<A[]> generator)

// 構文　IntStreamインタフェースで提供
// 構文3：int[] toArray()