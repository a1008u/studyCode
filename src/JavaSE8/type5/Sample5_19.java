package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_19 {
  public static void main(String[] args) {
	  
	// 暗黙の型変換を行うためのメソッド  
	  
    // IntStream→DoubleStream(mapToDouble()を使用)
    IntStream stream1i = IntStream.of(2, 3, 5);
    DoubleStream stream1d = stream1i.mapToDouble(n -> n);
    System.out.println(stream1d.average().getAsDouble());
    
    // IntStream→DoubleStream(asDoubleStream()を使用)
    // DoubleStream asDoubleStream() 
    // 	IntStreamインタフェースで提供。要素をdoubleに変換した結果から構成されるDoubleStreamを返す
    IntStream stream2i = IntStream.of(2, 3, 5);
    DoubleStream stream2d = stream2i.asDoubleStream();
    System.out.println(stream2d.average().getAsDouble());
  }
}

// Answer
// 3.3333333333333335
// 3.3333333333333335

//byte short int long float double
//     char
//

// メソッド名	説明
// LongStream asLongStream()	IntStreamインタフェースで提供。
// 	要素をlong に変換した結果から構成されるLongStreamを返す
// DoubleStream asDoubleStream()	LongStreamインタフェースで提供。
// 	要素をdouble に変換した結果から構成されるDoubleStreamを返す