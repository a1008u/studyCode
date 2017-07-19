package JavaSE8.type10;

import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

class IntegerTest {
  private Integer syncInteger;
  private final AtomicInteger atomicInteger;
  public IntegerTest(){
      syncInteger = 0;
      atomicInteger = new AtomicInteger(0);
  }
  synchronized public void addSyncInteger(){
     syncInteger++;
  }
  public void addAtomicInteger(){
	 // final int getAndIncrement()	アトミックにインクリメントし、更新前の値を返す
     atomicInteger.getAndIncrement();
  }
  public void showData() {
    System.out.println("syncInt   : " + syncInteger);
    System.out.println("atomicInt : " + atomicInteger.get());
  }
}

public class Sample10_20 {
  public static void main(String[] args) throws InterruptedException{
    IntegerTest obj = new IntegerTest();
    exec(()->obj.addSyncInteger());
    exec(()->obj.addAtomicInteger());
    obj.showData(); 
  }
  private static void exec(Runnable task)  throws InterruptedException{
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(100);
      service.submit(() -> {
        for (int i = 0; i < 10000; i++) {
            task.run();
        }
      });
      service.awaitTermination(10, TimeUnit.SECONDS);
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}
/*
	Answer
		syncInt   : 10000
		atomicInt : 10000
*/

/*
 * アトミック（atomic）操作
 * synchronizedメソッド（およびsynchronized ブロック）を紹介しましたが、これらの処理中は1つのスレッドで実行されることが保証されています。
 * つまり、マルチスレッド環境化において、synchronizedメソッドが行っている操作は「分割不可能な操作」ということになります。
 * アトミックを保証しているメソッドとして、前述したConcurrentMapインタフェースのputIfAbsent()メソッドがあります。
 * また、java.util.concurrent.atomicパッケージはアトミック操作を簡単に実装するため、
 * アトミックに操作できる値（boolean 型、int 型、long 型、参照型など）を表すクラスを提供しています。
 * これらのクラスは、ロックを制御するコーディングを行うことなく、整数の取得、格納、加算、減算などを行うことができます。
 * 
 * java.util.concurrent.atomic パッケージの主なクラス
 * クラス名	説明
 * AtomicBoolean	アトミックに操作するboolean 型の値を扱うクラス
 * AtomicInteger	アトミックに操作するint 型の値を扱うクラス
 * AtomicLong	    アトミックに操作するlong 型の値を扱うクラス
 * AtomicReference	アトミックに操作する参照型のデータを扱うクラス
*/

/*
atomicInteger クラスの主なメソッド
メソッド名	説明
final int addAndGet(int delta)	アトミックに指定された値を現在の値に追加する。戻り値は、増分後の値
final boolean compareAndSet(int expect, int update)	現在の値が第1 引数と等しい場合、アトミックに第 2 引数で指定された値に更新する
final int incrementAndGet()	アトミックにインクリメントし、更新値を返す
final int get()	現在の値を取得する
final int getAndIncrement()	アトミックにインクリメントし、更新前の値を返す
*/