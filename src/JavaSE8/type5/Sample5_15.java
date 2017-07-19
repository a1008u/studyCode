package JavaSE8.type5;

import java.util.*;

public class Sample5_15 {
  public static void main(String[] args) {
	  
    List<Integer> data1 = Arrays.asList(10);
    List<Integer> data2 = Arrays.asList(20, 30);
    List<Integer> data3 = Arrays.asList(40, 50, 60);
    List<List<Integer>> dataList = Arrays.asList(data1, data2, data3);
    
    // map()を使用した場合
    // < R > Stream < R > map( Function < ? super T,? extends R> mapper)	
    // 指定された関数を適用した結果から構成されるストリームを返す
    // map()メソッドは1要素に対して結果も1つ（1 対1）である
    dataList.stream()
            .map(data -> data.stream())
            .forEach(l -> {l.forEach(x -> System.out.print(x + " "));});
    
    System.out.println();
    
    // flatMap()を使用した場合
    // <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)	
    //	指定された関数を適用した複数の結果から構成される1つのストリームを返す
    // flatMap()メソッドは1要素に対して複数の結果を返します
    dataList.stream()
            .flatMap(data -> data.stream())
            .forEach(x -> System.out.print(x + " "));
  }
}

// Answer
// 10 20 30 40 50 60 
// 10 20 30 40 50 60 


