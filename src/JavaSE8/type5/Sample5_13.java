package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_13 {
  public static void main(String[] args) {
	
	// public static Stream<T> limit(long maxSize)	
	//	maxSize以内の長さに切り詰めた結果から構成されるストリームを返す

    /*
    static IntStream iterate(int seed, IntUnaryOperator f)
      初期要素seedに関数fを繰り返し適用することで生成される、順序付けされた無限順次IntStreamを返します
      (seed、f(seed)、f(f(seed))、といった要素から成るStreamが生成される)。
      IntStreamの最初の要素(位置0)は、指定されたseedになります。
      n > 0の場合、位置nの要素は、位置n - 1の要素に関数fを適用した結果になります。
    パラメータ : seed - 初期要素
    f - 新しい要素を生成するために1つ前の要素に適用される関数
    戻り値: 新しい順次IntStream
    */

    IntStream.iterate(1, n -> n + 1)
             .limit(10L)
             .forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    // public static Stream<T> skip(long n)	
    //	先頭からn個の要素を破棄した残りの要素で構成されるストリームを返す
    IntStream.rangeClosed(1, 10)
             .skip(5L)
             .forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    IntStream.iterate(1, n -> n + 1)
             .skip(100L)
             .limit(5L)
             .forEach(x -> System.out.print(x + " "));
    
    System.out.println();
    
    // generate()メソッド
    //  引数(Supplierインタフェース)で指定したラムダ式から要素を構成
    Stream<String> stream = Stream.generate(() -> "Java");
    stream.limit(3L)
          .forEach(x -> System.out.print(x + " "));
  }
}

// Answer
// 1 2 3 4 5 6 7 8 9 10 
// 6 7 8 9 10 
// 101 102 103 104 105 
// Java Java Java 



