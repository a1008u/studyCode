package JavaSE8.type5;

import java.util.stream.*;


public class Sample5_27 {
  public static void main(String[] args) {
	  
    // map()メソッドの例
    Stream<String> stream1 = Stream.of("naoki", "akko", "ami");
    
    String result1 = stream1.map( s -> s.toUpperCase())
    					    .collect(Collectors.joining(":"));
    System.out.println(result1);
    
    // mapping()メソッドの例
    // map()メソッドと同様にストリームの各要素に対して行いたい処理を指定します。
    // ただし、引数は2つもちます。
    // 	 ・第1引数に要素に対して行いたい処理
    // 	 ・第2引数はマップ後に行いたい処理
    Stream<String> stream2 = Stream.of("naoki", "akko", "ami");
    String result2 = stream2.collect(
                     Collectors.mapping( s -> s.toUpperCase(),
                                         Collectors.joining(":")));
    System.out.println(result2);
  }
}

// Answer
// NAOKI:AKKO:AMI
// NAOKI:AKKO:AMI


