package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_18 {
  public static void main(String[] args) {
	  
	// ストリームインタフェースの型変換を行うメソッドの使用例
	  
	// 関数インタフェース参考
	// Function<T,R>	R apply(T t)
	// ToIntFunction<T>	int applyAsInt(T value)
	// IntFunction<R>	R apply(int value)
	  
    // 1.Stream<String>→Stream<Integer> 
	//　① Stream <String>	map	Function<? super T,? extends R> mapper	Stream<Integer>
    Stream<String> stream1o = Stream.of("a", "b");
    Stream<Integer> stream1n = stream1o.map( s -> s.length());
    
    // 2.Stream<String>→IntStream
    //② Stream <String>	mapToInt	ToIntFunction<? super T> mapper	IntStream
    Stream<String> stream2o = Stream.of("naoki", "akko", "ami");
    IntStream stream2n = stream2o.mapToInt( s -> s.length());
    
    // 3.Stream<Integer>→IntStream
    //③ Stream <Integer>	mapToInt	ToIntFunction<? super T> mapper	IntStream
    Stream<Integer> stream3o = Stream.of(1, 2, 3);
    IntStream stream3n = stream3o.mapToInt(n -> n);
    
    // 4.Stream<Integer>→Stream<String>
    //④ Stream <Integer>	map	Function<? super T,? extends R> mapper	Stream<String>
    Stream<Integer> stream4o = Stream.of(1, 2, 3);
    Stream<String> stream4n = stream4o.map(  n -> n + "a" );
    
    // 5.IntStream→Stream<String>
    //⑤ IntStream	mapToObj	IntFunction<? extends U> mapper	Stream<String>
    IntStream stream5o = IntStream.of(1, 2, 3);
    Stream<String> stream5n = stream5o.mapToObj( n -> n + "a" );
    
    // 6.IntStream→Stream<Integer>
    //⑥ IntStream	boxed	なし	Stream<Integer>
    IntStream stream6o = IntStream.of(1, 2, 3);
    Stream<Integer> stream6n = stream6o.boxed(); 
  }
}

//ストリームインタフェースの型変換を行うメソッド
//インターフェース名	
//	- Streamの生成	
//	- DoubleStreamの生成	
//	- IntStreamの生成	
//	- LongStreamの生成
//Stream	
//	- map()	
//	- mapToDouble()	
//	- mapToInt()	
//	- mapToLong()
//DoubleStream	
//	- mapToObj()	
//	- map()	
//	- mapToInt()	
//	- mapToLong()
//IntStream	
//	- mapToObj()	
//	- mapToDouble()	
//	- map()	
//	- mapToLong()
//LongStream	
//	- mapToObj()	
//	- mapToDouble()	
//	- mapToInt()	
//	- map()

