package JavaSE8.type10;

public class Sample10_6 {
  public static void main(String[] args) {
    Share2 share2 = new Share2();
    ThreadE threadE = new ThreadE(share2);
    ThreadF threadF = new ThreadF(share2);
    threadE.start(); threadF.start();
  }
}

/*
synchronizedによる排他制御
	共有して使用されるオブジェクトの中で、複数のスレッドで同時に実行したくない箇所にsynchronizedキーワードを指定すると、排他制御を実現できます。
	synchronizedを使用することにより、同時に1つのスレッドからしか実行されないことが保証されます。　
	synchronizedが指定された箇所をあるスレッドが実行している間、共有のオブジェクトはロックがかかった状態になります。
	ロック（lock）は直訳の「施錠」のとおり、オブジェクトに鍵をかけます。
	したがって、ロックがかかっている状態のときに別のスレッドに制御が移り、
	そのスレッドが共有オブジェクトのsynchronizedが指定された箇所を実行しようとしても、そのスレッドは待たされることになります。
	そして、synchronizedが指定された箇所の処理が終了するとロックは解放されます。
	synchronizedはメソッドのほか、部分的にブロックで指定することも可能です。
*/

class Share2 { // 共有して使用されるオブジェクト
  private int a = 0;
  private String b;
  public synchronized void set() {
    a++; b = "data";
    System.out.println("set() a : " + a + " b: " + b);
  }
  public synchronized void print() {
    a--; b = null;
    System.out.println("  print() a : " + a + " b: " + b);
  } 
}

class ThreadE extends Thread {
  private Share2 share2;
  public ThreadE(Share2 share2) { this.share2 = share2; }
  public void run() {
    for (int i = 0; i < 5; i++) { share2.set(); }
  }
}
class ThreadF extends Thread {
  private Share2 share2;
  public ThreadF(Share2 share2) { this.share2 = share2; }
  public void run() {
    for (int i = 0; i < 5; i++) { share2.print(); }
  }
}
/*
	Answer
		set() a : 1 b: data
		set() a : 2 b: data
		set() a : 3 b: data
		set() a : 4 b: data
		set() a : 5 b: data
		  print() a : 4 b: null
		  print() a : 3 b: null
		  print() a : 2 b: null
		  print() a : 1 b: null
		  print() a : 0 b: null
*/

/*
・メソッドに指定
synchronized void add(int a) {…}

・部分的にブロックで指定
void add(int a) {
    ……
   synchronized(ロック対象のオブジェクト) {…}
    ……
}
*/