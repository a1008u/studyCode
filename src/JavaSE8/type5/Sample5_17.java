package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_17 {
  public static void main(String[] args) {
	  
    List<String> list = 
           Stream.of("one", "three", "two", "three", "four")
                 .filter(s -> s.length() > 3)
                 .peek(e -> System.out.println("フィルタ後 : " + e))
                 .distinct() // 重複する単語があれば排除
                 .map(String::toUpperCase)
                 .peek(e -> System.out.println("マップ後   : " + e))
                 .collect(Collectors.toList());
  }
}

// Answer
// フィルタ後 : three
// マップ後   : THREE
// フィルタ後 : three　イテレータがあるため、その後に排除しても実行時エラーにならない
// フィルタ後 : four
// マップ後   : FOUR

//Stream<T> peek(Consumer<? super T> action)	
//	このストリームの要素から成るストリームを返す。要素がパイプラインを通過する際にその内容を確認するようなデバッグとして使用する