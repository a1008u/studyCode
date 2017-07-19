package JavaSE8.type3;

import java.util.*;

public class Sample3_18 {
  public static void main(String[] args) {
	  
    HashSet<Integer> hSet = new HashSet<>();
    hSet.add(300); 
    hSet.add(20); 
    hSet.add(500);
    System.out.println("HashSet : " + hSet);
    
    TreeSet<Integer> tSet1 = new TreeSet<>();
    tSet1.add(300); 
    tSet1.add(20); 
    tSet1.add(500);
    System.out.println("TreeSet1 : " + tSet1);
    
    TreeSet<String> tSet2 = new TreeSet<>();
    tSet2.add("nao"); 
    tSet2.add("Nao"); 
    tSet2.add("100");
    System.out.println("TreeSet2 : " + tSet2);
    
    TreeMap<String, Integer> tMap = new TreeMap<>();
    tMap.put("2", 300);  
    tMap.put("3", 20); 
    tMap.put("1", 500); 
    System.out.println("TreeMap : " + tMap);
    
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "value1");
    map.put(2, "value2");
    map.put(3, "value3");
    
    System.out.println("map.entrySet() : " + map.entrySet());
    
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
    	System.out.println(entry.getKey() + " " + entry.getValue());
    }
    
    
  }
}

// Answer
// HashSet : [20, 500, 300]
// TreeSet1 : [20, 300, 500]
// TreeSet2 : [100, Nao, nao]
// TreeMap : {1=500, 2=300, 3=20}
// map.entrySet() : [1=value1, 2=value2, 3=value3]
// 1 value1
// 2 value2
// 3 value3
