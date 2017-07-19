package JavaSE8.type10;

import java.util.concurrent.*;

public class Sample10_14 {
  public static void main(String[] args){
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      
  	  // Future<?> submit(Runnable task)	
  	  //  実行用のRunnableタスクを送信して、そのタスクを表すFutureを返す
      Future<?> result1 = service.submit(() -> System.out.println("hello"));
      System.out.println("result1 : " + result1);
      System.out.println("result1 : " + result1.get());
      
      //  <T> Future<T> submit(Runnable task, T result);
      Future<Boolean> result2 = service.submit(() -> System.out.println("hello"), true);
      System.out.println("result2 : " + result2.get());
      
    } catch(InterruptedException | ExecutionException e ) { 
      e.printStackTrace(); 
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}

/*
Answer
	result1 : java.util.concurrent.FutureTask@e9e54c2
	hello
	result1 : null
	hello
	result2 : true
*/
/*
Futureインタフェースの主なメソッド
メソッド名	説明
boolean cancel(boolean mayInterruptIfRunning)	
	このタスクの実行の取り消しを試みる
boolean isCancelled()	
	このタスクが正常に完了する前に取り消された場合はtrue を返す
boolean isDone()	
	このタスクが完了した場合はtrue を返す
V get() throws InterruptedException, ExecutionException	
	必要に応じてタスクが完了するまで待機し、その後、タスク結果を取得する
V get(long timeout, TimeUnit unit)throws InterruptedException, ExecutionException, TimeoutException	
	必要に応じて、最大で指定された時間および計算が完了するまで待機し、その後タスク結果を取得する
*/

/*
imeUnit 列挙型の列挙値
列挙値	説明
NANOSECONDS	ナノ秒
MICROSECONDS	マイクロ秒
MILLISECONDS	ミリ秒
SECONDS	秒
列挙値	説明
MINUTES	分
HOURS	時
DAYS	日
*/