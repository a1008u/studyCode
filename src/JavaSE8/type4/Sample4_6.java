package JavaSE8.type4;

import java.util.*;
import java.util.function.*;

public class Sample4_6 {
  public static void main(String[] args) {
	  
    List<Integer> list = Arrays.asList(3, 1, 2);
    
    // Consumer<T>	void accept(T t)	
    // 実装するメソッドは、引数としてT を受け取り、結果を返さない
    
    /* 匿名クラスを使用した場合---------------------- */ 
	    Consumer<List<Integer>> con3 = new Consumer<List<Integer>>() {
	      public void accept(List<Integer> list) {
	        Collections.sort(list);
	      }
	    };
   
    
    /* ラムダ式  ------------------------------------    */
    Consumer<List<Integer>> con2 = lambdaList -> Collections.sort(lambdaList);
    System.out.println("con2 " + list);
    con2.accept(list);
    System.out.println("con2 " + list);
    
    //statcメソッド参照   --------------------------
    Consumer<List<Integer>> con1 = Collections::sort;
    
    con1.accept(list);  
    System.out.println(list);
  }
}

// Answer
// [1, 2, 3]

// 呼び出すメソッドがstaticメソッドの場合、「クラス名:: メソッド名」とします。
// 次のサンプルでは、関数型インタフェースであるConsumerのaccept()メソッドを実装しています。
// なお、accept()メソッドは引数を1つとり、戻り値はvoidです。
// 処理としては、Collectionsクラスのsort()メソッドを呼び出しています。