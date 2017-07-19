package JavaSE8.type12;

import java.time.*;
import java.time.format.*;

public class Sample12_12 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 20);
    LocalTime time = LocalTime.of(10, 30, 45);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    
    System.out.println("date     :" + date);
    System.out.println("time     :" + time);
    System.out.println("dateTime :" + dateTime);
    
    
    DateTimeFormatter fmt1 = 
         DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    System.out.println("MEDIUM_date     :" + fmt1.format(date)); 
    //System.out.println("MEDIUM_time   :" + fmt1.format(time)); // 実行時エラー
    System.out.println("MEDIUM_dateTime :" + fmt1.format(dateTime)); 
  }
}

/*
	Answer
		date     :2016-02-20
		time     :10:30:45
		dateTime :2016-02-20T10:30:45
		MEDIUM_date     :2016/02/20
		MEDIUM_dateTime :2016/02/20
*/
/*
ロケール固有の日付フォーマット
	第7章で、DateTimeFormatterクラスのofLocalizedDateTime()メソッドを使用しました。
	このメソッドは、引数にFormatStyle型をとり、ロケール固有の日付/ 時刻フォーマットを返すメソッドです。
	本章では、類似メソッドとして、ofLocalizedDate()とofLocalizedTime()メソッドを使用した例も確認します。
	java.time.format.FormatStyle型は、日付/ 時刻フォーマッタのスタイルの列挙型です。
	列挙値はFULL、LONG、MEDIUM、SHORT の4つです。
	本章では、LocalDate、LocalTime、LocalDateTimeの各オブジェクトをFormatStyleを使用してフォーマットします。
*/