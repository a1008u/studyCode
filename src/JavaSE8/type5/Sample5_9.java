package JavaSE8.type5;

import java.util.*;
import java.util.stream.*;

public class Sample5_9 {
  public static void main(String[] args) {
	  
    List<String> data = Arrays.asList("aaa", "bb", "c");
    
    // Optional<T> max(Comparator<? super T> comparator) 
    // 指定されたComparatorに従って最大要素を返す。ストリームが空の場合は空のOptionalを返す	有
    // naturalOrderメソッド：staticメソッドであるnaturalOrder()メソッドを使用して、自然順序づけをする
    Optional<String> result1 = data.stream()
    							   .max(Comparator.naturalOrder());
    
    // ラムダで「int compare(T o1, T o2);」を実装
    Optional<String> result2 = data.stream()
    		                       .max((d1, d2) -> d1.length() - d2.length());
    
    // Optionalの変数に値がnullチェック
    // nullでない場合は「consumer.accept(value);」を実装(メソッド参照)
    result1.ifPresent(System.out::println);  
    System.out.println(result1.get());
    result2.ifPresent(System.out::println);  
    System.out.println(result2.get());
  }
}

// Answer
// c
// c
// aaa
// aaa