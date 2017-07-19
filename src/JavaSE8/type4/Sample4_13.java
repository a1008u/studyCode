package JavaSE8.type4;

import java.util.function.*;

public class Sample4_13 {
  public static void main(String[] args) {
	  
	// IntFunction<R>	R apply(int value)	
	// 実装するメソッドは、引数としてint を受け取り、結果としてRを返す  
	  
    IntFunction<String[]> obj1 =  String[]::new;
    System.out.println("obj1 : " + obj1.apply(5).length);
    
    IntFunction<String[]> obj2 = length -> new String[length];
    System.out.println("obj2 : " + obj2.apply(5).length);
    
  }
}

// Answer
// obj1 : 5
// obj2 : 5

// 型パラメータリストにラッパークラスを指定して、基本データ型を
// インタフェース名	抽象メソッド	概要
// IntFunction<R>	R apply(int value)	実装するメソッドは、引数としてint を受け取り、結果としてR を返す
// IntConsumer	void accept(int value)	実装するメソッドは、引数としてint を受け取り、結果を返さない
// IntPredicate	boolean test(int value)	実装するメソッドは、引数としてint を受け取り、boolean 値を結果として返す
// IntSupplier	int getAsInt()	実装するメソッドは、何も引数として受け取らず、結果としてint を返す
// IntUnaryOperator	int applyAsInt(int operand)	実装するメソッドは、引数としてint を受け取り、結果としてint を返す
// IntBinaryOperator	int applyAsInt(int left, int right)	実装するメソッドは、引数としてint を2 つ受け取り、結果としてint を返す