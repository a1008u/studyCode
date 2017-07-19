package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_28 {
  public static void main(String[] args) {
	  
    // minBy()メソッドの例
	// static <T> Collector<T,?,Optional<T>> minBy(Comparator<? super T> comparator)	
	// 指定されたComparatorに従ってOptional<T>として記述された最小要素を生成するCollectorを返す
	//  minBy()は最小値の要素を取得する際に使用します。
    Stream<String> stream1 = 
                   Stream.of("naoki", "akko", "ami");
    Optional<String> result1 = 
                  stream1.collect(
                  Collectors.minBy(Comparator.naturalOrder()));
    System.out.println(result1.get());
    
    // maxBy()メソッドの例
    // static <T> Collector<T,?,Optional<T>> maxBy(Comparator<? super T> comparator)	
    // 指定されたComparatorに従ってOptional<T>として記述された最大要素を生成するCollectorを返す
    // maxBy()は最大値の要素を取得する際に使用します。
    Stream<String> stream2 = 
                   Stream.of("101", "105", "106", "203", "205");
    Map<String, Optional<String>> result2 = 
                   stream2.collect(Collectors.groupingBy(
			                       s -> s.substring(0, 1),
			                       Collectors.maxBy(Comparator.naturalOrder())
			                       ));
    System.out.println(result2);
  }
}

// Answer
// akko
// {1=Optional[106], 2=Optional[205]}



