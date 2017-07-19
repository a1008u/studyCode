package JavaSE8.type10;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class Sample10_28 {
  public static void main(String[] args) {
	  
	/*  
	構文2：<R> R collect(Supplier<R> supplier,
				BiConsumer<R,? super T> accumulator,
				BiConsumer<R,R> combiner)
	第1引数：結果を格納するオブジェクトの生成を指定します。
	第2引数：要素ごとに行う処理を指定します。
	第3引数：パラレルストリームの場合のみ適用され、reduce()と同様に途中の集約結果のマージに使用する処理を指定します。
	*/
	  
    List<String> data = Arrays.asList("orange", "banana", "lemon");
    List<String> list =  data.parallelStream()
                             .collect(() -> new CopyOnWriteArrayList<>(),
                            		 (plist, s) -> plist.add(s.toUpperCase()),
                            		 (alist, blist) -> alist.addAll(blist));
    for(String s : list) { System.out.print(s + " "); }
    
    System.out.println();
    
    Set<String> set = data.parallelStream().collect(CopyOnWriteArraySet::new,
							                        Set::add,
							                        Set::addAll);
    for(String e : set) { System.out.print(e + " "); }
  }
}

/*
	Answer
		ORANGE BANANA LEMON 
		orange banana lemon 
*/

/*
collect()メソッドを確認します。
collect()もオーバーロードされており、ストリームから要素をまとめて1つのオブジェクトを取得するメソッドです。
本章では5章では扱わなかった構文2について確認します。

構文
構文1：<R,A> R collect(Collector<? super T,A,R> collector)
構文2：<R> R collect(Supplier<R> supplier,
			BiConsumer<R,? super T> accumulator,
			BiConsumer<R,R> combiner)

まず第1引数は、結果を格納するオブジェクトの生成を指定します。
第2引数は要素ごとに行う処理を指定します。
第3引数はパラレルストリームの場合のみ適用され、reduce()と同様に途中の集約結果のマージに使用する処理を指定します。
*/