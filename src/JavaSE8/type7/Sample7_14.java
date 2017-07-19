package JavaSE8.type7;

import java.time.*;

public class Sample7_14 {
  public static void main(String[] args) {
	  
	// Periodクラスは、年、月、日単位で間隔を扱うクラスです。
	  
    LocalDate start = LocalDate.of(2016, Month.JANUARY, 1);
    LocalDate end = LocalDate.of(2017, Month.MARCH, 5);
    Period period = Period.between(start, end);
    
    System.out.println("period     : " + period);
    System.out.println("getYears() : " + period.getYears());
    System.out.println("getMonths(): " + period.getMonths());
    System.out.println("getDays()  : " + period.getDays());
  }
}

// Answer
// period     : P1Y2M4D P:Periodを表す 1Y：年数を表す 2M：月数を表す 4D：日数を表す
// getYears() : 1
// getMonths(): 2
// getDays()  : 4


