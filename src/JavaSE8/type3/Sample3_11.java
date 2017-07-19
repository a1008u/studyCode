package JavaSE8.type3;

import java.util.ArrayList;

class Sample3_11 {
  public static void main(String[] args) {
	  
	// ジェネリックの設定なし
    ArrayList list = new ArrayList();
    Integer i1 = new Integer(1); 
    int i2 = 2; 
    Integer i3 = i1;
    
    list.add(i1); 
    list.add(i2); 
    list.add(i3); 
    //list.add("abc");
    
    System.out.println("size : " + list.size());
    for ( int i = 0; i < list.size() ; i++) {
      //Integer obj = list.get(i); //NG
      Integer obj = (Integer)list.get(i); //OK
      System.out.print(obj + " ");
    }
    
  }
}

// Answer
// size : 3
// 1 2 1 