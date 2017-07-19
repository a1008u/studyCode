package JavaSE8.type10;

import java.util.concurrent.*;
import java.util.Date;

public class Sample10_17 {
  public static void main(String[] args){
    ScheduledExecutorService service = null;
    try {
     	/*
    	static ScheduledExecutorService newSingleThreadScheduledExecutor()
    	指定された遅延時間後、または周期的にコマンドの実行をスケジュールできる、
    	1つのスレッドでタスクの処理するExecutorService オブジェクトを返す
    	*/
      service = Executors.newSingleThreadScheduledExecutor();
      Runnable task = () -> System.out.println(new Date());
      
      // ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)	
  	  //  指定された初期遅延の経過後にはじめて有効になり、その後は実行の終了後から次の開始までの指定の遅延時間ごとに有効になる定期的なアクションを作成して実行する
      service.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
      
      // 10秒間スレッドをスリープ状態にする間に、上記のメソッド実行される
      Thread.sleep(10000);
    } catch(InterruptedException e) { 
      e.printStackTrace(); 
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}

/*
Answer
	Mon Feb 20 20:32:16 JST 2017
	Mon Feb 20 20:32:18 JST 2017
	Mon Feb 20 20:32:20 JST 2017
	Mon Feb 20 20:32:22 JST 2017
*/