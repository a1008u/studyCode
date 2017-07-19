package JavaSE8.type12;

import java.util.*;
import java.util.stream.Stream;

public class Sample12_3 {
  public static void main(String[] args) {
	  
	// static final ResourceBundle getBundle(String baseName)	
	//  引数で指定された名前、デフォルトのロケール、および呼び出し側のクラスローダーを使用して、リソースバンドルを取得する
 
    ResourceBundle obj
          = ResourceBundle.getBundle("com.se.MyResources2");
    
    // getObject() メソッドは戻り値の型がObject型であるため、適切な型にキャストが必要
    Long data1 = (Long)obj.getObject("data1");
    Integer data2 = (Integer)obj.getObject("data2");
    int[] data3 = (int[])obj.getObject("data3");
    
    System.out.println("data1 : " + data1);
    System.out.println("data2 : " + data2);
    System.out.print("data3 : ");
    
    Arrays.stream(data3)
    	.forEach(System.out::print);
    
    System.out.println();
    
    for(int i : data3) { 
    	System.out.print(i + " ");
    }
    
  }
}
/*
	Answer
		data1 : 10000
		data2 : 500
		data3 : 10 20 30 
*/