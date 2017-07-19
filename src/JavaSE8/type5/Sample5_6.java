package JavaSE8.type5;

import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class Sample5_6 {
  public static void main(String[] args) {
	  
	// 関数インタフェース(ラムダ)
    BinaryOperator<Integer> operator = (a, b) -> a + b;
    Stream<Integer> stream1 = Stream.of(10, 20, 30);
    
    // int result = stream1.reduce(operator);
    // OptionalクラスのifPresent()メソッドにより、
    // 値がある場合は引数の処理（System.out::println）が実行されます。
    Optional<Integer> result = stream1.reduce(operator);
    System.out.println(result.toString());  //Optional[60]
    result.ifPresent(System.out::println);  //出力は60
    
    Stream<Integer> stream2 = Stream.empty();
    Optional<Integer> result2 = stream2.reduce(operator);
    System.out.println(result2);            //出力はOptional.empty
    result2.ifPresent(System.out::println); //出力データなし
  }
}

// reduceの構文
// 構文1：T reduce(T identity, BinaryOperator<T> accumulator)
// 構文2：Optional<T> reduce(BinaryOperator<T> accumulator)
// 構文3：<U> U reduce(U identity,
// 		    BiFunction<U,? super T,U> accumulator,
// 		    BinaryOperator<U> combiner)