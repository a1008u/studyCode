package JavaSE8.type3;

import java.util.*;

class X {
  public String toString() { return "X"; }
}
class Y extends X {
  public String toString() { return "Y"; }
}

public class Sample3_17 {
  // 引数で受け取るリストの要素はXクラスまたはそのサブクラス
  public static void method1(List<? extends X> list) {
    //list.add(new X());
    //list.add(new Y());
    System.out.print(list.get(0) + " ");
  }
  // 引数で受け取るリストの要素はYクラスまたはそのスーパークラス
  public static void method2(List<? super Y> list) {
    //list.add(new X());
    list.add(new Y());
    System.out.print(list.get(0) + " ");
  }
  
  public static void main(String[] args) {
    List<X> l1 = new ArrayList<>(); 
    l1.add(new X());
    List<Y> l2 = new ArrayList<>(); 
    l2.add(new Y());
    // method1()メソッドの呼び出し
    method1(l1); // Xオブジェクトを格納したArrayListを渡す
    method1(l2); // Yオブジェクトを格納したArrayListを渡す
    // method2()メソッドの呼び出し
    method2(l1); // Xオブジェクトを格納したArrayListを渡す
    method2(l2); // Yオブジェクトを格納したArrayListを渡す
  }
}

// Answer
// X Y X Y 