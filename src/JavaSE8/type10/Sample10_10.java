package JavaSE8.type10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Sample10_10 {
  public static void main(String[] args) {
    Map<Integer, String> map = new ConcurrentHashMap<>();
    map.put(1, "tanaka");
    map.put(2, "urai");
	// boolean remove(Object key, Object value)	
	// キー（およびそれに対応する値）をこのマップから削除する。そのキーがマップにない場合は、何もしない
    for(Integer key : map.keySet()) { map.remove(key); }
  }
}

/*
	Mapインタフェースの拡張
	同期化をサポートしたマップの主なインタフェースとクラス
	インタフェース／クラス名	説明
	ConcurrentMapインタフェース	
		アトミックなputIfAbsent()、remove() およびreplace() メソッドを提供するマップ
	ConcurrentHashMapクラス	
		ConcurrentMapインタフェースを実装した同期をサポートしたマップクラス

	ConcurrentMap インタフェースのメソッド
	メソッド名	説明
	V putIfAbsent(K key, V value)	
		指定されたキーがまだ値と関連づけられていない場合は、指定された値に関連づける
	boolean remove(Object key, Object value)	
		キー（およびそれに対応する値）をこのマップから削除する。そのキーがマップにない場合は、何もしない
	V replace(K key, V value)	
		キーが値に現在マッピングされている場合にのみ、そのキーのエントリを置換する
	boolean replace(K key, V oldValue, V newValue)	
		キーに指定された値で現在マッピングされている場合にのみ、そのキーのエントリを置換する
*/