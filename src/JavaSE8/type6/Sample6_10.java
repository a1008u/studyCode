package JavaSE8.type6;

import java.sql.*;

class MyResource2 implements AutoCloseable{
  private String msg ;
  public MyResource2(String msg) { this.msg = msg; }
  public void method() throws SQLException{
    throw new SQLException("method() でのエラー");
  }
  public void close() throws SQLException {
    System.out.println("close() : "+ msg);
    throw new SQLException("close() でのエラー : " + msg);
  }
}

public class Sample6_10 {
  public static void main(String[] args){
	  
    try (MyResource2 obj1 = new MyResource2("obj1");
         MyResource2 obj2 = new MyResource2("obj2")) {
      obj1.method();
    } catch (SQLException e) {
      System.out.println("e.getMessage() : " + e.getMessage());
      System.out.println("e.getSuppressed()で取り出した情報");
      
      // final Throwable[] getSuppressed()	
      //  	try-with-resources文によって抑制された例外をすべて含む配列を返す
      Throwable[] errAry = e.getSuppressed();
      System.out.println("  抑制例外数 : " + errAry.length);
      for(Throwable ex : errAry){
        System.out.println("  " + ex.getMessage());
      }
    } finally {
      System.out.println("finally ブロック");
    }
    
  }
}

// Answer
// close() : obj2
// close() : obj1
// e.getMessage() : method() でのエラー
// e.getSuppressed()で取り出した情報
//   抑制例外数 : 2
//   close() でのエラー : obj2
//   close() でのエラー : obj1
// finally ブロック

// close()メソッドでスローされた例外を受け取るには、
// Throwableクラスで提供されているgetSuppressed()メソッドを使用します。
// これにより、抑制された例外を含むすべての例外を配列で受け取ることができます。

// Throwable クラスに追加されたメソッド
// メソッド名 	説明
// final void addSuppressed(Throwable exception)	
//	この例外を提供する目的で抑制された例外に、指定された例外を追加する
// final Throwable[] getSuppressed()	
//	try-with-resources 文によって抑制された例外をすべて含む配列を返す