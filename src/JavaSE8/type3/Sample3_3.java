package JavaSE8.type3;

import java.util.HashSet;

class Fooo {
  private String str;
  public Fooo(String str) { this.str = str; }
  public String toString() { return str + " "; }
}

public class Sample3_3 {
  public static void main(String[] args) {
	  
    HashSet<Fooo> set = new HashSet<Fooo>();
    Fooo f1 = new Fooo("BBB");  
    set.add(f1);
    Fooo f2 = new Fooo("AAA");  
    set.add(f2);
    Fooo f3 = new Fooo("CCC");  
    set.add(f3);
    Fooo f4 = new Fooo("AAA");  
    set.add(f4); 
    
    System.out.println("size : " + set.size());
    for (Fooo f : set) { 
    	System.out.print(f); 
    }
  }
}
//Answer
// size : 4
// CCC AAA AAA BBB 

/* 
	* Setインタフェースの実装
	* 1.パフォーマンス ：クラスによって異なる
	* 2.順序付け/ソート ：順不同で管理
	* 3.項目のユニーク性：重複要素の保持不可
	* 4.同期生　　　　　：クラスによって異なる
	* 
	* HashSet
	* 1.パフォーマンス ：TreeSetよりもアクセスは速い
	* 4.同期生　　　　 ：サポートしていない
	* 
	* TreeSet(SortedSetインタフェースの実装)
	* 1.パフォーマンス ：HashSetより遅いが、ソートされている
	* 4.同期生　　　　 ：サポートしていない
	* 
	* LinkedHashSet(順序は挿入順)
	* 1.パフォーマンス ：HashSetと同等の機能
	* 4.同期生　　　　 ：サポートしていない
	* 
	* 
*/