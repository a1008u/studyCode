package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_24 {
  public static void main(String[] args) {
	  
	// groupingBy()メソッドは、指定した条件に従ってグルーピングを行います。
	// groupingBy()メソッドもオーバーロードされています。
	// 各メソッドの第1引数を見ると、Function（メソッドは「R apply(T t)」）となっています。
	// つまり、apply()の引数に要素を渡して、戻り値としてマップのキーとなる値を返すような処理を指定します。
	// 同じキーを返せば、同じグループに属するという意味になります。  
	
	// static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)	
	// 指定した関数に従って要素をグループ化し、結果をMapに格納して返すCollectorを返す
    Stream<String> stream = Stream.of("belle", "akko", "ami", "bob", "nao");
    Map<String, List<String>> map = stream.collect(Collectors.groupingBy(s -> s.substring(0, 1)));
    System.out.println(map);
  }
}

// Answer
// {a=[akko, ami], b=[belle, bob], n=[nao]}

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