package JavaSE8.type10;

import java.util.*;
import java.util.stream.*;

public class Sample10_26 {
  public static void main(String[] args) {
	  
    List<String> data = Arrays.asList("c", "a", "d", "b");
    
    Optional<String> rerult1 = data.parallelStream().findFirst();
    Optional<String> rerult2 = data.parallelStream().findAny();
    
    System.out.println(rerult1.get() + " " + rerult2.get());
  }
}

/*
Answer
	c d
*/