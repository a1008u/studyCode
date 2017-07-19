package JavaSE8.type6;

import java.io.*;

public class Sample6_5 {
  public static void main(String[] args) {
	  
	// throwsについて
	// try-catch-finallyブロックによる例外処理の他に、throwsキーワードによる例外処理ができます。
	// この方法では、例外が発生する可能性のあるメソッドを定義するとき「throws 発生する例外クラス名」を指定しておきます。
	// throws指定された例外クラスのオブジェクトがメソッド内で発生した場合、その例外オブジェクトは、メソッドの呼び出し元に転送されます。  
	  
    try {
      methodA();
      methodB();
    } catch(ArrayStoreException | IOException e) {
      System.out.println(e);
    }
  }
  static void methodA() throws ArrayStoreException{
		//static void methodA(){   この書き方でもOK
		//	理由：throwsを記述しなくても同様の結果が得られます。
		//	これはArrayStoreExceptionがunchecked例外だからです。
		//	unchecked例外は例外処理が任意であるため、例外処理をしていなくても呼び出し元に転送される仕組みになっています。
      throw new ArrayStoreException();
  }
  static void methodB() throws IOException{
	  //static void methodB(){ // これはコンパイルエラー
	  // 理由：IOExceptionはchecked例外であるため、
	  // 呼び出し元に転送するには、throwsによる明示的な指定が必要です。

    throw new IOException();
  }
}

// Answer
// java.lang.ArrayStoreException


