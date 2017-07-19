package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_26 {
  public static void main(String[] args) {
	  
	// partitioningBy()メソッドはPredicate型で行う。(つまり戻り値がBoolean値となります。)
	// static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate)	
	// 指定した関数に従って要素をtrueもしくはfalseでグループ化し、結果をMapに格納して返すCollectorを返す
	  
    //構文1の例 1
    Stream<Integer> stream1 = Stream.of(3, 5, 7, 9);
    Map<Boolean, List<Integer>> map1= 
                stream1.collect(Collectors.partitioningBy(s -> s > 5));
    System.out.println(map1);
    
    //構文1の例 2
    Stream<Integer> stream2 = Stream.of(3, 5, 7, 9);
    Map<Boolean, List<Integer>> map2= 
                stream2.collect(Collectors.partitioningBy(s -> s > 10));
    System.out.println(map2); 
    
    //構文2の例
    Stream<Integer> stream3 = Stream.of(3, 5, 7, 9);
    Map<Boolean, Integer> map3= 
                stream3.collect(
                        Collectors.partitioningBy(
                                   s -> s > 5,
                                   Collectors.summingInt(n -> n)));
    System.out.println(map3);
  }
}

// Answer
// {false=[3, 5], true=[7, 9]} 
// {false=[3, 5, 7, 9], true=[]}
// {false=8, true=16}

//partitioningBy()メソッドは、groupingBy()と同様に指定した条件に従ってグルーピングを行います。
//各メソッドの異なる点は、
//	・groupingBy()メソッドはグループ化の処理をFunction型で行う。
//	・partitioningBy()メソッドはPredicate型で行う。(つまり戻り値がBoolean値となります。)
//partitioningBy()メソッドは2つ提供されています。

//構文1：
//static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(
//				     Predicate<? super T> predicate)
//
//構文2：
//static <T,D,A> Collector<T,?,Map<Boolean,D>> partitioningBy(
//				     Predicate<? super T> predicate,
//				     Collector<? super T,A,D> downstream)

