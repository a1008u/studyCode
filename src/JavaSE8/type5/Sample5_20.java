package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_20 {
  public static void main(String[] args) {
	  
	// 終端操作のcollectメソッドとCollectorsクラスについて
	// collect() メソッドは名前のとおり、
	// ストリームから要素をまとめて1つのオブジェクトを取得することができます。
	  
    // toList()メソッド
	// static <T> Collector<T,?,List<T>> toList()	
	//		Listに蓄積するCollectorを返す
    Stream<String> stream1 = Stream.of("naoki", "akko", "ami");
    List<String> result1 = stream1.collect(Collectors.toList());
    System.out.println(result1);
    
    // joining()メソッド
    // static Collector<CharSequence,?, String> joining(CharSequencedelimiter)	
    //	入力要素を検出順に指定された区切り文字で区切りながら連結するCollectorを返す
    Stream<String> stream2 = Stream.of("naoki", "akko", "ami");
    String result2 = stream2.collect(Collectors.joining(" | "));
    System.out.println(result2);
    
    // summingInt()メソッド
    // static <T> Collector<T,?,Integer> summingInt(ToIntFunction<? super T> mapper)	
    //	int値関数を適用した結果の合計を生成するCollectorを返す。要素が存在しない場合、結果は0になる
    Stream<String> stream3 = Stream.of("naoki", "akko", "ami");
    Integer result3 = stream3.collect(Collectors.summingInt(t -> t.length()));
    System.out.println(result3);
    
    // averagingInt()メソッド
    // static <T> Collector<T,?,Double> averagingInt(ToIntFunction<? super T> mapper)	
    //	int値関数を適用した結果の算術平均を生成するCollectorを返す。要素が存在しない場合、結果は0になる
    Stream<String> stream4 = Stream.of("naoki", "akko", "ami");
    Double result4 = stream4.collect(Collectors.averagingInt(t -> t.length()));
    System.out.println(result4);
  }
}

// Answer
// [naoki, akko, ami]
// naoki | akko | ami
// 12
// 4.0

//Colletorsクラス(上記：構文1の説明)
//構文1：<R,A> R collect(Collector<? super T,A,R> collector)
//構文2：<R> R collect(Supplier<R> supplier,
// 			BiConsumer<R,? super T> accumulator,
// 			BiConsumer<R,R> combiner)

//Collectors クラスの主なメソッド
//メソッド名 	説明
//static <T> Collector<T,?,List<T>> toList()	
//		Listに蓄積するCollectorを返す
//static Collector<CharSequence,?, String> joining()	
//		入力要素を検出順に連結して1つのStringにするCollectorを返す
//static Collector<CharSequence,?, String> joining(CharSequencedelimiter)	
//		入力要素を検出順に指定された区切り文字で区切りながら連結するCollectorを返す
//static <T> Collector<T,?,Integer> summingInt(ToIntFunction<? super T> mapper)	
//		int値関数を適用した結果の合計を生成するCollectorを返す。要素が存在しない場合、結果は0になる
//static <T> Collector<T,?,Double> averagingInt(ToIntFunction<? super T> mapper)	
//		int値関数を適用した結果の算術平均を生成するCollectorを返す。要素が存在しない場合、結果は0になる
//static <T> Collector<T,?,Set<T>> toSet()	
//      Set に蓄積するCollector を返す
//static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K>key, Function<? super T,? extends U> value)	
//		Mapに蓄積するCollectorを返す
//static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)	
//		指定した関数に従って要素をグループ化し、結果をMapに格納して返すCollectorを返す
//static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate)	
//		指定した関数に従って要素をtrueもしくはfalse でグループ化し、結果をMapに格納して返すCollectorを返す
//static <T,U,A,R> Collector<T,?,R> mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)	
//		マッピングを行い、マップ後に指定された他のCollectorを適用し、その結果をMapに格納して返すCollectorを返す
//static <T> Collector<T,?,Optional<T>> maxBy(Comparator<? super T> comparator)	
//		指定されたComparatorに従ってOptional<T> として記述された最大要素を生成するCollectorを返す
//static <T> Collector<T,?,Optional<T>> minBy(Comparator<? super T> comparator)	
//		指定されたComparatorに従ってOptional<T> として記述された最小要素を生成するCollectorを返す
