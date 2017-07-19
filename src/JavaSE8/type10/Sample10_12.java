package JavaSE8.type10;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Sample10_12{
  public static void main(String[] args) {
	// CopyOnWriteArrayList	
	// もとになる配列の新しいコピーを作成することにより、スレッドセーフを実現するArrayListを拡張
    List<String> list = new CopyOnWriteArrayList<String>();
    list.add("A"); list.add("B"); list.add("C"); list.add("D");
    
    new Thread(() -> { 
      Iterator itr = list.iterator();
      while(itr.hasNext()){
        System.out.println("ThreadA : " + itr.next());
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) { e.printStackTrace(); }
      }
      list.forEach(System.out::println);
    }).start();
    
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) { e.printStackTrace(); }
    list.add("E"); System.out.println("main : add()");
    list.remove(2); System.out.println("main : remove()");
    list.forEach(System.out::println);
  }
}
/*
Answer
	ThreadA : A
	main : add()
	main : remove()
	A
	B
	D
	E
	ThreadA : B
	ThreadA : C
	ThreadA : D
	A
	B
	D
	E
*/


/*
Executors クラスの主なメソッド
メソッド名	説明
static ExecutorService newSingleThreadExecutor()	
	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す
static ExecutorService newFixedThreadPool(int nThreads)	
		固定数のスレッドを再利用するスレッドプールを提供するExecutorService オブジェクトを返す
static ExecutorService newCachedThreadPool()	
	新規スレッドを作成するスレッドプールを作成するが、
	利用可能な場合には以前に構築されたスレッドを再利用するExecutorService オブジェクトを返す ExecutorServiceオブジェクトを返す
static ScheduledExecutorService newSingleThreadScheduledExecutor()	
	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、1 つのスレッドでタスクの処理するExecutorService オブジェクトを返す
static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)	
	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、スレッドプールを作成するScheduledExecutorService オブジェクトを返す
static Callable<Object> callable(Runnable task)	
	呼び出し時に、指定されたタスクを実行し、null を返すCallable オブジェクトを返す
static <T> Callable<T> callable(Runnable task, T result)	
呼び出し時に、指定されたタスクを実行し、指定された結果を返すCallable オブジェクトを返す

*/