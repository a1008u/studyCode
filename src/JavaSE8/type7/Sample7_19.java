package JavaSE8.type7;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Sample7_19 {
  public static void main(String[] args) {
	  
	// 構文1：static Duration ofSeconds(long seconds)  
    Duration duration1 = Duration.ofSeconds(12);  
    
    // 構文2：static Duration ofSeconds(long seconds, long nanoAdjustment)
    Duration duration2 = Duration.ofSeconds(12, 300_000_000);  
    
	 // 構文3：static Duration of(long amount, TemporalUnit unit)
	 // 構文3は、第2引数で指定された単位での間隔を表すDurationを作成します。
	 // TemporalUnitインタフェースの実装として、java.time.temporalパッケージにChronoUnit列挙型が提供されています。
    Duration duration3 = Duration.of(12, ChronoUnit.SECONDS);  
    
    System.out.println("duration1 : " + duration1);
    System.out.println("duration2 : " + duration2);
    System.out.println("duration3 : " + duration3);
  }
}

// Answer
// duration1 : PT12S
// duration2 : PT12.3S
// duration3 : PT12S

// 構文1：static Duration ofSeconds(long seconds)
// 構文2：static Duration ofSeconds(long seconds, long nanoAdjustment)
// 構文3：static Duration of(long amount, TemporalUnit unit)
// 構文3は、第2引数で指定された単位での間隔を表すDurationを作成します。
// TemporalUnitインタフェースの実装として、java.time.temporal パッケージにChronoUnit列挙型が提供されています。

// ChronoUnit  列挙型の主な定数
// 定数名	説明	 定数名	説明
// DAYS	    1 日	
// HOURS	1 時間	
// MINUTES	1 分	
// SECONDS	1 秒
// MILLIS	1 ミリ秒
// NANOS	1 ナノ秒