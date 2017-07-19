package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_21 {
  public static void main(String[] args) {
    // toSet()メソッド
	// static <T> Collector<T,?,Set<T>> toSet()	
	//	 	Setに蓄積するCollectorを返す
    Stream<String> stream1 = Stream.of("naoki", "akko", "ami");
    Set<String> set= stream1.collect(Collectors.toSet());
    System.out.println(set);
    
    // toMap()メソッド
    // static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K>key, Function<? super T,? extends U> value)	
    // 	Mapに蓄積するCollectorを返す
    // マップはキーと値をセットで保持するため、toMap()メソッドの第1引数にキー、第2引数に値を指定しています。
    Stream<String> stream2 = Stream.of("naoki", "akko", "ami");
    Map<String, String> map= stream2.collect(Collectors.toMap(s -> s, String::toUpperCase));
    System.out.println(map);
  }
}

// Answer
// [naoki, akko, ami]
// {naoki=NAOKI, akko=AKKO, ami=AMI}




//上記は構文1を使用
//構文1：
//static <T,K,U> Collector<T,?,Map<K,U>> toMap(
//			    Function<? super T,? extends K> keyMapper,
//			    Function<? super T,? extends U> valueMapper)
//
//構文2：
//static <T,K,U> Collector<T,?,Map<K,U>> toMap(
//			    Function<? super T,? extends K> keyMapper,
//			    Function<? super T,? extends U> valueMapper,
//			    BinaryOperator<U> mergeFunction)
//
//構文3：
//static <T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(
//			    Function<? super T,? extends K> keyMapper,
//			    Function<? super T,? extends U> valueMapper,
//			    BinaryOperator<U> mergeFunction,
//			    Supplier<M> mapSupplier)