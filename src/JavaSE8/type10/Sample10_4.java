package JavaSE8.type10;

public class Sample10_4{
  public static void main(String[] args) {
	 /* 
     Thread	static void sleep(long millis) throws InterruptedException	
		このメソッドを呼び出したスレッドが、millisミリ秒休止する  
     Thread	void interrupt()	
		休止中のスレッドに割り込みを入れる。割り込みを入れられたスレッドは、
		java.lang.InterruptedException例外をJava 実行環境から受け取り、処理を再開する
    */
	  
    Thread threadA = new Thread(() -> {
      System.out.println("threadA : sleep 開始");
      try {
        Thread.sleep(5000);  //ThreadAスレッドのsleep
      } catch (InterruptedException e) {
        System.out.println("threadA : 割り込みをキャッチしました");
      }
      System.out.println("threadA : 処理再開");
    });
    
    threadA.start();

    try {
      System.out.println("main : sleep 開始");
      Thread.sleep(2000);  // mainスレッドのsleep
      System.out.println("main : sleep 終了");
   // スレッドへ割り込み。休止中のスレッドに割り込みを入れる。
      threadA.interrupt();  
    } catch (InterruptedException e) {
      System.out.println("main : 割り込みをキャッチしました");
    }
  }
}

//　Answer
//　　main : sleep 開始
//　　threadA : sleep 開始
//　　main : sleep 終了
//　　threadA : 割り込みをキャッチしました
//　　threadA : 処理再開

// スレッドの状態
// 実行可能：スレッドが生成され、実行の機会が与えられるのを待っている状態
// 実行中：スレッドが実行され、処理を行っている状態
// 実行不可能：ディスクの入出力操作や、スレッドの排他制御や同期処理などにより、スレッドの動作が一時的に休止している状態
// 終了；run()メソッドの処理が終わり、スレッドが終了した状態

/*
Thread クラスの優先度に関するメソッドと定数
優先度を取得・設定するメソッド
クラス名	メソッド名	説明
Thread	static Thread currentThread()	現在実行中のスレッドオブジェクトを取得する
Thread	final String getName()	スレッドの名前を返す
Thread	final int getPriority()	スレッドの優先度を返す
Thread	final void setPriority(int newPriority)	スレッドの優先度を変更する。
引数で指定できるのは、1 ～ 10 まで、デフォルトで5 に設定されている

優先度を表す定数
クラス名	定数名	説明
Thread	public static final int MAX_PRIORITY	最大の優先度。10 を表す
Thread	public static final int NORM_PRIORITY	デフォルトの優先度。5 を表す
Thread	public static final int MIN_PRIORITY	最小の優先度。1 を表す

Thread クラスの制御用メソッド
クラス名	メソッド名	説明
Thread	static void sleep(long millis) throws InterruptedException	
	このメソッドを呼び出したスレッドが、millis ミリ秒休止する
Thread	final void join() throws InterruptedException	
	実行中のスレッドが終了するまで待機する
Thread	static void yield()	
	現在実行しているスレッドを一時的に休止し、他のスレッドに実行の機会を与える
Thread	void interrupt()	
	休止中のスレッドに割り込みを入れる。割り込みを入れられたスレッドは、
	java.lang.InterruptedException例外をJava 実行環境から受け取り、処理を再開する
*/