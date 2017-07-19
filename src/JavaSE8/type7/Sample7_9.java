package JavaSE8.type7;

import java.time.*;
import java.time.format.*;
public class Sample7_9 {
  public static void main(String[] args) {
	  
	// static ZoneId systemDefault()	
	// システム・デフォルト・タイムゾーンを表すZoneIdオブジェクトを取得する
    ZoneId zone1 = ZoneId.systemDefault();
    LocalDateTime lDateTime1 = LocalDateTime.of(2016, 2, 20, 10, 30, 45, 200); 
    
	// static ZonedDateTime of(LocalDateTime localDateTime,ZoneId zone)	
	//  LocalDateTime とタイムゾーンをもとにZonedDateTimeオブジェクトを取得する
    ZonedDateTime zDateTime1 = ZonedDateTime.of(lDateTime1, zone1); 
    System.out.println(zDateTime1);
    
    // static ZoneId of(String zoneId)	
    // 指定されたID からZoneIdオブジェクトを取得する
    ZoneId zone2 = ZoneId.of("America/Los_Angeles");
    //	static ZonedDateTime of(
	//    int year,
	//    int month,
	//    int dayOfMonth,
	//    int hour,
	//    int minute,
	//    int second,
	//    int nanoOfSecond,
	//    ZoneId zone)	
	// 年、月、日、時、分、秒、ナノ秒、タイムゾーンからZonedDatTime オブジェクトを取得する
    ZonedDateTime zDateTime2 = ZonedDateTime.of(2016, 2, 20,     //日付
                                				10, 30, 45, 200, //時刻
                                				zone2);          //ゾーン
    System.out.println(zDateTime2);
    
    DateTimeFormatter fmt1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
    System.out.println(fmt1.format(zDateTime1));
  }
}

// Answer
// 2016-02-20T10:30:45.000000200+09:00[Asia/Tokyo]
// 2016-02-20T10:30:45.000000200-08:00[America/Los_Angeles] 
// 2016年2月20日 10時30分45秒 JST

// 時差とは協定世界時（UTC）からの時刻の差を表します（UTC Offset）。
// 日本時間は協定世界時から9時間進んでいるため「+09:00」となります。
// 米国西海岸は、協定世界時から8時間遅れているので「-08:00」となります。
// ただし、米国では夏時間があるため、その期間中は7時間の遅れとなり「-07:00」となります。

//・タイムゾーンを含んだ日付/時刻クラスとしてZonedDateTimeが提供されています。
//・時差を含んだ日付/時刻クラスとして、OffsetDateTimeが提供されています。
//まず、ZonedDateTimeクラスから説明します。

//主なタイムゾーンID
//地域	タイムゾーンID
//JST	日本標準時	Asia/Tokyo
//PST	米国西海岸標準時	America/Los_Angeles

//ZoneId クラスの主なメソッド
//メソッド名 	説明
//static ZoneId systemDefault()	システム・デフォルト・タイムゾーンを表すZoneId オブジェクトを取得する
//static ZoneId of(String zoneId)	指定されたID からZoneId オブジェクトを取得する

//ZonedDateTime クラスの主なメソッド
//メソッド名	説明
//	static ZonedDateTime of(
//	            int year,
//	            int month,
//	            int dayOfMonth,
//	            int hour,
//	            int minute,
//	            int second,
//	            int nanoOfSecond,
//	            ZoneId zone)	
// 年、月、日、時、分、秒、ナノ秒、タイムゾーンからZonedDatTime オブジェクトを取得する
//	static ZonedDateTime of(
//	            LocalDateTime localDateTime,
//	            ZoneId zone)	
// LocalDateTime とタイムゾーンをもとにZonedDateTimeオブジェクトを取得する