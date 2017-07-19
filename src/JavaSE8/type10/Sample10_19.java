package JavaSE8.type10;

import java.util.concurrent.*;
public class Sample10_19 {
  void a() { System.out.print("a "); }
  void b() { System.out.print("b "); }
  void c() { System.out.print("c "); }
  void exec(CyclicBarrier c1, CyclicBarrier c2){
    //try {
      a();
      //c1.await();
      b();
      //c2.await();
      c();
    //} catch(BrokenBarrierException | InterruptedException e) { }
  }
  // コメントアウトをはずしたAnswer
  // a a a b b b task c c c  
  // c2では、コンストラクタの第2引数にRunnableオブジェクトを指定しています。
  // これは、最後にバリアポイントを通過したスレッドによって実行されるタスクを指定することができます。
  
  public static void main(String[] args) {
	  
   /* 同期処理を提供するクラスにjava.util.concurrent.CyclicBarrierがあります。
      複数のスレッドで処理を行っている際に、バリアポイント（待機する箇所）を設定しておくと、
      すべてのスレッドがその箇所に到達するまで待機します。  
   */
	  
    ExecutorService service = null;
    try {
      // static ExecutorService newFixedThreadPool(int nThreads)
      // 固定数のスレッドを再利用するスレッドプールを提供するExecutorServiceオブジェクトを返す
      service = Executors.newFixedThreadPool(3);
      // CyclicBarrierコンストラクタの第1引数には、待機状態にするスレッドの数を指定します
      CyclicBarrier c1 = new CyclicBarrier(3);
      // public CyclicBarrier(int parties, Runnable barrierAction) {...}
      CyclicBarrier c2 = new CyclicBarrier(3, 
                                  () -> System.out.print("task "));
      
      for (int i = 0; i < 3; i++) {
        service.execute(() -> new Sample10_19().exec(c1, c2));
      }
      
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
  
}

// Answer
// a b a b c a b c c 