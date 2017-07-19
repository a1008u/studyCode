package JavaSE8.type7;

import java.time.*;

public class Sample7_21 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.JANUARY, 10);
    LocalTime time = LocalTime.of(7, 30);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    Period period = Period.ofDays(1);
    Duration duration = Duration.ofDays(1);
    
    System.out.println(date.plus(period));
    //System.out.println(date.plus(duration));　実行時エラー
    //System.out.println(time.plus(period));　実行時エラー
    System.out.println(time.plus(duration));
    System.out.println(dateTime.plus(period));
    System.out.println(dateTime.plus(duration));
  }
}

//　Answer
//　2016-01-11
//　07:30
//　2016-01-11T07:30
//　2016-01-11T07:30


//　PeriodクラスとDurationクラスを利用する際の注意点をまとめます。
//　Periodクラスは、LocalDateクラス、LocalDateTimeクラス（ZonedDateTime クラスも可能）での間隔処理に利用可能ですが、LocalTimeは使用できません。
//　Durationクラスは、LocalTimeクラス、LocalDateTimeクラス（ZonedDateTime クラスも可能）での間隔処理に利用可能ですが、LocalDateは使用できません。