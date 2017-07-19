package JavaSE8.type4;

import java.util.*;
import java.util.function.*;

public class Sample4_11 {
  public static void main(String[] args) {

	// コンストラクタ参照：メソッド参照でコンストラクタを呼び出す。
	// クラスメイ::new
	  
	// Supplier<T>	T get()	
	// 実装するメソッドは、何も引数として受け取らず、結果としてTを返す
	  
    Supplier<Foo> obj1_v2 = () -> new Foo();
    Supplier<Foo> obj1 = Foo::new; // コンストラクタ参照
    System.out.println(obj1.get().a);
    
    Function<Integer, Foo> obj2_v2 = i -> new Foo(i);
    Function<Integer, Foo> obj2 =  Foo::new; // コンストラクタ参照
    System.out.println(obj2.apply(10).a);
    
    Supplier<List<Foo>> obj4_v2 = () -> new ArrayList<Foo>();
    Supplier<List<Foo>> obj4 = ArrayList<Foo>::new; // コンストラクタ参照
    System.out.println(obj4.get().size());
  }
}

class Foo{ 
  int a = 0;
  Foo(){ }
  Foo(int a){ this.a = a; }
}

// Answer
// 0
// 10
// 0