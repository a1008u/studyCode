package JavaSE8.type4;

import java.util.function.*;

public class Sample4_10 {
  public static void main(String[] args) {
    //ラムダ式㈰OK
    BiFunction<String, Integer, Character> obj1 = (s, i) -> s.charAt(i); 
    System.out.println("obj1 : " + obj1.apply("Java", 2));
	  
    // ラムダ式㈪OK
    BiFunction<Integer, String, Character> obj2 = (i, s) -> s.charAt(i); 
    System.out.println("obj2 : " + obj2.apply(2, "Java"));
	  
    // インスタンスメソッド参照㈰OK
    BiFunction<String, Integer, Character> obj3 = String::charAt;   
    System.out.println("obj3 : " + obj3.apply("Java", 2));
    
    // インスタンスメソッド参照㈪NG (charAtの引数にStringが利用されるため、コンパイルエラー)
    // BiFunction<Integer, String, Character> obj = String::charAt;     
    // System.out.println(obj.apply(2, "Java"));
    
    // StringクラスのcharAtメソッドの使い方
    String a = "Java";
    a.charAt(2);
  }
}

// Answer
// obj1 : v
// obj2 : v
// obj3 : v

// メソッド参照を行う際、クラス内に同じ名前のstaticメソッドとインスタンスメソッドが存在する場合、
// 呼び出し時に特定できないとコンパイルエラーとなります。
// たとえば、以下のコードはコンパイルエラーとなります。
// Function<Double, Integer> func = Double::hashCode;