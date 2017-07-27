package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_5 {
  public static void main(String[] args) {
	  
	// T reduce(T identity, BinaryOperator<T> accumulator)	
	// 元の値と結合的な累積関数を使ってこのストリームの要素に対してリダクションを実行し、リデュースされた値を返す	有
    
    // reduce(初期値, BinaryOperatorの処理)
    int result = IntStream.of(10, 20, 30)
                          .reduce(0, (int a, int b) -> a + b);
    System.out.println(result);
   
    // 実行時エラー(stream変数は1回以上終端操作をできないため)
    int result2 = IntStream.of(10, 20, 30)
                           .reduce(0, Integer::sum);
    System.out.println(result2);
  }
}

// Answer
// 60