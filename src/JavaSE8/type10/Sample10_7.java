package JavaSE8.type10;

public class Sample10_7 {
  public static void main(String[] args) {
	  
	// wait()、notify()、notifyAll() による同期制御  
	// Object	final void wait() throws InterruptedException	
	  //		他のスレッドがこのオブジェクトのnotify()メソッドまたはnotifyAll()メソッドを呼び出すまで、現在のスレッドを待機させる
	// Object	final void wait(long timeout) throws InterruptedException	
	  //		他のスレッドがこのオブジェクトのnotify() メソッドまたはnotifyAll() メソッドを呼び出す か、指定された時間が経過するまで、現在のスレッドを待機させる
	// Object	final void notify()	
	  //		このオブジェクトの待機中のスレッドを1つ再開する。再開するスレッドを指定することはできない
	// Object	final void notifyAll()	
	  //		このオブジェクトの待機中のすべてのスレッドを再開する
	  
    Share3 share3 = new Share3();
    ThreadAAA  threadA = new ThreadAAA (share3);
    ThreadBBB threadB = new ThreadBBB(share3);
    threadA.start(); threadB.start();
  }
}
class Share3 { // 共有して使用されるオブジェクト
  private int a = 0;
  private String b;
  public synchronized void set() {
    while ( a != 0) {
      try {
        wait();
      } catch(InterruptedException e) {}
    }
    notify();
    a++; b = "data";
    System.out.println("set() a : " + a + " b: " + b);
  }
  
  public synchronized void print() {
    while (b == null) {
      try {
        wait();
      } catch(InterruptedException e) {}
    }
    notify();
    a--; b = null;
    System.out.println("  print() a : " + a + " b: " + b);
  } 
}

class ThreadAAA extends Thread {
  private Share3 share;
  public ThreadAAA (Share3 share) { this.share = share; }
  public void run() {
    for (int i = 0; i < 5; i++) { share.set(); }
  }
}

class ThreadBBB extends Thread {
  private Share3 share;
  public ThreadBBB(Share3 share) { this.share = share; }
  public void run() {
    for (int i = 0; i < 5; i++) { share.print(); }
  }
}

/*
	Answer
		set() a : 1 b: data
		print() a : 0 b: null
		set() a : 1 b: data
		print() a : 0 b: null
		set() a : 1 b: data
		print() a : 0 b: null
		set() a : 1 b: data
		print() a : 0 b: null
		set() a : 1 b: data
		print() a : 0 b: null
*/

// Object クラスの制御用メソッド
// クラス名	メソッド名	説明
// Object	final void wait() throws InterruptedException	
//	他のスレッドがこのオブジェクトのnotify() メソッドまたはnotifyAll() メソッドを呼び出すまで、現在のスレッドを待機させる
// Object	final void wait(long timeout) throws InterruptedException	
//	他のスレッドがこのオブジェクトのnotify() メソッドまたはnotifyAll() メソッドを呼び出す か、指定された時間が経過するまで、現在のスレッドを待機させる
// Object	final void notify()	
//	このオブジェクトの待機中のスレッドを1 つ再開する。再開するスレッドを指定することはできない
// Object	final void notifyAll()	
//	このオブジェクトの待機中のすべてのスレッドを再開する

/*
同期制御を行っている場合、すべてのスレッドが待機状態になってしまい、notify()メソッドを呼ぶスレッドがないという状況は避けなければなりません。
デッドロック：すべてのスレッドがロックの解放を同時に待ってしまい、ロックが永久に解けなくなる状況。
ライブロック(実質的に処理が進まない状態)：複数のスレッドが共有資源の獲得と解放を行ってはいるが、獲得が必要な時には他のスレッドにロックされ、進まない処理を繰り返し続ける状況。

注意)プログラムで制御する必要がある。
当然のことながら、デッドロックやライブロックになる可能性のあるコードをコンパイルのタイミングで検出することはできません。
また、実行時にデッドロックやライブロックが発生しても、例外などで通知してくれることはありません。
たとえば、処理の効率は下がりますがロックの順番を予め決定しておいたり、
一定時間が経過したら強制的に待機状態が解除されるようにタイムアウト時間を指定したwait()メソッドを使用したりするなどの方法があります。

スレッドスタベーション
複数のスレッドが同時実行しているとき、共有オブジェクトをなかなか解放しないスレッドがあると、
その共有オブジェクトを使用する他のスレッドが実行を長時間待たされてしまいます。
スタベーション（Starvation）は「飢餓」を意味し、スレッドが共有オブジェクトにアクセスできず、飢餓状態になるという意味です。
この原因は、スレッドのスケジューリングがうまくいっていないことが考えられるため、
優先度を見直したり、ロックの粒度を小さくしたり、ロックする回数を減らすなどして、他のスレッドに実行の機会を与える対応が必要です。
*/