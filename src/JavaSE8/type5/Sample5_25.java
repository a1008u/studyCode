package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_25 {
  public static void main(String[] args) {
    //構文2の例 1
    Stream<String> stream1 = 
                Stream.of("belle", "akko", "ami", "bob", "nao");
    Map<String, Set<String>> map1= 
                stream1.collect(Collectors.groupingBy(
                                           s -> s.substring(0, 1),
                                           Collectors.toSet()));
    System.out.println(map1);
    
    //構文2の例 2
    Stream<String> stream2 = 
                Stream.of("belle", "akko", "ami", "bob", "nao");
    Map<String, String> map2= 
                stream2.collect(Collectors.groupingBy(
                                          s -> s.substring(0, 1),
                                          Collectors.joining()));
    System.out.println(map2);
    System.out.println("map2のクラス名 :" + map2.getClass());
    
    //構文3の例
    Stream<String> stream3 = 
                   Stream.of("belle", "akko", "ami", "bob", "nao");
    Map<String, String> map3= 
                stream3.collect(Collectors.groupingBy(
                                          s -> s.substring(0, 1),
                                          TreeMap::new,
                                          Collectors.joining()));
    System.out.println(map3);
    System.out.println("map3のクラス名 :" + map3.getClass());
  }
}

// Answer
// {a=[akko, ami], b=[bob, belle], n=[nao]}
// {a=akkoami, b=bellebob, n=nao}
// map2のクラス名 :class java.util.HashMap
// {a=akkoami, b=bellebob, n=nao}
// map3のクラス名 :class java.util.TreeMap

//構文1：
//static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(
//				Function<? super T,? extends K> classifier)
//
//構文2：
//static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(
//				Function<? super T,? extends K> classifier,
//				Collector<? super T,A,D> downstream)
//
//構文3：
//static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M> groupingBy(
//				Function<? super T,? extends K> classifier,
//				Supplier<M> mapFactory,
//				Collector<? super T,A,D> downstream)
