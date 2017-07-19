package JavaSE8.type7;

import java.time.LocalDate;

public class Sample7_7 {
  public static void main(String[] args) {
	  
	// LocalDate クラスの加算を行うメソッド  
	// メソッド名	説明
	// LocalDate plusDays(long daysToAdd)	
	//  指定された日数を加算した、このLocalDat のコピーを返す
	// LocalDate plusMonths(long monthsToAdd)	
	//  指定された月数を加算した、このLocalDate のコピーを返す
	// LocalDate plusWeeks(long weeksToAdd)	
	//  指定された週数を加算した、このLocalDate のコピーを返す
	// LocalDate plusYears(long yearsToAdd)	
	//  指定された年数を加算した、このLocalDate のコピーを返す
	  
    LocalDate date = LocalDate.of(2016, 4, 1);
    
    System.out.println("date    : " + date);
    System.out.println("3日後    : " + date.plusDays(3));
    System.out.println("5ケ月後  : " + date.plusMonths(5));
    System.out.println("2週間後  : " + date.plusWeeks(2));
    System.out.println("10年後   : " + date.plusYears(10));
    System.out.println("date    : " + date);
  }
}

//Answer
//date    : 2016-04-01
//3日後    : 2016-04-04
//5ケ月後  : 2016-09-01
//2週間後  : 2016-04-15
//10年後   : 2026-04-01
//date    : 2016-04-01 immutable