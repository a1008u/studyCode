package JavaSE8.type10;

import java.util.*;
import java.util.concurrent.*;

class ExamRecursiveAction extends RecursiveAction {
  private Double[] nums;
  private int start;
  private int end;
  public ExamRecursiveAction(String name, Double[] nums, int start, int end) {
    System.out.println("name : " + name + " " + start + " " +  end);
    this.nums = nums;
    this.start = start;
    this.end = end;
  }
  
  //protected abstract void compute() このタスクによって実行される計算処理を実装する。戻り値はない(RecursiveActionクラス)
  protected void compute() {
    if(end - start <= 3) {
      for(int i = start; i < end; i++) {
        nums[i] = Math.random() * 100;
        System.out.println("nums[" + i + "] " + nums[i] );
      }
    } else {
      int middle = start + (end -start)/2;
      System.out.println("start:" + start + " middle:" + middle + " end:" + end);
      
      invokeAll(new ExamRecursiveAction("f1", nums, start, middle), new ExamRecursiveAction("f2", nums, middle, end));
    }
  }
}

public class Sample10_30 {
  public static void main(String[] args) {
	  /*Fork/Joinフレームワーク
	   * ExecutorServiceインタフェースの実装です。
	   * このフレームワークは、重い計算を小さなタスクに分割し、
	   * 複数のスレッドによって並列実行することで、高速に処理することを目的としています。
	   * Fork/Joinフレームワークではスレッドプール内のスレッドにタスクを分散します。
	   * そしてwork-stealingアルゴリズムにより、処理が終わったスレッドは、ビジー状態の他のスレッドからタスクをスティールする（盗む）ことができます。
	   * */	  
	  
    Double[] nums = new Double[10];
    ForkJoinTask<?> task = new ExamRecursiveAction("main", nums, 0, 10);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(task);
  }
}

/*
Answer
	name : main 0 10
	start:0 middle:5 end:10
	name : f1 0 5
	name : f2 5 10
	start:0 middle:2 end:5
	name : f1 0 2
	start:5 middle:7 end:10
	name : f1 5 7
	name : f2 7 10
	name : f2 2 5
	nums[0] 51.82484858423071
	nums[2] 64.73602561270889
	nums[5] 8.903728052448034
	nums[7] 35.985300416014724
	nums[6] 75.99454786743034
	nums[3] 94.05061155936228
	nums[1] 29.933181326060954
	nums[4] 39.77031832247666
	nums[8] 40.911401002710754
	nums[9] 30.190330691747747
*/

/*
Fork/Joinフレームワークの主なインタフェースとクラス
インタフェース／クラス名	説明
ForkJoinPoolクラス	
	Fork/Joinタスクを実行するためのExecutorServiceインタフェースの実装クラス
ForkJoinTaskクラス	
	ForkJoinPool内で実行する抽象基底クラス
RecursiveActionクラス	
	結果を返さない再帰的なForkJoinTaskのサブクラス
RecursiveTaskクラス	
	結果を生成する再帰的なForkJoinTaskのサブクラス
	
ForkJoinTaskクラスの主なメソッド
メソッド名	説明
final ForkJoinTask<V> fork()	
	このタスクを非同期で実行するための調整を行う
static void invokeAll( ForkJoinTask<?> t1, ForkJoinTask<?> t2)	
	指定されたタスクをフォークしてパラレルに処理を実行する
final V join()
	計算が完了した後、計算の結果を返す

RecursiveActionクラスとRecursiveTaskクラスのcompute()メソッド
RecursiveActionクラスの主なメソッド
メソッド名	 説明
protected abstract void compute()	
	このタスクによって実行される計算処理を実装する。戻り値はない
RecursiveTask クラスの主なメソッド
メソッド名	 説明
protected abstract V compute()	
	このタスクによって実行される計算処理を実装する。戻り値は任意のオブジェクト
*/