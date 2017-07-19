package JavaSE8.type7;

import java.time.*;

public class Sample7_23 {
  public static void main(String[] args) {
	 
	// static Instant ofEpochSecond(long epochSecond)	
	//		 エポック1970-01-01T00:00:00Zからの秒数を使用してInstantを取得する  
	  
    Instant instant1 = Instant.ofEpochSecond(0);
    System.out.println(instant1);
    
    LocalDate date = LocalDate.of(2016, Month.JANUARY, 1);
    LocalTime time = LocalTime.of(11, 55);
    ZoneId zone = ZoneId.of("America/Los_Angeles");
    ZonedDateTime zoneDt = ZonedDateTime.of(date, time, zone);
    Instant instant2 = zoneDt.toInstant();
    
    System.out.println(zoneDt);
    System.out.println(instant2);
  }
}

//　Answer
//　1970-01-01T00:00:00Z
//　2016-01-01T11:55-08:00[America/Los_Angeles]
//　2016-01-01T19:55:00Z

// Instant オブジェクトの作成メソッド
// メソッド名	　説明
// static Instant now()	
//	 システム・クロックから現在のInstantを取得する
// static Instant ofEpochSecond(long epochSecond)	
//	 エポック1970-01-01T00:00:00Zからの秒数を使用してInstant を取得する
// static Instant ofEpochSecond(long epochSecond, long nanoAdjustment)	
//	 1970-01-01T00:00:00Z からの秒数と秒のナノ秒を使用してInstant を取得する
// static Instant ofEpochMilli(long epochMilli)	
//	 エポック1970-01-01T00:00:00Zからのミリ秒数を使用してInstantを取得する