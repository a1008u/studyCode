package JavaSE8.type7;

import java.time.*;

public class Sample7_24 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.JANUARY, 1);
    LocalTime time = LocalTime.of(11, 55);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    
	 // LocalDateTimeクラスからInstantオブジェクトを取得する場合は、
	 // 引数にZoneOffsetをとるtoInstant()メソッドを使用します。
    // -構文-
    // default Instant toInstant(ZoneOffset offset)
	 // (LocalDateTimeクラスのスーパーインタフェースであるChronoLocalDateTimeで定義されているデフォルトメソッド)
	 // LocalDateTimeクラスは、時差、タイムゾーンを持たないため、Instantオブジェクトへの変換には時差の情報が必要になります。
	 // そのため、toInstant()メソッドの引数に時差であるZoneOffsetオブジェクトを指定します。
    //Instant instant = dateTime.toInstant();  //コンパイルエラー
    Instant instant1 = dateTime.toInstant(ZoneOffset.of("+09:00"));
    
    //LocalDateTime → ZonedDateTime → Instant
    ZonedDateTime zoneDt = dateTime.atZone(ZoneId.of("Asia/Tokyo"));
    Instant instant2 = zoneDt.toInstant();
    
    //LocalDateTime → OffsetDateTime → Instant
    OffsetDateTime offsetDt = dateTime.atOffset(ZoneOffset.of("+09:00"));
    Instant instant3 = offsetDt.toInstant();
    
    System.out.println(instant1);
    System.out.println(instant2);
    System.out.println(instant3);
  }
}

/*
	Answer
		2016-01-01T02:55:00Z
		2016-01-01T02:55:00Z
		2016-01-01T02:55:00Z
*/

// Instant クラスの主な加算用メソッド
// メソッド名 	説明
// Instant plusSeconds(long secondsToAdd)	
//	 指定された秒を加算したものを返す
// Instant plus(long amountToAdd, TemporalUnit unit)	
//	 第1引数に指定された量（第2 引数 に単位を指定）を加算したものを返す