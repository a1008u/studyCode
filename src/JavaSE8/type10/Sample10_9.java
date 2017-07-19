package JavaSE8.type10;

import java.util.concurrent.*;

public class Sample10_9 {
  public static void main(String[] args) {
	  
	  /*
	  同期化をサポートしたキューの主なインタフェースとクラス
	  インタフェース／クラス名	説明
	  BlockingQueuedインタフェース	要素を取り出すときに、キューを空にしないために待機するようQueueインタフェースを拡張
	  SynchronousQueueクラス	BlockingQueueインタフェースを実装した基本的なブロッキングキュー
	  LinkedBlockingQueueクラス	リンクノードに基づいたFIFOブロッキングキュー
	  ArrayBlockingQueueクラス	配列に基づいたFIFOブロッキングキュー
	  PriorityBlockingQueueクラス	キュー内の要素を指定された順序でソートするブロッキングキュー
	  DelayQueueクラス	遅延時間が経過後にのみ、要素を取得できるブロッキングキュー

	  BlockingQueue インタフェースの主なメソッド
	  例外のスロー	特殊な値	ブロック	タイムアウト
	  挿入	add(e)	offer(e)	put(e)	offer(e, time, unit)
	  削除	remove()	poll()	take()	poll(time, unit)
	  検査	element()	peek()	適用外	適用外

	  BlockingDeque インタフェースの主なメソッド
	  最初の要素(先頭)
	  例外のスロー	特殊な値	ブロック	タイムアウト
	  挿入	addFirst(e)	offerFirst(e)	putFirst(e)	offerFirst(e, time, unit)
	  削除	removeFirst()	pollFirst()	takeFirst()	pollFirst(time, unit)
	  検査	getFirst()	peekFirst()	適用外	適用外

	  最後の要素( 末尾)
	  例外のスロー	特殊な値	ブロック	タイムアウト
	  挿入	addLast(e)	offerLast(e)	putLast(e)	offerLast(e, time, unit)
	  削除	removeLast()	pollLast()	takeLast()	pollLast(time, unit)
	  検査	getLast()	peekLast()	適用外	適用外

	  */ 
	  
	// BlockingQueuedインタフェース要素を取り出すときに、キューを空にしないために待機するようQueueインタフェースを拡張
	// LinkedBlockingQueue クラス	リンクノードに基づいたFIFOブロッキングキュー
/*    BlockingQueue インタフェースの主なメソッド
	       例外のスロー	特殊な値	 ブロック	タイムアウト
	  挿入	add(e)	    offer(e) put(e)	offer(e, time, unit)
	  削除	remove()	poll()	 take()	poll(time, unit)
	  検査	element()	peek()	 適用外	適用外 */
	  
    BlockingQueue<Double> queue = new LinkedBlockingQueue<>(3);
    new Thread(() -> { //キューに要素を追加するスレッド
      while(true) {
        try {
          //  boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException;
          queue.offer(Math.random(), 2, TimeUnit.SECONDS);
          System.out.println("offer() : " + queue.size());
        } catch (InterruptedException e) { e.printStackTrace(); } 
      }  
    }).start();
    
    new Thread(() -> { //キューから要素を取得および削除するスレッド
      while(true) {
        try {
          // E poll(long timeout, TimeUnit unit) throws InterruptedException;
          double pNum = queue.poll(2, TimeUnit.SECONDS);
          System.out.println("poll() : " + pNum);
        } catch (InterruptedException e) { e.printStackTrace(); } 
      }  
    }).start();
  }
}

/*  Answer
		poll() : 0.798262107290811
		offer() : 3
		offer() : 3
		poll() : 0.6247299455767521
		poll() : 0.5655779344888066
		poll() : 0.3282086762569528
		poll() : 0.8537516364194008
		poll() : 0.8859883467279512
		offer() : 2
		offer() : 1
		offer() : 1
		offer() : 2
		.......
*/
/*
Collections クラスのスレッドセーフなオブジェクトを返すメソッド
メソッド名	説明
static <T> Collection<T> synchronizedCollection(Collection<T> c)	
	スレッドセーフなコレクションオブジェクトを返す
static <T> Set<T> synchronizedSet(Set<T> s)	
	スレッドセーフなセットオブジェクトを返す
static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s)	
	スレッドセーフなソート・セットオブジェクトを返す
static <T> NavigableSet<T> synchronizedNavigableSet(NavigableSet<T> s)	
	スレッドセーフなナビゲート可能セットオブジェクトを返す
static <T> List<T> synchronizedList(List<T> list)	
	スレッドセーフなリストオブジェクトを返す
static <K,V> Map<K,V> synchronizedMap(Map<K,V> m)	
	スレッドセーフなマップオブジェクトを返す
static <K,V> SortedMap<K,V> synchronizedSortedMap(SortedMap<K,V> m)	
	スレッドセーフなソート・マップオブジェクトを返す
static <K,V> NavigableMap<K,V> synchronizedNavigableMap(NavigableMap<K,V> m)	
	スレッドセーフなナビゲート可能マップオブジェクトを返す
*/

