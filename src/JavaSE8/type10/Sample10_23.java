package JavaSE8.type10;

import java.util.*;
import java.util.stream.*;

public class Sample10_23 {
  public static void main(String[] args) {
	  
    IntStream stream = IntStream.rangeClosed(1, 3000);
    List<Integer> list = stream.boxed().collect(Collectors.toList());
    
    long start = System.nanoTime();
    new Sample10_23().foo(list);
    long start2 = System.nanoTime();
    System.out.println("stream()での結果 : " + (start2 - start));
    
    new Sample10_23().foo2(list);
    System.out.println("parallelStream()での結果 : " + (System.nanoTime() - start2));
  }
  
  void foo(List<Integer> list) {
    long count = list.stream().map(a -> task(a)).count();
    System.out.println(count);
  }
  
  void foo2(List<Integer> list) {
	    long count = list.parallelStream().map(a -> task(a)).count();
	    System.out.println(count);
  }
  
  int task(int num) {
    try {
      Thread.sleep(5);
    } catch(InterruptedException e) { 
      e.printStackTrace(); 
    }
    return ++num;
  }
}

/*
Answer
	3000
	stream()での結果 : 17401722626
	3000
	parallelStream()での結果 : 2202463090
*/