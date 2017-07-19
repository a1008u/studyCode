package JavaSE8.type7;

import java.time.*;

public class Sample7_3 {
  public static void main(String[] args) {
	  
	// 構文1：static LocalDate of(int year, int month, int dayOfMonth)
    LocalDate dateOf = LocalDate.of(2016, 02, 24);
    
    //構文2：static LocalDate of(int year, Month month, int dayOfMonth)
    //  構文2の第2引数を確認してください。java.time.Month は12か月を表す列挙型
    LocalDate dateOf2 = LocalDate.of(2016, Month.FEBRUARY, 24);
    System.out.println(dateOf2);
    
    Month m = Month.FEBRUARY;
    // boolean result1 = m == 5; コンパイルエラー
    boolean result2 = m == Month.APRIL;
    
    System.out.println(m);
    System.out.println(result2);
    System.out.println("getYear() : " + dateOf2.getYear());
    System.out.println("getMonth() : " + dateOf2.getMonth());
    System.out.println("getMonthValue() : " + dateOf2.getMonthValue());
    System.out.println("getDayOfMonth() : " + dateOf2.getDayOfMonth());
  }
}

// Answer
//  2016-02-24
//  FEBRUARY 
//  false
//  getYear() : 2016
//  getMonth() : FEBRUARY
//  getMonthValue() : 2
//  getDayOfMonth() : 24


//構文1：static LocalDate of(int year, int month, int dayOfMonth)
//構文2：static LocalDate of(int year, Month month, int dayOfMonth)
//      構文2の第2引数を確認してください。java.time.Month は12か月を表す列挙型