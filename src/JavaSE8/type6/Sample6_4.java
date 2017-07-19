package JavaSE8.type6;

import java.io.*;

public class Sample6_4 {
  public static void main(String[] args) {
	  
	  //　マルチキャッチのコンパイルエラー  
	  //  ●　キャッチした参照変数は暗黙的にfinalとなる
	  
    try {
      int a = 10/0;
      FileReader rf = new FileReader("a.txt");
      rf.read();
    } catch( ArithmeticException | FileNotFoundException e) {
      e.printStackTrace(); e = null;
    } catch(IOException e) {
      e.printStackTrace(); e = null;
    }
  }
}
