package JavaSE8.type10;

import java.util.*;

public class Sample10_8 {
  public static void main(String[] args) {
	  
	  // 並列コレクション
	  // あるスレッドがコレクションオブジェクトで反復処理を行っている間に、
	  // 別のスレッドがそのコレクションオブジェクトを変更することは一般に許可されません。
	  
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "tanaka"); map.put(2, "urai");
    //map.remove(1);      map.remove(2); これは可能
    for(Integer key : map.keySet()) { map.remove(key); }
  }
}

//Answer
// Exception in thread "main" java.util.ConcurrentModificationException
// at java.util.HashMap$HashIterator.nextNode(HashMap.java:1429)
// at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
// at type10.Sample10_8.main(Sample10_8.java:13)
