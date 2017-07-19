package JavaSE8.type3;

// インタフェースを実装するクラス側で型パラメタに対して使用する肩を指定します。
interface MyIn<T> { 
	void method(T t); 
}

//実装クラス1
class Foo implements MyIn<String> { 
  public void method(String s) { 
	  System.out.println(s); 
  }  
}

//実装クラス2
class Bar implements MyIn<Integer> { 
  public void method(Integer i) { 
	  System.out.println(i); 
  } 
}

class Sample3_15 {
  public static void main(String[] args) {
    new Foo().method("ABC"); 
    new Bar().method(10);
  }
}

// Answer
// ABC
// 10
