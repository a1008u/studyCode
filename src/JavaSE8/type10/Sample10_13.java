package JavaSE8.type10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample10_13 {
  public static void main(String[] args){
	  
	// Executorフレームワーク(java.util.cncurrentパッケージ)
	//  スレッドの再利用やスケジューリングを行うスレッドコードを簡単に実装できます。  
	  /* Executorフレームワークの主なインタフェースとクラス
	  インタフェース/クラス名	説明
	  Executorインタフェース	
	  	送信されたRunnableタスク（1つの処理）を実行するオブジェクト
	  ExecutorServiceインタフェース	
	  	インタフェース終了を管理するメソッド、および非同期タスクの進行状況を追跡するFutureを生成するメソッドを提供する
	  Futureインタフェース	
	  	非同期計算の結果を表す。計算が完了したかどうかのチェック、完了までの待機、計算結果の取得などを行うためのメソッドを提供
	  Callableインタフェース	
	  	タスクを行うクラス。結果を返し、例外をスローすることがある
	  Executorsクラス	
	  	Executor、ExecutorService、ScheduledExecutorService、ThreadFactory、Callableオブジェクト用のファクトリおよびユーティリティメソッドを提供
	  */  
	  
	  
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      System.out.println("service.execute()");
      
      String s = "*";
      for(int i = 0; i < 3; i++){
    	// void execute(Runnable command) 指定されたタスクを実行する
        service.execute(() -> {
          System.out.print("thread task");
          for(int a = 0; a < 5; a++) {
            try {
               Thread.sleep(500);
               System.out.print(" * ");
            } catch (InterruptedException e) { e.printStackTrace(); }
          }
         System.out.println();
        });
      }
    } finally {
	    // void shutdown()	
	 	// 順序正しくシャットダウンをする。
	 	// 以前に送信されたタスクは実行されるが、新規タスクは受け入れられない
      service.shutdown(); // ExecutorServiceの終了
       // boolean isShutdown()：このExecutor がシャットダウンしていた場合、trueを返す
      System.out.println("ex.isShutdown() : " + service.isShutdown());
      System.out.println("ex.shutdown()");
    }
  }
}

/*
Answer
	service.execute()
	thread taskex.isShutdown() : true
	ex.shutdown()
	 *  *  *  *  * 
	thread task *  *  *  *  * 
	thread task *  *  *  *  * 
*/

/*
Executors クラスの主なメソッド
static ExecutorService newSingleThreadExecutor()	
	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す
static ExecutorService newFixedThreadPool(int nThreads)
	固定数のスレッドを再利用するスレッドプールを提供するExecutorService オブジェクトを返す
static ExecutorService newCachedThreadPool()
	新規スレッドを作成するスレッドプールを作成するが、
	利用可能な場合には以前に構築されたスレッドを再利用するExecutorService オブジェクトを返す
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
/*
ExecutorService インタフェースの主なメソッド
メソッド名	説明
boolean awaitTermination( long timeout, TimeUnit unit) throws InterruptedException	
	シャットダウン要求後にすべてのタスクが実行を完了していたか、タイムアウトが発生するか、現在のスレッドで割り込みが発生するか、そのいずれかが最初に発生するまでブロックする
boolean isShutdown()	
	このExecutor がシャットダウンしていた場合、true を返す
boolean isTerminated()	
	シャットダウンに続いてすべてのタスクが完了していた場合、true を返す
void shutdown()	
	順序正しくシャットダウンをする。
	以前に送信されたタスクは実行されるが、新規タスクは受け入れられない
List<Runnable> shutdownNow()	
	実行中のアクティブなタスクおよび、待機中のタスクの処理を停止し、実行を待機していたタスクのリストを返す
<T> Future<T> submit(Callable <T> task)	
	値を返す実行用タスクを送信して、保留状態のタスク結果を表すFuture オブジェクトを返す
Future<?> submit(Runnable task)	
	実行用のRunnable タスクを送信して、そのタスクを表すFuture を返す
void execute(Runnable command)	
	指定されたタスクを実行する
*/