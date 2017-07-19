package JavaSE8.type6;

public class Sample6_2 {
  public static void main(String[] args) {
	  
	// マルチキャッチを使用し、NumberFormatException例外とArithmeticException例外をキャッチしています 
	// マルチキャッチは各例外クラスを縦棒( | )で区切る
	// 注意点
	//  ●　継承関係のある例外クラスは列記できない
	//  ●　キャッチした参照変数は暗黙的にfinalとなる
	
    String s = "A";  
    int[] num = {10, 0}; 
    
    try {
      System.out.print(Integer.parseInt(s)); 
      //System.out.print(num[0] / num[1]);
      } catch(NumberFormatException | ArithmeticException e) {
      e.printStackTrace();
    }
    
  }
}

//　Answer
//　java.lang.NumberFormatException: For input string: "A"
//	　at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//	　at java.lang.Integer.parseInt(Integer.java:580)
//	　at java.lang.Integer.parseInt(Integer.java:615)
//	　at type6.Sample6_2.main(Sample6_2.java:9)
