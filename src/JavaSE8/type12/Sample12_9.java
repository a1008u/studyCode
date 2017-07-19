package JavaSE8.type12;

import java.util.Locale;
import java.text.*;

public class Sample12_9 {
  public static void main(String[] args) {
    try {
    	
     // Number parse(String source) throws ParseException	
     //  引数で指定された文字列を解析して数値を生成する
    	
      NumberFormat usNum = NumberFormat.getInstance(Locale.US);
      Number value1 = usNum.parse("500.12");
      System.out.println("value1 : " + value1);
      
      NumberFormat usCur = 
                   NumberFormat.getCurrencyInstance(Locale.US);
      double value2 = (double)usCur.parse("$20,456.99");
      System.out.println("value2 : " + value2);
      
    } catch(ParseException e) { e.printStackTrace(); }
  }
}

/*
	Answer
		value1 : 500.12
		value2 : 20456.99
*/