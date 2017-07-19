package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_16 {
  public static void main(String[] args) {
	  
	// Stream<T> sorted()	
	// 自然順序に従ってソートした結果から構成されるストリームを返す
    Stream.of("naoki", "akko", "ami")
          .sorted()
          .forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    // 明示的に並べ替えの順序を指定する場合は、
    // Comparatorオブジェクトを引数にもつsorted()メソッドを使用します
    Stream.of("naoki", "akko", "ami")
          .sorted(Comparator.reverseOrder())
          .forEach(x -> System.out.print(x + " "));
  }
}

// Answer
// akko ami naoki 
// naoki ami akko 
