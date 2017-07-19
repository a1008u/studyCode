package JavaSE8.type12;

import java.time.*;

public class Sample12_11 {
  public static void main(String[] args) {
	  
    LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 1);
    
    System.out.println("getYear       : " + date.getYear());
    System.out.println("getMonth      : " + date.getMonth());
    System.out.println("getMonthValue : " + date.getMonthValue());
    System.out.println("getDayOfMonth : " + date.getDayOfMonth());
    System.out.println("getDayOfYear  : " + date.getDayOfYear());
    System.out.println("getDayOfWeek  : " + date.getDayOfWeek());
  }
}

/*
	Answer
		getYear       : 2016
		getMonth      : FEBRUARY
		getMonthValue : 2
		getDayOfMonth : 1
		getDayOfYear  : 32
		getDayOfWeek  : MONDAY
*/

/*
SE7までは、java.util.Dateやjava.util.Calendarクラスを使用して日付を扱い、
java.text.DateFormatやjava.text.SimpleDateFormatクラスを使用して日付のフォーマットを行っていました。
しかし、SE8から日付/ 時刻 APIの導入により、日付やフォーマットもjava.time パッケージで提供されている各クラスを利用することが可能です。
*/