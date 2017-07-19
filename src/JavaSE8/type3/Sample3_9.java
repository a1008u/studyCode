package JavaSE8.type3;

import java.util.*;

public class Sample3_9 {
	  public static void main(String[] args) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(0, "AAA");  
	    map.put(1, "BBB");
	    map.put(2, "AAA");  // 値の重複
	    map.put(1, "CCC");  // キーの重複
	    
	    System.out.println(map.containsKey(2));
	    System.out.println(map.containsValue("XXX"));
	    for (int i = 0; i < map.size(); i++ ) {
	      System.out.print(map.get(i) + " ");
	    }
	  }
	}

// Answer
// true
// false
// AAA CCC AAA 

/* 
* Mapインタフェースの実装
* 1.パフォーマンス ：クラスによって異なる
* 2.順序付け/ソート ：クラスによって異なる
* 3.項目のユニーク性：キー(一意)と値(重複可能)のペアを格納
* 4.同期生　　　　　：クラスによって異なる
* 
* HashMap(nullをキーあるいは値として使用できる)
* 1.パフォーマンス ：ハッシュテーブルのデータ構造体のため、ハッシュテーブルと同等
* 2.順序付け/ソート：順不同
* 4.同期生　　　　 ：サポートしていない
* 
* Listed
* 1.パフォーマンス ：全てのエントリに対する2重リンクリストを保持
* 2.順序付け/ソート：挿入された順序が維持される。
* 4.同期生　　　　 ：x
* 
* SortedMap(SortedMapを実装)
* 1.パフォーマンス ：??
* 2.順序付け/ソート：キーの昇順による順序付けが維持される
* 4.同期生　　　　 ：サポートしていない
* 
*/

