package JavaSE8.type5;

import java.util.*;
import java.util.stream.*;

public class Sample5_3 {
  public static void main(String[] args) {
	  
	// 終端操作の主なメソッド
	// allMatch()メソッドは、指定された条件にすべての要素が一致するかどうかをboolean値で返します。
	// anyMatch()メソッドは、指定された条件にいずれかの要素が一致するかどうかをboolean値で返します。
	// noneMatch()メソッドは、指定された条件にどの要素も一致しないかをboolean値で返します。
	// 全引数は、Predicateインスタンス 抽象メソッド：boolean test(T t);
	  
    List<String> data1 = Arrays.asList("mana", "naoki", "ryo");
    boolean result1 = data1.stream().allMatch(s -> s.length() >= 3);
    boolean result2 = data1.stream().anyMatch(s -> s.length() == 4);
    boolean result3 = data1.stream().noneMatch(s -> s.length() == 4);
    
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    
    // 1つのストリームオブジェクトに対して、終端操作は1度しか呼び出せない(実行時エラー)
	Stream<String> stream1 = data1.stream();
	boolean result4 = stream1.allMatch(s -> s.length() >= 3);
	boolean result5 = stream1.anyMatch(s -> s.length() == 4); 
	System.out.println(result4);
	System.out.println(result5);
  }
}

// Answer
// true
// true
// false
//Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
// at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
// at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:449)
// at type5.Sample5_3.main(Sample5_3.java:20)

/*
 * 終端操作の主なメソッド
	メソッド名	 説明 R(R列は、リダクション操作のサポートの有無を記載)
	boolean allMatch(Predicate<? super T> predicate)	
		すべての要素が指定された条件に一致するかどうかを返す。
		一致しているか、ストリームが空の場合はtrue、それ以外の場合はfalse
		無
	boolean anyMatch(Predicate<? super T> predicate)	
		いずれかの要素が指定された条件に一致するかどうかを返す。
		存在する場合はtrue、そうでない場合か、ストリームが空の場合はfalse
		無
	boolean noneMatch(Predicate<? super T> predicate)	
		どの要素も指定された条件に一致しないか、
		ストリームが空の場合はtrue、
		それ以外の場合はfalseを返す
		無
	<R,A> R collect(Collector<? super T,A,R> collector)	
		要素に対する可変リダクション操作を実行する
		有
	<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)	
		要素に対する可変リダクション操作を実行する
		有
	long count()	
		要素の個数を返す
		有
	Optional<T> findAny()	
		いずれかの要素を返す。ストリームが空の場合は空のOptionalを返す
		無
	Optional<T> findFirst()	
		最初の要素を返す。ストリームが空の場合は空のOptionalを返す
		無
	void forEach(Consumer<? super T> action)	
		各要素に対して指定されたアクションを実行する
		無
	Optional<T> min(Comparator<? super T> comparator)	
		指定されたComparator に従って最小要素を返す。
		ストリームが空の場合は空のOptionalを返す
		有
	Optional<T> max(Comparator<? super T> comparator)	
		指定されたComparator に従って最大要素を返す。
		ストリームが空の場合は空のOptionalを返す
		有
	T reduce(T identity, BinaryOperator<T> accumulator)	
		元の値と結合的な累積関数を使ってこのストリームの要素に対してリダクションを実行し、リデュースされた値を返す
		有
	Object[] toArray()	
		要素を含む配列を返す
		無
	<A> A[] toArray(IntFunction<A[]> generator)	
		引数に結果となる配列の要素の型を指定し、配列を返す
		無
*/
