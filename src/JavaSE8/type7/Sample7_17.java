package JavaSE8.type7;

import java.time.*;

public class Sample7_17 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.JANUARY, 10);
    LocalTime time = LocalTime.of(7, 30);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    Period period = Period.ofMonths(1);
    
    System.out.println(dateTime);
    System.out.println(dateTime.plus(period));
    System.out.println(date); // immutableのため変更しない
    System.out.println(date.plus(period));
    //System.out.println(time.plus(period)); 実行時エラー
  }
}

// Answer
// 2016-01-10T07:30
// 2016-02-10T07:30
// 2016-01-10
// 2016-02-10

//　LocalTime、LocalDate、LocalDateTimeクラスには、加減算を行うメソッドが提供されています。
//　LocalDateTimeクラスのメソッド
//　　LocalDateTime plus(TemporalAmount amountToAdd)
//　　LocalDateTime minus(TemporalAmount amountToSubtract)

