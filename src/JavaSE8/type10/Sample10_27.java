package JavaSE8.type10;

import java.util.*;
import java.util.stream.*;

public class Sample10_27 {
  public static void main(String[] args) {
	  
	/* 構文3：<U> U reduce(U identity,
	            BiFunction<U,? super T,U> accumulator,
	            BinaryOperator<U> combiner)
	構文3の第1引数は初期値、第2引数は集約処理を指定します。
	そして第3引数はパラレルストリームの場合のみ適用されます。
	パラレル処理で集約処理を行っている場合、
	複数の場所で部分的な途中の集約処理が必要になります。
	この途中の集約結果のマージ処理に使用するのが第3引数です。 
    */ 
	  
    Integer total = Arrays.asList(10, 20, 30, 40, 50)
				          .parallelStream()
				          .reduce(0,
					              (sum, a) -> {
					                  System.out.println("sum:" + sum + " a:" + a);
					                  return sum += a;
					              },
					              (b, c) -> {
					                  System.out.println("b:" + b + " c:" + c);
					                  return b + c;
					              });
    
    System.out.println("total : " + total);
  }
}

/*
	Answer
	sum:0 a:40
	sum:0 a:30
	sum:0 a:50
	sum:0 a:10
	b:40 c:50
	sum:0 a:20
	b:30 c:90
	b:10 c:20
	b:30 c:120
	total : 150
*/

/*
reduce()メソッドとcollect()メソッドの利用
reduce()はオーバーロードされており、集約処理を行うメソッドです。
本章では5章では扱わなかった構文3 について確認します。

構文1：T reduce(T identity, BinaryOperator<T> accumulator)
構文2：Optional<T> reduce(BinaryOperator<T> accumulator)
構文3：<U> U reduce(U identity,
            BiFunction<U,? super T,U> accumulator,
            BinaryOperator<U> combiner)

構文3の第1引数は初期値、第2引数は集約処理を指定します。
そして第3引数はパラレルストリームの場合のみ適用されます。
パラレル処理で集約処理を行っている場合、複数の場所で部分的な途中の集約処理が必要になります。
この途中の集約結果のマージ処理に使用するのが第3引数です。
*/