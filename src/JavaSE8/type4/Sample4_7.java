package JavaSE8.type4;

import java.util.*;

public class Sample4_7 {
  public static void main(String[] args) {
	  
	// Comparatorインタフェース
	// 抽象メソッド：int compare(T o1, T o2);  
	  
	/*Integerクラスのcompareメソッド
	  public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }*/
	  
    // ラムダ式
    Comparator<Integer> comp2 = (x, y) -> Integer.compare(x, y);
	  
    // statcメソッド参照
    Comparator<Integer> comp = Integer::compare;
    
    System.out.println(comp.compare(1, 2));
    System.out.println(comp.compare(2, 1));
  }
}

/*
 * Answer
 * -1
 * 1
 */

// Comparatorインタフェースには、
// 抽象メソッドとして、compare()メソッドの他、equals()メソッドが宣言されていますが、
// equals()メソッドはObjectクラスのpublicメソッドであるため、
// 関数型インタフェースの仕様に従ったインタフェースとなります。