package JavaSE8.type3;

import java.util.*;

class Fooa {
  private String str;
  public Fooa(String str) { this.str = str; }
  public String toString() { return str + " "; }
  public int hashCode() { return str.hashCode(); }
  public boolean equals(Object obj) {
    return this.hashCode() == obj.hashCode();
  }
}

public class Sample3_4 {
  public static void main(String[] args) {
    HashSet<Fooa> set = new HashSet<Fooa>();
    Fooa f1 = new Fooa("BBB");  set.add(f1);
    Fooa f2 = new Fooa("AAA");  set.add(f2);
    Fooa f3 = new Fooa("CCC");  set.add(f3);
    Fooa f4 = new Fooa("AAA");  set.add(f4); 
    System.out.println("size : " + set.size());
    for (Fooa f : set) { System.out.print(f); }
  }
}

// Answer
// size : 3
// AAA CCC BBB  

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