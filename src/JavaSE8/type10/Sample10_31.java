package JavaSE8.type10;

import java.util.*;
import java.util.concurrent.*;

class ExamRecursiveTask extends RecursiveTask<Double> {
  private Double[] nums;
  private int start;
  private int end;
  public ExamRecursiveTask(String name, Double[] nums, int start, int end) {
    System.out.println("name : " + name + " " + start + " " +  end);
    this.nums = nums;
    this.start = start;
    this.end = end;
  }
  
  //protected abstract void compute() このタスクによって実行される計算処理を実装する。戻り値はない(RecursiveActionクラス)
  protected Double compute() {
    if(end - start <= 3) {
      double sum = 0.0;
      for(int i = start; i < end; i++) {
        nums[i] = Math.random() * 100;
        System.out.println("nums[" + i + "] " + nums[i] );
        sum += nums[i];
      }
      return sum;
    } else {
      int middle = start + (end -start)/2;
      System.out.println("start:" + start + " middle:" + middle + " end:" + end);
      ExamRecursiveTask task1 = new ExamRecursiveTask("f1", nums, start, middle);
      ExamRecursiveTask task2 = new ExamRecursiveTask("f2", nums, middle, end);
      // final ForkJoinTask<V> fork()	このタスクを非同期で実行するための調整を行う
      task1.fork();
      // protected abstract void compute() このタスクによって実行される計算処理を実装する。戻り値はない(RecursiveActionクラス)
      Double sum1 = task2.compute();
      // final V join()計算が完了した後、計算の結果を返す(ForkJoinTaskクラス)
      Double sum2 = task1.join();
      return sum1 + sum2;
    }
  }
  
}

public class Sample10_31 {
  public static void main(String[] args) {
    Double[] nums = new Double[10];
    ForkJoinTask<Double> task =  new ExamRecursiveTask("main", nums, 0, 10);
    ForkJoinPool pool = new ForkJoinPool();
    Double sum = pool.invoke(task);
    System.out.println("sum : " + sum);
  }
}

/*
Answer
	name : main 0 10
	start:0 middle:5 end:10
	name : f1 0 5
	name : f2 5 10
	start:5 middle:7 end:10
	name : f1 5 7
	name : f2 7 10
	start:0 middle:2 end:5
	name : f1 0 2
	name : f2 2 5
	nums[0] 74.34659565820961
	nums[5] 15.974308528766946
	nums[7] 11.998981284929378
	nums[2] 15.760491253546771
	nums[8] 17.844217166578492
	nums[6] 54.314316047443654
	nums[1] 36.655095190928144
	nums[9] 93.14770220698858
	nums[3] 20.760886652418176
	nums[4] 74.76382903337986
	sum : 415.5664230231896
	*/
