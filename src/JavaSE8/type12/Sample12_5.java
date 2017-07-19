package JavaSE8.type12;

import java.util.*;

public class Sample12_5 {
  public static void main(String[] args) {
	  
    ResourceBundle bundle
            = ResourceBundle.getBundle("MResources", Locale.US);
    
    Set<String> keys = bundle.keySet();
    
    keys.stream()
	    .map(k -> bundle.getString(k))
	    .forEach(System.out::println);
  }
}

/*
	Answer
		P_cancel
		P_send
*/