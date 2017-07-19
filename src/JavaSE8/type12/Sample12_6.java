package JavaSE8.type12;

import java.util.*;

public class Sample12_6 {
  public static void main(String[] args) {
    ResourceBundle bundle
            = ResourceBundle.getBundle("MResources", Locale.US);
    
    Properties props = new Properties();
    
    bundle.keySet()
          .stream()
          .forEach(k -> props.put(k, bundle.getString(k)));
    
    method(props);
  }
  static void method(Properties props) {
    System.out.println(props.get("send"));
    System.out.println(props.getProperty("send"));
    System.out.println(props.get("xxx"));
    System.out.println(props.getProperty("xxx"));
    System.out.println(props.getProperty("xxx", "default"));
  }
}

/*
	Answer
		P_send
		P_send
		null
		null
		default
*/