package JavaSE8.type10;

import java.util.*;

public class Sample10_11{
  public static void main(String[] args) {
	  
    ArrayList<String> list = new ArrayList<String>();
    list.add("A"); list.add("B"); list.add("C"); list.add("D");
    
    new Thread(() -> { 
      Iterator itr = list.iterator();
      while(itr.hasNext()){
        System.out.println("ThreadA : " + itr.next());
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) { e.printStackTrace(); }
      }
    }).start();
    
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) { e.printStackTrace(); 
    }
    
    list.add("E"); System.out.println("main : add()");
    list.remove(2); System.out.println("main : remove()");
  }
}

/*
Answer
	ThreadA : A
	main : add()
	main : remove()
	Exception in thread "Thread-0" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at type10.Sample10_11.lambda$0(Sample10_11.java:12)
	at java.lang.Thread.run(Thread.java:745)

*/
/*
	ArrayListクラスとSetインタフェースの拡張
	クラス名	説明
	CopyOnWriteArrayList	
		もとになる配列の新しいコピーを作成することにより、
		スレッドセーフを実現するArrayListを拡張
	CopyOnWriteArraySet	
		内部でCopyOnWriteArrayListオブジェクトを使用して、
		スレッドセーフを実現するSetインタフェースの拡張
*/