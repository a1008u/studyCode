package JavaSE8.type7;

import java.time.*;

public class Sample7_11 {
  public static void main(String[] args) {
	  
	// 夏時間の切り替え日時を使用したZonedDateTimeオブジェクト
	  
    ZoneId zone = ZoneId.of("America/Los_Angeles");
    LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
    LocalTime time1 = LocalTime.of(1, 00); //切り替え前
    LocalTime time2 = LocalTime.of(2, 00); //切り替え中
    
    ZonedDateTime zoneDt1 = ZonedDateTime.of(date, time1, zone); 
    System.out.println(zoneDt1);
    
    ZonedDateTime zoneDt2 = ZonedDateTime.of(date, time2, zone); 
    System.out.println(zoneDt2);
  }
}

// Answer
// 2016-03-13T01:00-08:00[America/Los_Angeles]
// 2016-03-13T03:00-07:00[America/Los_Angeles]

// 夏時間
// いくつかの国や地域では、夏時間（daylight saving time）を取り入れています。
// 明るい時間をより有効に活用するために時間を年に2回調整する仕組みです。
// 大まかに言えば、夏の間は時計の時間を進めて、夏が終わったら時間を戻します。