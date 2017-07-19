package JavaSE8.type5;

import java.util.*;
import java.util.stream.*;

public class Sample5_2 {
  public static void main(String[] args) {
	  
	// 基本データ型に対応したストリームオブジェクトは、IntStream、LongStream、DoubleStream の3種類
	  
    List<String> data1 = Arrays.asList("a", "b", "c");
    Stream<String> stream1 = data1.stream();
    // Stream<T>	
    // 順次および並列の集約操作をサポートする汎用的なストリーム
    
    int[] data2 = {1, 2, 3};
    IntStream stream2 = Arrays.stream(data2); 
    // IntStream	
    // 順次および並列の集約操作をサポートするint値のストリーム。
    // ただし、intの他、short、byte、char 型に使用可能
    
    Stream<String> stream3 = Stream.of("abc");
    // Stream<T>	
    // 順次および並列の集約操作をサポートする汎用的なストリーム
    
    Stream<Long> stream4 = Stream.of(1L, 2L, 3L);
    LongStream stream5 = LongStream.of(1L, 2L, 3L);
    // LongStream	
    // 順次および並列の集約操作をサポートするlong値のストリーム
    
    DoubleStream stream6 = DoubleStream.of(1.0, 2.0, 3.0);
    // DoubleStream	
    // 順次および並列の集約操作をサポートするdouble値のストリーム。
    // ただし、doubleの他、float型に使用可能
  }
}


