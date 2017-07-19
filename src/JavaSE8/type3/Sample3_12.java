package JavaSE8.type3;

import java.util.*;

class Sample3_12 {
  public static void main(String[] args) {
	  
    Map<Integer, String> map = new HashMap<>();
    map.put(10, "A");
    
    List<String> list1 = new ArrayList<>();
    list1.add("B");
    
    methodA(new ArrayList<>());          //SE8よりOK
    methodA(new ArrayList<String>());      //OK
    
    List<String> list2 = methodB();
  }
  
  	static void methodA(List<String> list) {
  		System.out.println("methodA()");
	}
  
  	//static ArrayList<> methodB() {         //NG
    static ArrayList<String> methodB() {   //OK
      System.out.println("methodB()");
      return new ArrayList<>();
    }
  }

// Answer
// methodA()
// methodA()
// methodB()


// ジェネリック対応のコレクション
// コレクションを生成する際に格納する要素のデータ型を指定するので、コンパイルでのチェックができる。
// 型を決めるため、キャストが不要になる。
// 型パラメタリスト：<E>などの表記
