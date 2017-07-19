package JavaSE8.type5;

import java.util.*;

public class Sample5_1 {
  public static void main(String[] args) {
	  
    // ソース-----------------------------------------------
    List<String> list = Arrays.asList("bb", "aa", "cc");

    // 実装例1 (大文字変換→ソート→出力)
    for(int i = 0; i < list.size(); i++) {
      String str = list.get(i).toUpperCase();
      list.set(i, str);
    }
    Collections.sort(list);
    for(String s : list) {
      System.out.print(s + " ");
    }
    System.out.println();
    
    // ソース-----------------------------------------------
    list = Arrays.asList("bb", "aa", "cc");  
    // 実装例2(ストリームのパイプライン処理)
    list.stream().sorted() //①
    			 .map(s -> s.toUpperCase()) //②
    			 .forEach(s -> System.out.print(s + " "));
  }
}

// Answer
// AA BB CC 
// AA BB CC 

// ストリームAPIは「コレクション、配列、I/O リソースなどのデータ提供元となるデータソースをもとに、集計操作を行うAPI 」です。
// ストリームは、ある処理結果を次の処理のデータソース（入力）として渡すことができます。
// 複数の値を保持し、順次処理していく。
// ソース(Listを作成("c","a","b"))　→　処理１(大文字にする("C","A","B")) → 処理１(昇順にする("A","B","C"))　→　要素を出力

// ストリームのパイプライン処理
// パイプライン処理には、処理のもととなる「データソース」が必要です。
// データソースをもとにストリームオブジェクトを生成し、後続する処理を行います。
// なお、処理①や処理②のように、パイプラインの途中で行う処理を「中間操作」と呼び、
// パイプラインの最後に行う処理を「終端操作」と呼びます。
// 中間操作では「何を行うか」のみをパイプラインでつなげて、終端操作のメソッドが実行された際に初めて、すべての処理が行われます。
//
// ●　問合せの対象となるデータソース：コレクション、配列、I/O リソースなど
// ●　中間操作：ストリーム・パイプラインを形成
// ●　終端操作：ストリーム・パイプラインを実行して結果を生成

// ストリーム生成用の主なメソッド
// メソッド名	 説明
// default Stream<E> stream()	
// 	Collectionインタフェースで提供。このコレクションをソースとして使用して、逐次的なStream オブジェクトを返す 
// static <T> Stream<T> stream(T[] array)	
// 	Arraysクラスで提供。指定された配列をソースとして使用して、逐次的なStream オブジェクトを返す 
// static IntStream stream(int[] array)	
// 	Arraysクラスで提供。指定されたint 型の配列をソースとして使用して、逐次的なIntStreamオブジェクトを返す 
// static <T> Stream<T> of(T t)	
// 	Streamインタフェースで提供。指定された単一の要素をソースとして使用して、逐次的なStream オブジェクトを返す
// static <T> Stream<T> of(T... values)	
// 	Streamインタフェースで提供。指定された要素をソースとして使用して、逐次的なStream オブジェクトを返す
// static <T> Stream<T> empty()	
// 	Streamインタフェースで提供。空のStream オブジェクトを返す
// static <T> Stream<T> generate(Supplier<T> s)	
// 	Streamインタフェースで提供。指定されたSupplier（ラムダ式）によって生成される要素に対する順序付けされていないStream オブジェクトを返す
// static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)	
// 	Streamインタフェースで提供。順序づけされた無限順次Streamを返す
// static DoubleStream of(double... values)	
// 	DoubleStreamインタフェースで提供。指定された要素をソースとして使用して、逐次的なStream オブジェクトを返す
// static IntStream range(int startInclusive, int endExclusive)	
// 	IntStreamインタフェースで提供。startInclusive（含む）からendExclusive（含まない）の範囲の値を含む、順序付けされた順次IntStreamを返す
// static IntStream rangeClosed(int startInclusive, int endInclusive)	
// 	IntStreamインタフェースで提供。startInclusive（含む）からendInclusive（含む）の範囲の値を含む、順序付けされた順次IntStreamを返す
// static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)	
// 	Stream インタフェースで提供。順序づけされた無限順次Streamを返す
// static DoubleStream of(double... values)	
// 	DoubleStreamインタフェースで提供。指定された要素をソースとして使用して、逐次的なStream オブジェクトを返す
// static IntStream range(int startInclusive, int endExclusive)	
// 	IntStreamインタフェースで提供。startInclusive（含む）からendExclusive（含まない）の範囲の値を含む、順序付けされた順次IntStream を返す
// static IntStream rangeClosed(int startInclusive, int endInclusive)	
//	IntStream インタフェースで提供。startInclusive（含む）からendInclusive（含む）の範囲の値を含む、順序付けされた順次IntStream を返す