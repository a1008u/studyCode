package JavaSE8.type4;

import java.util.function.Function;

public class Sample4_5 {
  public static void main(String[] args) {
	  
	// ●　ラムダ式
    Function<String, Integer> f1 = str -> Integer.parseInt(str);
    int num1 = f1.apply("100");
    System.out.println(num1);

    // ●　staticメソッド参照 (引数がStringを受け取り、Integer型の値を返す)
    Function<String, Integer> f2 = Integer::parseInt;
    int num2 = f2.apply("200");
    System.out.println(num2);
    
  }
}

/* Answer
 * 100
 * 200
 */

// メソッド参照
// ラムダ式内で呼び出されるメソッドが1つの場合SE8ではラムダ式を使用せずに記述する方法。
// 構文 ： クラス名/インスタンス変数名::メソッド名
// クラス名/インスタンス変数名の後に「::」を指定し、呼び出すメソッド名を指定します。
// メソッド参照では引数が省略可能で、()も記述しません。

// メソッド参照は、呼び出すメソッドの種類によって次の3種類があります。
// ●　staticメソッド参照 
// ●　インスタンスメソッド参照
// ●　コンストラクタ参照