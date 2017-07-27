package JavaSE8.type5;

import java.util.stream.*;

public class Sample5_12 {
  public static void main(String[] args) {
	
	// 生成
    Stream<String> stream1 = Stream.of("ami", "naoki", "akko");
    
    // 中間操作→終端操作
    // Stream<T> filter(Predicate<? super T> predicate)	　 抽象メソッド：boolean test(T t);
    // 	指定された条件に一致するものから構成されるストリームを返す
    stream1.filter(s -> s.startsWith("a"))
           .forEach(startA -> System.out.print(startA + " "));
    
    System.out.println();
    
    // 生成→中間操作→終端操作
    // Stream<T> distinct()	
    // 	重複を除いた要素から構成されるストリームを返す
    Stream<String> stream2 = Stream.of("ami", "naoki", "akko", "ami");
    stream2.distinct()
           .forEach(x -> System.out.print(x + " "));
  }
}

// Answer
// ami akko 
// ami naoki akko 

// 中間操作は、取得したストリームに対して何かしらの処理を指定し、新しいストリームを生成します。
// ストリームを使用している場合、保持する要素ごとに対して行いたい処理をラムダ式等で指定しますが、
// 実際のイテレーション（反復処理）コードを私たちが記述することはありませんでした。
// これは、ストリームが内部でイテレータを保持しているからです。

// ストリーム生成→中間操作①→中間操作②→終端操作というように、パイプライン処理を行う際に、毎回イテレーションが行われることはありません。
// イテレーションは終端操作時でのみ実行されます。つまり、中間操作ではメソッドを使用して処理の登録だけを行っておくということになります。
// 中間操作メソッドに渡した処理は、終端操作が呼び出されたときに実行される。

// 中間操作の主なメソッド
// メソッド名	 説明
// Stream<T> filter(Predicate<? super T> predicate)	
//	指定された条件に一致するものから構成されるストリームを返す
// Stream<T> distinct()	
//	重複を除いた要素から構成されるストリームを返す
// Stream<T> limit(long maxSize)	
//	maxSize以内の長さに切り詰めた結果から構成されるストリームを返す
// Stream<T> skip(long n)	
//	先頭からn個の要素を破棄した残りの要素で構成されるストリームを返す
// < R > Stream < R > map( Function < ? super T,? extends R> mapper)	
//	指定された関数を適用した結果から構成されるストリームを返す
// <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)	
//	指定された関数を適用した複数の結果から構成される1 つのストリームを返す
// Stream<T> sorted()	
//  自然順序に従ってソートした結果から構成されるストリームを返す
// Str eam< T > sor ted(C omparator< ? super T> comparator)	
//	指定されたComparatorに従ってソートした結果から構成されるストリームを返す
// Stream<T> peek(Consumer<? super T> action)	
//	このストリームの要素から成るストリームを返す。要素がパイプラインを通過する際にその内容を確認するようなデバッグとして使用する
