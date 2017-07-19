package JavaSE8.type3;

import java.util.*;

public class Sample3_7 {
  public static void main(String[] args) {
	  
    Queue<String> queue = new ArrayDeque<String>();
    queue.offer("1"); 
    queue.offer("2");
    
    for(; 0 < queue.size();) { 
    	queue.poll(); // 先頭を削除する
    }
    
    System.out.println(queue.peek());     //null が返る
    
    //System.out.println(queue.element());  // 例外がスロー
  }
}

// Answer
// null


//メソッド名 説明(特需な値はオペレーションに応じてnullやfalseを返す)
// 挿入（指定された要素を挿入する）
//	例外のスロー：boolean add(Ee)
//	特殊な値：boolean offer(Ee)
// 削除(キューの先頭を取得および削除する)
//	例外のスロー：E remove()
//	特殊な値：E poll()
// 検査(キューの先頭を取得するが削除しない)
//	例外のスロー：E element()
//	特殊な値：E peek()