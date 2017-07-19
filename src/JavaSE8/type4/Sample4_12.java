package JavaSE8.type4;

import java.util.function.*;

public class Sample4_12 {
  public static void main(String[] args) {
	 
    Function<Integer, String[]> obj1 =  String[]::new;
    System.out.println("obj1 : "+obj1.apply(5).length);

	Function<Integer, String[]> obj2 = length -> new String[length];
	System.out.println("obj2 : "+obj2.apply(5).length);

  }
}

// Answer
// obj1 : 5
// obj2 : 5
