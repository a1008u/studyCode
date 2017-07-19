package JavaSE8.type6;

import java.util.Arrays;
import java.util.List;

class MyExceptionA extends Exception {
  String msgA = "MyExceptionA";
}
class MyExceptionB extends Exception {
  String msgB = "MyExceptionB";
}

public class Sample6_7 {
  public static void main(String[] args){
	  
	// rethrow
	// 多くのクラスを使用するアプリケーションでは、スローされた例外をcatchブロックでいったん受け取り、
	// その例外オブジェクトにエラーメッセージを追記したり、異なる例外クラスに変更したりした後、再度スローすること。
	// JavaSE7から、例外をrethrowする際に、throws節でより具体的な例外の種類を指定することができるようになりました。
	  
    try {
      method();
    } catch(MyExceptionA e) {
      System.out.println(e.msgA);
    } catch(MyExceptionB e) {
      System.out.println(e.msgB);
    }
  }
  public static void method() throws MyExceptionA, MyExceptionB{
    int a = 10;
    try {
      if (a == 0) {
        throw new MyExceptionA();
      } else {
        throw new MyExceptionB();
      }
    } catch(Exception e){
       // 例外が起きた際の、method()側で行うべき処理
       // 処理が終わったら、例外をスローする
       List<String> alist = Arrays.asList("test1","test2","test3");
       alist.forEach(System.out::println);
       throw e;
    }
    /*** SE 6での記述
    } catch(MyExceptionA e){
      // 例外が起きた際の、method()側で行うべき処理
      // 処理が終わったら、例外をスローする
      throw e;
    } catch(MyExceptionB e){
      // 例外が起きた際の、method()側で行うべき処理
      // 処理が終わったら、例外をスローする
      throw e;
    }
    */
  }
}

// Answer
//  test1
//  test2
//  test3
//  MyExceptionB

