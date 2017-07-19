package JavaSE8.type10;

public class Sample10_3 {
  public static void main(String[] args) {
	  
	  // Runnableインタフェース(@FunctionalInterface)
	 // 抽象メソッド：public abstract void run();
	  
    new Thread(new Runnable() {
      public void run() {
        System.out.println("hello1");
      }
    }).start();
    
    // ラムダ
    new Thread(() -> {
        System.out.println("hello2");
    }).start();
  }
}

/*
	Answer
		hello1
		hello2
*/