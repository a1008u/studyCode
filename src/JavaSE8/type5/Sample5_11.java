package JavaSE8.type5;

import java.util.*;
import java.util.stream.*;

public class Sample5_11 {
  public static void main(String[] args) {
	  
    Stream<Double> stream = Stream.empty();
    Optional<Double> result = stream.findFirst();
    
    // System.out.println(result.get()); 
    
    //　T orElse(T other)	
    //	存在する場合は値を返し、それ以外の場合はotherを返す
    System.out.println(result.orElse(0.0)); 
    
    //T orElseGet(Supplier<? extends T> other)	
	//	値が存在する場合はその値を返し、そうでない場合はSupplierを呼び出し、その呼び出しの結果を返す
    System.out.println(result.orElseGet(() -> Math.random())); 
    
    //<X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X extends Throwable	
    //	値が存在する場合は、その含まれている値を返し、それ以外の場合は、指定されたサプライヤによって作成された例外をスローする
    System.out.println(result.orElseThrow(IllegalArgumentException::new)); 
    
    // コンパイルエラー
    //System.out.println(result.orElseThrow(
                         //() -> new IllegalArgumentException())); 
  }
}


// 0.0
// 0.00953106061003628
// Exception in thread "main" java.lang.IllegalArgumentException
//	 at java.util.Optional.orElseThrow(Optional.java:290)
//	 at type5.Sample5_11.main(Sample5_11.java:13)



