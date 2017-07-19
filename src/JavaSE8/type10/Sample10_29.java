package JavaSE8.type10;

import java.util.*;
import java.util.stream.*;

public class Sample10_29 {
  public static void main(String[] args) {
    
    // static <T,K> Collector<T,?, ConcurrentMap<K,List<T>>> groupingByConcurrent(Function<? super T,? extends K> classifier)	
	//  指定した関数に従って要素をグループ化し、結果をConcurrentMapに格納して返す並行Collectorを返す
	Stream<String> stream1 = Stream.of("belle", "akko", "ami", "bob", "nao").parallel();
    Map<String, List<String>> map1 = stream1.collect(Collectors.groupingByConcurrent(s -> s.substring(0, 1)));
    System.out.println(map1);
    System.out.println("map1のクラス名 :" + map1.getClass());
    
    // static <T,K,U> Collector< T,?,ConcurrentMap<K,U>>toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
    //  Mapに蓄積する並行Collectorを返す
    Stream<String> stream2 = Stream.of("nao", "akko", "ami").parallel();
    Map<Integer, String> map2 = 
            stream2.collect(Collectors.toConcurrentMap(
                                       String::length,
                                       s -> s,
                                       (s1, s2) -> s1 + " : " + s2));
    System.out.println(map2);
    System.out.println("map2のクラス名 :" + map2.getClass());
  }
}
/*
Answer
	{a=[akko, ami], b=[belle, bob], n=[nao]}
	map1のクラス名 :class java.util.concurrent.ConcurrentHashMap
	{3=nao : ami, 4=akko}
	map2のクラス名 :class java.util.concurrent.ConcurrentHashMap
*/
/*
	groupingByConcurrent()メソッドとtoConcurrentMap()メソッド
		Collectorsクラスには、パラレルストリームのみで使用されるメソッドとして以下が提供されています。
		各メソッドはオーバーロードされていますが、ここでは1つずつのみ掲載します。
		groupingByConcurrent() メソッドとtoConcurrentMap() メソッド
		メソッド名	 説明a
		static <T,K> Collector<T,?, ConcurrentMap<K,List<T>>> groupingByConcurrent(Function<? super T,? extends K> classifier)	
					指定した関数に従って要素をグループ化し、結果をConcurrentMap に格納して返す並行Collector を返す
		static <T,K,U> Collector< T,?,ConcurrentMap<K,U>>toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
				Map に蓄積する並行Collector を返す
*/