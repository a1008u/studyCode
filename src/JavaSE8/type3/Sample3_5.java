package JavaSE8.type3;

import java.util.*;
public class Sample3_5 {
  public static void main(String[] args) {
	  
    TreeSet<String> set = new TreeSet<String>();
    
    set.add("C"); 
    set.add("A"); 
    set.add("B");
    Iterator<String> iter = set.iterator();
    
    while(iter.hasNext()) { 
    	System.out.print(iter.next() + " "); 
    }
  }
}

// Answer
// A B C 

// イテレータ
// コレクション何の要素に順番にアクセスする手段。
// アクセスする要素を指し示すカーソルのようなもの。
//
// Iteratorインタフェース
// Iterator<E> iterator() このコレクションの要素に対する反復しを返す。
//
// boolean hasNext() 次の要素がある場合にtrueを返す
// E next() 次の要素を返す
// void remove() next()の呼び出しごとに1回だけ呼び出すことができ、イテレータによって最後に返された要素を削除する