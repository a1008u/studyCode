package JavaSE8.type3;

import java.util.*;

public class Sample3_8 {
  public static void main(String[] args) {
    Deque<String> deq = new ArrayDeque<String>();
    deq.push("1"); 
    deq.push("2"); 
    deq.push("3");
    
    System.out.println(deq);
    System.out.println("pop() : " + deq.pop());
    System.out.println(deq);
  }
}

// Answer
// [3, 2, 1]
// pop() : 3
// [2, 1]

// メソッド名 説明(特需な値はオペレーションに応じてnullやfalseを返す)
// 挿入(指定された要素を先頭に挿入する)
// 	例外のスロー：void addFirst(Ee) 
// 	特殊な値：boolean offerFirst(Ee) 
// 削除(キューの先頭を取得および削除する)
// 	例外のスロー：E removeFirst()
// 	特殊な値：E pollFirst()
// 検査(キューの先頭を取得するが削除しない)
// 	例外のスロー：E getFirst()
// 	特殊な値：E peekFirst()