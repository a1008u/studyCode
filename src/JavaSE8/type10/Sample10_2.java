package JavaSE8.type10;

public class Sample10_2 {
  public static void main(String[] args) {
    // スレッドの作成(Runnableインタフェースのrun実装→Threadクラスの実装しstart()メソッドを実行)
    ThreadAA threadAA = new ThreadAA();
    ThreadBB threadBB = new ThreadBB();
    Thread a = new Thread(threadAA);
    Thread b = new Thread(threadBB);
    // スレッドの実行開始
    a.start();
    b.start();
  }
}

// Runnableインタフェースの実装クラス
// Runnableインタフェースの抽象メソッドであるrun()メソッドをオーバーライドして、スレッドの処理を記述します。
// 次にRunnableインタフェースを実装したクラスのオブジェクトをThreadクラスのコンストラクタの引数に渡します。
class ThreadAA implements Runnable {
  public void run() {     // スレッドが実行する処理
    for(int i = 0; i < 10; i++) {
      System.out.print("A:" + i + " ");
    }
  }
}
// Runnableインタフェースの実装クラス
class ThreadBB implements Runnable {
  public void run() {     // スレッドが実行する処理
    for(int i = 0; i < 10; i++) {
      System.out.print("B:" + i + " ");
    }
  }
}
/*
	Answer
		A:0 A:1 B:0 A:2 A:3 B:1 A:4 B:2 A:5 B:3 A:6 B:4 A:7 B:5 A:8 B:6 B:7 B:8 A:9 B:9 
*/