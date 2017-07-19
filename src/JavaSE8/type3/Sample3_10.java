package JavaSE8.type3;

import java.util.*;

public class Sample3_10 {
	  public static void main(String[] args) {
	    NavigableMap<String, String> map = new TreeMap<String, String>();
	    map.put("1111", "ItemA"); 
	    map.put("2222", "ItemB");
	    map.put("3333", "ItemC");
	    map.put("4444", "ItemD");
	    
	    String key = "2000";
	    if (map.containsKey(key)) { // キーがある場合
	      System.out.println("get()：" + map.get(key));
	    } else { // キーがない場合
	      System.out.println("higherKey() : " + map.higherKey(key));
	      System.out.println("lowerKey() : " + map.lowerKey(key));
	    }
	    
	    // TreeSetクラスではNavigatableSetインタフェースを実装している
	    NavigableMap<String, String> sub = map.subMap("2000", true, "3500", true);
	    NavigableMap<String, String> sub2 = map.subMap("2000", true, "4500", true);
	    
	    System.out.println("2000 - 3500 : " + sub);
	    System.out.println("2000 - 4500 : " + sub2);
	  }
	}

// Answer
// higherKey() : 2222
// lowerKey() : 1111
// 2000 - 3500 : {2222=ItemB, 3333=ItemC}
// 2000 - 4500 : {2222=ItemB, 3333=ItemC, 4444=ItemD}


