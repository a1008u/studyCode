package JavaSE8.type5;

import java.util.*;

public class Sample5_8 {
  public static void main(String[] args) {
	  
	// Optionalクラス
	// 実体は1つの値を保持しているクラス
	// 特徴として、Optionalクラスの各メソッドは、保持している値がnullかnot nullによって処理が異なります。
	// Optionalオブジェクトは、保持している値がnullの場合はemptyというオブジェクトになりますが、
	// Optionalオブジェクト自体がnullではない点に注意してください。  
	  
    Optional<Integer> op1 = Optional.of(10);
    Optional<Integer> op2 = Optional.empty();
    
    // T get()	
    // 	値が存在する場合は値を返し、それ以外の場合はNoSuchElementException をスローする
    System.out.println("op1.get() : " + op1.get());
    
    // 実行時エラー
    // System.out.println("op2.get() : " + op2.get());
    
    // boolean isPresent()	
    // 	存在する値がある場合はtrueを返し、それ以外の場合はfalseを返す
    System.out.println("op1.isPresent() : " + op1.isPresent());
    System.out.println("op2.isPresent() : " + op2.isPresent());
  }
}

// Answer
// op1.get() : 10
// op1.isPresent() : true
// op2.isPresent() : false

// Optionalクラスの主なメソッド
// メソッド名 	説明
// static <T> Optional<T> empty()	
//	空のOptional インスタンスを返す。このOptional の値は存在しない
// static <T> Optional<T> of(T value)	
//	引数で指定された非null 値を含むOptionalを返す
// T get()	
//	値が存在する場合は値を返し、それ以外の場合はNoSuchElementException をスローする
// boolean isPresent()	
//	存在する値がある場合はtrue を返し、それ以外の場合はfalse を返す
// void ifPresent(Consumer<? super T> consumer)	
//	値が存在する場合は指定されたコンシューマをその値で呼び出し、それ以外の場合は何も行わない
// T orElse(T other)	
//	存在する場合は値を返し、それ以外の場合はotherを返す
// T orElseGet(Supplier<? extends T> other)	
//	値が存在する場合はその値を返し、そうでない場合はサプライヤを呼び出し、その呼び出しの結果を返す
// <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X extends Throwable	
//	値が存在する場合は、その含まれている値を返し、それ以外の場合は、指定されたサプライヤによって作成された例外をスローする