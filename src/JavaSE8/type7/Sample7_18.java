package JavaSE8.type7;

import java.time.*;

public class Sample7_18 {
  public static void main(String[] args) {
	  
	// Durationクラスは、時間単位で間隔を扱うクラスです。
	// このクラスは、秒を表すlong値とナノ秒を表すint値(0 と999,999,999 の間になる)を保持します。
	// 使い方はPeriodクラスと類似しており、また、提供するメソッドも名前から想定されるため、違いを中心にサンプルコードを用いて説明します。 
	  
	// Durationオブジェクトを取得するofXXX()メソッド 
	
    System.out.println(Duration.ofDays(1));    
    System.out.println(Duration.ofHours(1));   
    System.out.println(Duration.ofMinutes(1)); 
    System.out.println(Duration.ofSeconds(1)); 
    System.out.println(Duration.ofMillis(1));  
    System.out.println(Duration.ofNanos(1));   
  }
}

//　Answer
// PTはPeriod of Time
//　PT24H
//　PT1H
//　PT1M
//　PT1S
//　PT0.001S
//　PT0.000000001S

