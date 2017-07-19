package JavaSE8.type7;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Sample7_6 {
  public static void main(String[] args) {
	  
	// DateTimeFormatterクラスのofPattern()メソッド  
	
	// static DateTimeFormatter ofPattern( String pattern)	
	//  指定されたパターンを使用してフォーマッタを作成する
	// static DateTimeFormatter ofPattern( String pattern, Locale locale)	
	//  指定されたパターンおよびロケールを使用してフォーマッタを作成する
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MMMM");
    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MMMM", Locale.US);
    LocalDate date = LocalDate.now();
    System.out.println("デフォルトロケール : " + date.format(fmt1));
    System.out.println("USロケール       : " + date.format(fmt2));
    
	// static DateTimeFormatter ofPattern( String pattern)	
	//  指定されたパターンを使用してフォーマッタを作成する
    DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String target = "2016/02/24 21:03:20";
    LocalDateTime dateTime = LocalDateTime.parse(target, fmt3);
    System.out.println(dateTime);
  }
}

// Answer
// デフォルトロケール : 2月
// USロケール       : February
// 2016-02-24T21:03:20