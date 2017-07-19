package JavaSE8.type3;

import java.util.*;
import java.util.stream.Stream;

public class Sample3_21 {
  public static void main(String[] args) {
    String[ ] ary = {"A","B","C"};
    List<String> list = Arrays.asList(ary);
    // list.add("D"); 実行時エラー
    list.set(2, "D");
    
    for(int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
  
   System.out.println();
   list.stream().map(a -> a.toLowerCase()).forEach(System.out::print);;
    
    System.out.println();
    Stream.of(ary).forEach(System.out::print);
    System.out.println();
    Stream.of(list).forEach(System.out::print);
    
    
    
  }
}

// Answer
// A B D 