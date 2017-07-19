package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_23 {
  public static void main(String[] args) {
    //　toMap()メソッド 構文2の例
    Stream<String> stream1 = Stream.of("nao", "akko", "ami");
    Map<Integer, String> map1 = 
            stream1.collect(Collectors.toMap(
                                       String::length,
                                       s -> s, // 第2引数を指定
                                       (s1, s2) -> {return s1 + " : " + s2;})); // 第3引数としてマージ処理を指定
    System.out.println(map1);
    System.out.println(map1.getClass());
    
    //　toMap()メソッド(実行時エラー防止) 構文3の例
    Stream<String> stream2 = Stream.of("nao", "akko", "ami");
    Map<Integer, String> map2 = 
            stream2.collect(Collectors.toMap(
                                       String::length,
                                       s -> s,
                                       (s1, s2) -> s1 + " : " + s2,
                                       TreeMap::new));
    System.out.println(map2);
    System.out.println(map2.getClass());
  }
}

// Answer
// {3=nao : ami, 4=akko}
// class java.util.HashMap
// {3=nao : ami, 4=akko}
// class java.util.TreeMap

// 構文2：
// static <T,K,U> Collector<T,?,Map<K,U>> toMap(
//			    Function<? super T,? extends K> keyMapper,
//			    Function<? super T,? extends U> valueMapper,
//			    BinaryOperator<U> mergeFunction)
// 構文3：
// static <T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(
//					    Function<? super T,? extends K> keyMapper,
//					    Function<? super T,? extends U> valueMapper,
//					    BinaryOperator<U> mergeFunction,
//					    Supplier<M> mapSupplier)