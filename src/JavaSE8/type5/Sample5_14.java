package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_14 {
  public static void main(String[] args) {
	  
    //Stream<String>→Stream<String>
    Stream<String> stream1a = Stream.of("naoki", "akko", "ami");
   
    //　< R > Stream < R > map( Function < ? super T,? extends R> mapper)	
    //	指定された関数を適用した結果から構成されるストリームを返す 抽象メソッド：R apply(T t);
    Stream<String> stream1b = stream1a.map( s -> s.toUpperCase());
    stream1b.forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    //Stream<String>→Stream<Integer>
    Stream<String> stream2s = Stream.of("naoki", "akko", "ami");
    
    //　< R > Stream < R > map( Function < ? super T,? extends R> mapper)	
    //	指定された関数を適用した結果から構成されるストリームを返す　抽象メソッド：R apply(T t);　
    Stream<Integer> stream2i = stream2s.map( s -> s.length());
    stream2i.forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    //IntStream→IntStream
    IntStream stream3a = IntStream.of(1, 2, 3);
    IntStream stream3b = stream3a.map( n -> n * 10);
    stream3b.forEach(x -> System.out.print(x + " "));
  }
}

// Answer
// NAOKI AKKO AMI 
// 5 4 3 
// 10 20 30 

