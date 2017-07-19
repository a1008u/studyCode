package JavaSE8.type10;

public class Sample10_1 {
  public static void main(String[] args) {
	  
	// スレッドの作成  
	//  Threadクラスを継承してサブクラスを定義する場合は、
	//  Threadクラスのrun()メソッドをオーバーライドしてスレッドとして行いたい処理を記述します。  
    ThreadA a = new ThreadA();
    ThreadB b = new ThreadB();
    // スレッドの実行開始
    a.start();
    b.start();
  }
}

class ThreadA extends Thread {//スレッドクラス
  public void run() {     // スレッドが実行する処理
    for(int i = 0; i < 10; i++) {
      System.out.print("A:" + i + " ");
    }
  }
}

class ThreadB extends Thread {//スレッドクラス
  public void run() {     // スレッドが実行する処理
    for(int i = 0; i < 10; i++) {
      System.out.print("B:" + i + " ");
    }
  }
}

/*
	Answer
		B:0 B:1 A:0 A:1 A:2 A:3 A:4 A:5 A:6 A:7 A:8 A:9 B:2 B:3 B:4 B:5 B:6 B:7 B:8 B:9 
*/
/*
スレッドとは
スレッドとは、プログラムを実行した場合の処理の最小単位のことです。
あるプログラムを作成しjavaコマンドを使用して実行すると、Java実行環境は新しいスレッドを作成し、
そのスレッドによって指定したクラスのmain()メソッドを実行しています。
Java言語は、このような1つのスレッド（シングルスレッド）だけでなく、複数のスレッドを使用したプログラムを作成できます。
プログラムの実行単位を複数のスレッドに分割して実行することをマルチスレッドといいます。
CPUを1つしか搭載していないマシンでは、同時に2つの処理を実行することはできません。
そこで、マルチスレッドでは通常、時分割処理という方法が用いられています。
時分割処理とは、短い時間間隔で実行する処理を切り替える方法です。
複数の処理を頻繁に切り替えて実行することで、仮想的に複数の処理を同時に実行しているように見せています。
*/
