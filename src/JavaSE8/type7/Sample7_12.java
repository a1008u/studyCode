package JavaSE8.type7;

import java.time.*;

public class Sample7_12 {
  public static void main(String[] args) {
	  
	// 夏時間の切り替え日時が含まれる時間の加減処理
	  
    LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
    LocalTime time = LocalTime.of(1, 30);
    ZoneId zone = ZoneId.of("America/Los_Angeles");
    
    ZonedDateTime zoneDt = ZonedDateTime.of(date, time, zone); 
    System.out.println(zoneDt);
    
    zoneDt = zoneDt.plusHours(1); //サマータイム
    System.out.println(zoneDt);
  }
}

// Answer
// 2016-03-13T01:30-08:00[America/Los_Angeles]
// 2016-03-13T03:30-07:00[America/Los_Angeles]
