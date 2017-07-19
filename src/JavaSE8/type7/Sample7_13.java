package JavaSE8.type7;

import java.time.*;

public class Sample7_13 {
  public static void main(String[] args) {
	  
    LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
    LocalTime time = LocalTime.of(1, 30);
    ZoneId zone = ZoneId.of("America/Los_Angeles");
    
    ZonedDateTime zoneDt = ZonedDateTime.of(date, time, zone); 
    System.out.println(zoneDt);
    
    zoneDt = zoneDt.plusHours(1); // サマータイム
    System.out.println(zoneDt);
    
    zoneDt = zoneDt.plusHours(1);
    System.out.println(zoneDt);
  }
}

// Answer
// 2016-11-06T01:30-07:00[America/Los_Angeles]
// 2016-11-06T01:30-08:00[America/Los_Angeles]
// 2016-11-06T02:30-08:00[America/Los_Angeles]
