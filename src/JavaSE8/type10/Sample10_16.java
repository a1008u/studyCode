package JavaSE8.type10;

import java.util.concurrent.*;
import java.util.Date;

public class Sample10_16 {
  public static void main(String[] args){
	 
	  /*
	  Callableインタフェース
	  Runnableインタフェースのrun()メソッドは、戻り値がvoidであるため、処理結果をスレッド開始元に返すことはできません。
	  これに対し、java.util.concurrent.Callableインタフェースを利用すると処理結果をオブジェクトで返すことが可能です
	  */  
	  
    ScheduledExecutorService service = null;
    try {
    	/*
    	static ScheduledExecutorService newSingleThreadScheduledExecutor()
    	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、
    	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す	
    	*/
      service = Executors.newSingleThreadScheduledExecutor();
      Runnable task1 = () -> System.out.println("tas//k1");
      // V call() throws Exception; タスクを実行し結果を返す。タスクが実行できない場合は例外をスローする
      Callable<Date> task2 = () -> new Date();
      
      // ScheduledFuture<?> schedule( Runnable command, long delay, TimeUnit unit)	
  	  //  指定された遅延時間後に有効になる単発的なアクションを作成してRunnableを実行する
      ScheduledFuture<?> result1 = service.schedule(task1, 3, TimeUnit.SECONDS);
      // <V> ScheduledFuture<V> schedule( Callable<V> callable, long delay, TimeUnit unit)	
  	  //  指定された遅延時間後に有効になる単発的なアクションを作成してCallableを実行する
      ScheduledFuture<Date> result2 = service.schedule(task2, 1, TimeUnit.MILLISECONDS);
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}

/* Answer
 * 	tas//k1
 */

/*
	タスクのスケジュール
	ここまでのサンプルでは、execute() やsubmit() により、タスクが即時に実行されていましたが、スケジューリングすることも可能です。
	たとえば、指定時間後の実行や、定期的な実行などの制御が可能です。
	そのためには、ExecutorService インタフェースを継承したScheduledExecutorService インタフェースを使用します。
*/
/*
ScheduledExecutorService インタフェースの主なメソッド
メソッド名	説明
<V> ScheduledFuture<V> schedule( Callable<V> callable, long delay, TimeUnit unit)	
	指定された遅延時間後に有効になる単発的なアクションを作成してCallableを実行する
ScheduledFuture<?> schedule( Runnable command, long delay, TimeUnit unit)	
	指定された遅延時間後に有効になる単発的なアクションを作成してRunnable を実行する
ScheduledFuture<?> scheduleAtFixedRate (Runnable command, long initialDelay, long period, TimeUnit unit)	
	指定された初期遅延の経過後にはじめて有効になり、その後は指定された期間ごとに有効になる定期的なアクションを作成して実行する
ScheduledFuture<?> scheduleWithFixedDelay (Runnable command, long initialDelay, long delay, TimeUnit unit)	
	指定された初期遅延の経過後にはじめて有効になり、その後は実行の終了後から次の開始までの指定の遅延時間ごとに有効になる定期的なアクションを作成して実行する
	*/
/*
Executors クラスの主なメソッド
static ExecutorService newSingleThreadExecutor()	
	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す
static ExecutorService newFixedThreadPool(int nThreads)
	固定数のスレッドを再利用するスレッドプールを提供するExecutorService オブジェクトを返す
static ExecutorService newCachedThreadPool()
	新規スレッドを作成するスレッドプールを作成するが、
	利用可能な場合には以前に構築されたスレッドを再利用するExecutorServiceオブジェクトを返す
static ScheduledExecutorService newSingleThreadScheduledExecutor()
	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、
	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す
static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)	
	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、
	スレッドプールを作成するScheduledExecutorService オブジェクトを返す
static Callable<Object> callable( Runnable task)	
	呼び出し時に、指定されたタスクを実行し、nullを返すCallable オブジェクトを返す
static <T> Callable<T> callable( Runnable task, T result)
	呼び出し時に、指定されたタスクを実行し、指定された結果を返すCallable オブジェクトを返す
*/