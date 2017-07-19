package JavaSE8.type5;

import java.util.stream.*;
import java.util.*;

public class Sample5_22 {
  public static void main(String[] args) {
    // toMap()メソッド
    Stream<String> stream1 = Stream.of("nao", "akko", "ami");
    Map<String, Integer> map1= stream1.collect(Collectors.toMap(s -> s, String::length));
    System.out.println(map1);
    
    // toMap()メソッド(キーが重複するため、実行時エラー)
    Stream<String> stream2 = Stream.of("nao", "akko", "ami");
    Map<Integer, String> map2= stream2.collect(Collectors.toMap(String::length, s -> s));
    System.out.println(map2);
  }
}

// Answer
// {akko=4, ami=3, nao=3}
// Exception in thread "main" java.lang.IllegalStateException: Duplicate key nao
//	at java.util.stream.Collectors.lambda$throwingMerger$115(Collectors.java:133)
//	at java.util.HashMap.merge(HashMap.java:1245)
//	at java.util.stream.Collectors.lambda$toMap$173(Collectors.java:1320)
//	at java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
//	at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
//	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481)
//	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
//	at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
//	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
//	at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499)
//	at type5.Sample5_22.main(Sample5_22.java:15)
