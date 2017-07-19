package JavaSE8.type3;

import java.util.HashSet;
import java.util.TreeSet;

public class Sample3_2 {
  public static void main(String[] args) {
    String[] ary = {"CCC","AAA","BBB"};
    HashSet<String> hashSet = new HashSet<String>();
    hashSet.add(ary[0]);  
    hashSet.add(ary[1]);
    hashSet.add(ary[2]);  
    hashSet.add(ary[0]);
    
    System.out.println("HashSet size : " + hashSet.size());
    
    for (String s : hashSet) { 
    	System.out.print(s + " "); 
    }
    
    System.out.println();
    System.out.println("------------------------------------------");
    
    TreeSet<String> treeSet = new TreeSet<String>();
    treeSet.add(ary[0]);  
    treeSet.add(ary[1]);
    treeSet.add(ary[2]);  
    treeSet.add(ary[0]);
    System.out.println("TreeSet size : " + treeSet.size());
    for (String s : treeSet) { 
    	System.out.print(s + " "); 
    }
  }
}

// Answer
// HashSet size : 3
// AAA CCC BBB 
// ------------------------------------------
// TreeSet size : 3
// AAA BBB CCC 

/* 
	* Listインタフェースの実装
	* 1.パフォーマンス ：クラスによって異なる
	* 2.順序付け/ソート ：順序立てて管理
	* 3.項目のユニーク性：重複要素の保持可能
	* 4.同期生　　　　　：クラスによって異なる
	* 
	* ArrayList
	* 1.パフォーマンス ：ランダムアクセスは高速だが、挿入と削除は低速
	* 4.同期生　　　　 ：サポートしていない
	* 
	* ListedList
	* 1.パフォーマンス ：挿入と削除は高速だた、ランダムアクセスは低速
	* 4.同期生　　　　 ：サポートしていない
	* 
	* Vector(ArrayListと同じだが、マルチスレッド環境でない場合は、ArrayListを使用した方がいい)
	* 1.パフォーマンス ：ランダムアクセスは高速だが、挿入と削除は低速
	* 4.同期生　　　　 ：サポートしている。
	* 
	* 
*/