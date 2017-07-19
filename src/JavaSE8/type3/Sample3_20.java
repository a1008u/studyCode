package JavaSE8.type3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Comparator.*;

public class Sample3_20 {
  public static void main(String[] args) {
    int[ ] ary1 = { 3, 1, 2 };
    print(ary1); 
    System.out.println();
    
    Arrays.sort(ary1);
    print(ary1); 
    System.out.println();
    
    Stream.of(ary1).forEach(a -> System.out.println(a[1]));;
    System.out.println();
    
    Object[ ] ary2= { new String("aa"), new Integer(1) };
    Arrays.sort(ary2);
  }
  
  public static void print(int[] ary){
    for(int num : ary){ System.out.print(num + " "); }
  }
}

// Answer
//　3 1 2 
//　1 2 3 
//　Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
//	　at java.lang.Integer.compareTo(Integer.java:52)
//	　at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
//	　at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
//	　at type3.Sample3_20.main(Sample3_20.java:12)

// Arraysクラスは、配列の操作を行うクラス
//様々な参照型のオブジェクトを要素にもつ配列をSort()メソッドでソートしようとすると、ClassCastException例外が発生