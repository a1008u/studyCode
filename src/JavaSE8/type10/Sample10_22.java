package JavaSE8.type10;

import java.util.*;

public class Sample10_22 {
  public static void main(String[] args) {
    Arrays.asList("a", "b", "c", "d", "e")
          .stream()
          .forEach(s -> System.out.print(s + " "));
    
    System.out.println();
    
    Arrays.asList("a", "b", "c", "d", "e")
          .parallelStream()
          .forEach(s -> System.out.print(s + " "));
  }
}

/*
Answer
	a b c d e 
	c a d e b 
*/