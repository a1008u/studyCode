package JavaSE8.type5;

import java.util.*;
import java.util.stream.*;

public class Sample5_10 {
  public static void main(String[] args) {
	  
    List<String> data = Arrays.asList("c", "a");
    
    //  Optional<T> findFirst()	
    //  最初の要素を返す。ストリームが空の場合は空のOptionalを返す	無
    Optional<String> result1 = data.stream().findFirst();
    
    //  Optional<T> findAny()	
    //  いずれかの要素を返す。ストリームが空の場合は空のOptionalを返す	無
    Optional<String> result2 = data.stream().findAny();
    
    System.out.println(result1.get());
    System.out.println(result2.get());
    
    // ----------------------------------------------------
    
    Stream<String> stream = Stream.empty();
    Optional<String> result3 = stream.findFirst();
    
    // System.out.println(result3.get());  実行時エラー
    result3.ifPresent(System.out::println); // 何も返さない(nullチェック)
    
    // ----------------------------------------------------
    
    IntStream intStream = IntStream.of(10, 20, 30);
    OptionalInt result4 = intStream.findFirst();
    // System.out.println(result4.get()); OptionalInt型にはget()メソッドは未定義
    System.out.println(result4.getAsInt());
  }
}

// Answer
// c
// c
// 10

// ifPresent()メソッドの処理内容からわかるとおり、OptionalクラスにはOptionalオブジェクトがemptyかどうか
// （つまり保持する値がnullかどうか）を判定して、処理を分岐するメソッドが提供されています。
// これにより、nullチェックを行うコードをOptional側に任せることができます。

// 戻り値の違い
// インタフェース名	　戻り値	メソッド
// Stream	　　 Optional<T>	findAny, findFirst, max, min
// IntStream	OptionalDouble	average
// IntStream	OptionalInt	findAny, findFirst, max, min
// IntStream	int	sum()