package JavaSE8.type4;

import java.util.function.*;

public class Sample4_14 {
  public static void main(String[] args) {
	  
	// ToIntFunction<T>	int applyAsInt(T value)	
	// 実装するメソッドは、引数としてT を受け取り、結果としてintを返す 
	  
    ToIntFunction<String> obj1_v2 = s -> s.length();
    ToIntFunction<String> obj1 = (String s) -> {return s.length();};
    System.out.println(obj1.applyAsInt("Java"));
    
    // IntToDoubleFunction	double applyAsDouble(int value)	
    // 実装するメソッドは、引数としてint を受け取り、結果としてdoubleを返す
    
    IntToDoubleFunction obj2_v2 = i -> i + Math.random();
    IntToDoubleFunction obj2 = (int i) -> {return Math.random();};
    
    // Integerだとコンパイルエラー → intに変更
    // IntToDoubleFunction obj2 = (Integer i) -> {return Math.random();}; 
    System.out.println(obj2.applyAsDouble(5));
    
  }
}

// Answer
// 4
// 0.8341827484345153

//  int、double、long 固有の関数型インタフェース
// インタフェース名	抽象メソッド	概要
// ToIntFunction<T>	int applyAsInt(T value)	実装するメソッドは、引数としてT を受け取り、結果としてint を返す
// ToIntBiFunction<T,U>	int applyAsInt(T t, U u)	実装するメソッドは、引数としてT とU を受け取り、結果としてint を返す
// IntToDoubleFunction	double applyAsDouble(int value)	実装するメソッドは、引数としてint を受け取り、結果としてdouble を返す
// IntToLongFunction	long applyAsLong(int value)	実装するメソッドは、引数としてint を受け取り、結果としてlong を返す
// ObjIntConsumer<T>	void acceptd(T t, int value)	実装するメソッドは、引数としてT とint を受け取り、結果を返さない