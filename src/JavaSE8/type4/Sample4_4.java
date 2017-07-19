package JavaSE8.type4;

import java.util.function.Function;

public class Sample4_4 {
	
  // 匿名クラスでは外側のクラスのメンバにアクセス可能ですが、
  // ローカル変数の場合、アクセス可能なものはfinal（定数）のみとなります。
	
  int a = 10;
  
  public void method() {
    final int b = 20;
    int c = 30;   //暗黙的final
    int d = 40;
    d = 50;
    int e = 60;   //暗黙的final
    
    Function<String, String> f1 = (String str) -> {
      System.out.println("a : " + a);
      System.out.println("b : " + b);
      System.out.println("c : " + c);
      //System.out.println("d : " + d);  //コンパイルエラー
      //e = 100;   //コンパイルエラー
      return "Hello " + str;
    };
    
    System.out.println(f1.apply("naoki"));
  }
  
  public static void main(String[] args) {
    new Sample4_4().method();
  }
  
}

/*
 * Answer
 * a : 10
 * b : 20
 * c : 30
 * Hello naoki
　*/


