package JavaSE8.type7;

import java.time.*;

public class Sample7_20 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.JANUARY, 10);
    LocalTime time = LocalTime.of(7, 30);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    Duration duration = Duration.ofHours(3);
    
    System.out.println(dateTime);
    System.out.println(dateTime.plus(duration));
    System.out.println(time);
    System.out.println(time.plus(duration));
    //System.out.println(date.plus(duration)); 実行時エラー
  }
}

// Answer
// 2016-01-10T07:30
// 2016-01-10T10:30
// 07:30
// 10:30
