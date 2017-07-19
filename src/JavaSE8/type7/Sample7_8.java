package JavaSE8.type7;

import java.time.LocalDateTime;

public class Sample7_8 {
  public static void main(String[] args) {
	  
    LocalDateTime dateTime = LocalDateTime.of(2016, 1, 20, 10, 30, 00); 
    
    System.out.println(dateTime);         //2016-01-20T10:30
    
    dateTime.minusDays(1);   
    dateTime.minusHours(7); 
    dateTime.minusSeconds(15);
    System.out.println(dateTime); // immutableのため、変数は変更されない
    
    dateTime = dateTime.minusDays(1);     //2016-01-19T10:30
    dateTime = dateTime.minusHours(7);    //2016-01-19T03:30
    dateTime = dateTime.minusSeconds(15); //2016-01-19T03:29:45
    System.out.println(dateTime);
  }
}

// Answer
// 2016-01-20T10:30
// 2016-01-20T10:30
// 2016-01-19T03:29:45

