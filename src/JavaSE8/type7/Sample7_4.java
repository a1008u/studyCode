package JavaSE8.type7;

import java.time.*;

public class Sample7_4 {
  public static void main(String[] args) {
    //LocalTimeのof()メソッドの利用
	//①～③は、LocalTime クラスのof() メソッドです。
	//		①時、分からLocalTime オブジェクトの取得
	//		②時、分、秒からLocalTime オブジェクトの取得
	//		③時、分、秒、ナノ秒からLocalTime オブジェクトの取得
    LocalTime lt1 = LocalTime.of(3, 15);          //①
    LocalTime lt2 = LocalTime.of(3, 15, 30);      //②
    LocalTime lt3 = LocalTime.of(3, 15, 30, 180); //③
    
    System.out.println("① " + lt1);
    System.out.println("② " + lt2);
    System.out.println("③" + lt3);
    
    //LocalDateTimeのof()メソッドの利用
	//④～⑦は、LocalDateTime クラスのof() メソッドです。
	//	④ 秒およびナノ秒をゼロに設定して、年、月、日、時、分からLocalDateTime オブジェクトの取得
	//	⑤ ナノ秒をゼロに設定して、年、月、日、時、分、秒からLocalDateTime オブジェクトの取得
	//	⑥年、月、日、時、分、秒、ナノ秒からLocalDateTime オブジェクトの取得
	//	⑦ 事前に用意した、LocalDate とLocalTime オブジェクトを使用してLocal DateTime オブジェクトの取得
    LocalDateTime ldt1 = LocalDateTime.of(2016, 2, 24, 3, 15);          //④
    LocalDateTime ldt2 = LocalDateTime.of(2016, 2, 24, 3, 15, 30);      //⑤
    LocalDateTime ldt3 = LocalDateTime.of(2016, 2, 24, 3, 15, 30, 180); //⑥
    
    System.out.println("④ " + ldt1);
    System.out.println("⑤ " + ldt2);
    System.out.println("⑥ " + ldt3);
    
    LocalDate date = LocalDate.of(2016, 2, 24);
    LocalTime time = LocalTime.of(3, 15);
    LocalDateTime ldt = LocalDateTime.of(date, time);   //⑦
    System.out.println("⑦ " + ldt);
  }
}

// Answer
//	① 03:15
//	② 03:15:30
//	③ 03:15:30.000000180
//	④ 2016-02-24T03:15
//	⑤ 2016-02-24T03:15:30
//	⑥ 2016-02-24T03:15:30.000000180
//	⑦ 2016-02-24T03:15

//①～③は、LocalTime クラスのof() メソッドです。
//	①時、分からLocalTime オブジェクトの取得
//	②時、分、秒からLocalTime オブジェクトの取得
//	③時、分、秒、ナノ秒からLocalTime オブジェクトの取得
//④～⑦は、LocalDateTime クラスのof() メソッドです。
//	④ 秒およびナノ秒をゼロに設定して、年、月、日、時、分からLocalDateTime オブジェクトの取得
//	⑤ ナノ秒をゼロに設定して、年、月、日、時、分、秒からLocalDateTime オブジェクトの取得
//	⑥年、月、日、時、分、秒、ナノ秒からLocalDateTime オブジェクトの取得
//	⑦ 事前に用意した、LocalDate とLocalTime オブジェクトを使用してLocal DateTime オブジェクトの取得
