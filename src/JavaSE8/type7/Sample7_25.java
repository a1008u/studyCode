package JavaSE8.type7;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Sample7_25 {
  public static void main(String[] args){
    Instant instant1 = Instant.now();
    System.out.println("instant1 : " + instant1);
    
    Instant instant2 = instant1.plusSeconds(10);
    System.out.println("instant2 : " + instant2);
    
    Instant instant3 = instant1.plus(10, ChronoUnit.SECONDS);
    System.out.println("instant3 : " + instant3);
    
    Instant instant4 = instant1.plus(10, ChronoUnit.DAYS);
    System.out.println("instant4 : " + instant4);
    
    // 実行時エラー　Instantクラスのplusやminus()では、MONTHSとYEARSは利用できない
    Instant instant5 = instant1.plus(10, ChronoUnit.YEARS);
    System.out.println("instant5 : " + instant5);
  }
}

// Answer
//  instant1 : 2017-02-18T07:03:18.305Z
//  instant2 : 2017-02-18T07:03:28.305Z
//  instant3 : 2017-02-18T07:03:28.305Z
//  instant4 : 2017-02-28T07:03:18.305Z

// ==Instantクラスのplus()やminus()メソッドで指定可能な列挙==
// Instant クラスのplus()やminus()メソッドで指定可能なChronoUnit列挙値
// フィールド名	説明
// NANOS	plusNanos(long) と同等
// MICROS	1,000 倍されたplusNanos(long) と同等
// MILLIS	1,000,000 倍されたplusNanos(long) と同等
// SECONDS	plusSeconds(long)と同等
// MINUTES	60 倍されたplusSeconds(long) と同等
// HOURS	3,600 倍されたplusSeconds(long) と同等
// HALF_DAYS	43,200 (3,600×12 時間)倍されたplusSeconds(long) と同等
// DAYS	86,400 (3,600×24 時間)倍されたplusSeconds(long) と同等