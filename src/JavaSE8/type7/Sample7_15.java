package JavaSE8.type7;

import java.time.*;

public class Sample7_15 {
  public static void main(String[] args) {
	  
	// int getYears()	この期間の年数を取得する
    Period period1 = Period.ofYears(2);
    
    // int getMonths()	この期間の月数を取得する
    Period period2 = Period.ofWeeks(3);
    
    Period period3 = Period.ofYears(1).ofMonths(1);
    
    // static Period of(int years, int months, int days)		
    //  年数、月数、および日数を表すPeriod を取得する
    Period period4 = Period.of(0, 10, 50);
    
    Period period5 = Period.of(0,0,0);
    
    System.out.println("period1 : " + period1);
    System.out.println("period2 : " + period2);
    System.out.println("period3 : " + period3);
    System.out.println("period4 : " + period4);
    System.out.println("period5 : " + period5);
  }
}

// Answer
// period1 : P2Y
// period2 : P21D
// period3 : P1M
// period4 : P10M50D
// period5 : P0D


//Periodクラスの主なメソッド
//メソッド名	説明
// static Period between( LocalDate startDateInclusive,LocalDate endDateExclusive)	
//  2つの日付間の年数、月数、および日数で構成されるPeriodを取得する
// int getYears()	この期間の年数を取得する
// int getMonths()	この期間の月数を取得する
// int getDays()	この期間の日数を取得する
// static Period ofYears(int years)	 年数を表すPeriod を取得する
// static Period ofMonths(int months) 月数を表すPeriod を取得する
// static Period ofWeeks(int weeks)	 週数を表すPeriod を取得する
// static Period ofDays(int days)	 日数を表すPeriod を取得する
// static Period of(int years, int months, int days)	
//  年数、月数、および日数を表すPeriod を取得する