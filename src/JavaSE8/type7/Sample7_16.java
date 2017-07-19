package JavaSE8.type7;

import java.time.*;

public class Sample7_16 {
  public static void main(String[] args) {
    LocalDate start = LocalDate.of(2016, Month.JANUARY, 1);
    LocalDate end = LocalDate.of(2016, Month.JANUARY, 15);
    
    Period period = Period.between(start, end);
    System.out.println(period.getDays());
    
    // Period plusDays(long daysToAdd)	
    //  指定された日数を加算して、この期間のコピーを返す
    period = period. plusDays(6);
    System.out.println(period.getDays());
  }
}

// Answer
// 14
// 20

// Periodクラスの加算用メソッド
// メソッド名	 説明
// Period plusYears(long yearsToAdd)	指定された年数を加算して、この期間のコピーを返す
// Period plusMonths(long monthsToAdd)	指定された月数を加算して、この期間のコピーを返す
// Period plusDays(long daysToAdd)	指定された日数を加算して、この期間のコピーを返す
// Period plus(TemporalAmount amountToAdd)	これは、年数、月数、および日数に対して別々に加算を行い、この期間のコピーを返す

