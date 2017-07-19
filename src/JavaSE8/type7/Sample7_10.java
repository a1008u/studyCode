package JavaSE8.type7;

import java.time.*;

public class Sample7_10 {
  public static void main(String[] args) {
    ZoneOffset offset = ZoneOffset.of("+09:00");
    LocalDateTime lDateTime = LocalDateTime.of(2016, 2, 20, 10, 30, 45, 200); 
    OffsetDateTime oDateTime = OffsetDateTime.of(lDateTime, offset); 
    
    System.out.println(oDateTime);
  }
}

// Answer
// 2016-02-20T10:30:45.000000200+09:00

// OffsetDateTimeクラス
//  時差を含んだ日付/時刻クラスは、
//  OffsetDateTimeとして提供されており、
//  of()メソッドでOffsetDateTimeオブジェクトの生成が可能です。

//　OffsetDateTime クラスの主なメソッド
//　メソッド名	説明
//　	static OffsetDateTime of(
//　	          int year,
//　	          int month,
//	          int dayOfMonth,
//	          int hour,
//	          int minute,
//	          int second,
//	          int nanoOfSecond,
//	          ZoneOffset offset)	
//　・年、月、日、時、分、秒、ナノ秒、オフセットからOffsetDateTime オブジェクトを取得する
//　	static OffsetDateTime of(
//　	          LocalDateTime dateTime,
//　	          ZoneOffset offset)
//　・LocalDateTimeとオフセットをもとにOffsetDateTimeオブジェクトを取得する
// ZoneOffsetは時差を表します。
// ZoneOffsetオブジェクトの取得にはof()メソッドを使用し、引数はString型で、+hh:mmや-hh:mmといったフォーマットで時差を指定します。
