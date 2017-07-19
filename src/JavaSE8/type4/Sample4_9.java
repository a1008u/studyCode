package JavaSE8.type4;

import java.util.function.*;

public class Sample4_9 {
  public static void main(String[] args) {
	  
	// ラムダ式(UnaryOperatorはFunctionを継承している)
    // UnaryOperator<String> obj = s -> s.toUpperCase(); 
    // UnaryOperator<String> obj = s::toUpperCase;     //コンパイルエラー(sに宣言がないため、シンボル解釈エラー)
	
	// どのオブジェクトに対してインスタンスメソッドを呼び出すのかを、
	// 変数名で指定することができない場合は、クラス名で指定します。
    UnaryOperator<String> obj = String::toUpperCase; 
    System.out.println(obj.apply("naoki"));
  }
}

// Answer
// NAOKI
