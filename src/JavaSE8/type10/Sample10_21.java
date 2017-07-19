package JavaSE8.type10;

import java.util.stream.*;
import java.util.*;

public class Sample10_21 {
  public static void main(String[] args) {
	  
	// パラレルストリームの生成
	// ・CollectionインタフェースのparallelStream()メソッドは、リストなどのコレクションをもとにパラレルストリームを生成します。
	// ・BaseStreamインタフェースのparallel()メソッドは、ストリームをもとにパラレルストリームを生成します。
	  
    List<String> data = Arrays.asList("aaa", "bb", "c");
    Stream<String> pStream1 = data.parallelStream();
    Stream<String> sStream2 = data.stream();
    
    System.out.println("sStream2 : " + sStream2.isParallel());
    
    Stream<String> pStream2 = sStream2.parallel();
    System.out.println("pStream2 : " + pStream2.isParallel());
    
    IntStream pStream3 = IntStream.range(0, 10).parallel();
  }
}


// Amswer
//  sStream2 : false
//  pStream2 : true

/*
パラレルストリーム
並列処理を行うストリームが導入
*/
/*
パラレルストリームの生成
メソッド名	説明
default Stream<E> parallelStream()	
	Collection インタフェースで提供コレクションをソースとして、パラレルストリームを返す
S parallel()	BaseStream 
	インタフェースで提供ストリームをソースとしてパラレルストリームを返す
boolean isParallel()	
 	BaseStreamインタフェースで提供このストリームがパラレルストリームであればtrue を返す
S sequential()	BaseStream 
	インタフェースで提供ストリームをソースとして、シーケンシャルストリームを返す
*/