package JavaSE8.type3;

import java.util.ArrayList;

class Sample3_1 {
  public static void main(String[] args) {
	  
    ArrayList<Integer> list = new ArrayList<Integer>();
    Integer i1 = new Integer(1);
    int i2 = 2;
    Integer i3 = i1;
    list.add(i1);
    list.add(i2);   // intデータはAutoboxingによりIntegerに変換
    list.add(i3);   // 重複要素
    list.add(1, 5); // インデックス1番目に5を追加
    //list.add("abc");
    
    System.out.println("size : " + list.size());
    for ( int i = 0; i < list.size() ; i++) {
      System.out.print(list.get(i) + " ");
    }
    
    System.out.println();
    
    for (Integer i : list) { System.out.print(i + " "); }
  }
}

// Answer
// size : 4
// 1 5 2 1 
// 1 5 2 1 


/* Collection
 *  list(ArraList, LinkedList, Vector)
 *  set(HashSet,TreeSet,LinkedHashSet) <- SortSet
 *  Queue(ArrayDeque(FIFO形式))
 *  
 * Map(HashMap, TreeMap, LinkedHashMap) <- SortedMap
 * 
 */
