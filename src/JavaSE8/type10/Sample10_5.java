package JavaSE8.type10;

public class Sample10_5 {
  public static void main(String[] args) {
	 
	  /*
	  排他制御と同期制御とは
	  ・共有して使用しているオブジェクトに対し、あるスレッドが処理を行っている間、
	  　排他制御：他のスレッドに邪魔されないように独占して実行させる。
	  ・同期制御：スレッド同士で実行のタイミングを合わせる場合に考慮する。
	  */  
	  
    Share share = new Share();
    ThreadC threadC = new ThreadC(share);
    ThreadD threadD = new ThreadD(share);
    threadC.start(); threadD.start();
  }
}

class Share { // 共有して使用されるオブジェクト
  private int a = 0;
  private String b;
  public void set() {
    a++; b = "data";
    System.out.println("set() a : " + a + " b: " + b);
  }
  public void print() {
    a--; b = null;
    System.out.println(" print() a : " + a + " b: " + b);
  }
}
class ThreadC extends Thread {
  private Share share;
  public ThreadC(Share share) { this.share = share; }
  public void run() {
    for (int i = 0; i < 5; i++) { share.set(); }
  }
}
class ThreadD extends Thread {
  private Share share;
  public ThreadD(Share share) { this.share = share; }
  public void run() {
    for (int i = 0; i < 5; i++) { share.print(); }
  }
}

/*
	Answer
		print() a : 0 b: null
		print() a : -1 b: null
		print() a : -2 b: null
		set() a : 0 b: null
		print() a : -3 b: null
		set() a : -2 b: data
		print() a : -3 b: null
		set() a : -2 b: data
		set() a : -1 b: data
		set() a : 0 b: data
*/


