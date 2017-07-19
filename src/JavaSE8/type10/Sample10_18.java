package JavaSE8.type10;

import java.util.concurrent.*;

public class Sample10_18 {
  public static void main(String[] args){
    ExecutorService service = null;
    try {
    	
      // static ExecutorService newCachedThreadPool()
      // 新規スレッドを作成するスレッドプールを作成するが、
      // 利用可能な場合には以前に構築されたスレッドを再利用するExecutorServiceオブジェクトを返す	
      // 構文1：static ExecutorService newCachedThreadPool()
      // 構文1は、新規スレッドを作成するスレッドプールを作成しますが、以前に作成されたスレッドが利用可能であれば再利用します。	
      service = Executors.newCachedThreadPool();
      
      // コメントアウトをとると、2つのスレッドで処理を実行する
      //service = Executors.newFixedThreadPool(2);
      Runnable task = () -> {
        String name = Thread.currentThread().getName();
        System.out.println(name + " : start");
        
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        System.out.println(name + " : end");
      };
      
      for (int i = 0; i < 5; i++) {
        service.execute(task);
      }
      
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}

/*
Answer (5つのスレッドが形成されている)
	pool-1-thread-2 : start
	pool-1-thread-5 : start
	pool-1-thread-4 : start
	pool-1-thread-3 : start
	pool-1-thread-1 : start
	pool-1-thread-1 : end
	pool-1-thread-5 : end
	pool-1-thread-3 : end
	pool-1-thread-4 : end
	pool-1-thread-2 : end
*/

/*

スレッドプール
ここまでのサンプルでは、newSingleThreadExecutor()メソッドやnewSingleThreadScheduledExecutor() メソッドを使用してスレッド処理であるタスクを実行してきました。
しかし、メソッド名からもわかるとおり、これらのメソッドで取得したExecutorServiceでは、単一スレッドでタスクを実行します。複数のスレッドを用意しておき（プールしておく）、

構文1：static ExecutorService newCachedThreadPool()
構文1 は、新規スレッドを作成するスレッドプールを作成しますが、以前に作成されたスレッドが利用可能であれば再利用します。
構文2：static ExecutorService newFixedThreadPool(int nThreads)
構文2 は、固定数のスレッドを再利用するスレッドプールを作成します。引数で指定した数のスレッドがすべてアクティブ（タスクを実行中）であると、それらのタスクはスレッドが使用可能になるまで待機します。
構文3： static ScheduledExecutorService newScheduledThreadPool(intcorePoolSize)
構文3 は、構文2 と同様に引数で指定したプールサイズのスレッドプールを作成します。ただし、定期的なコマンド実行のスケジュールが可能です。
タスクを順次実施させるスレッドプールを利用したExecutorService を利用することも可能です。表10-13 に掲載しておりますが、Executors クラスの以下のメソッドを使用します。
*/