package JavaSE8.type7;

import java.io.Serializable;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class Sample7_1 {
  public static void main(String[] args) {
    System.out.println(LocalDate.now());
    System.out.println(LocalTime.now());
    System.out.println(LocalDateTime.now());
    System.out.println(OffsetTime.now());
    System.out.println(OffsetDateTime.now());
  }
}

// Answer
//  2017-02-18 				 	  ① 日付	    YYYY-MM-DD	2016-02-24
//  14:16:08.592 			 	  ② 時刻 	hh:mm:ss	11:39:02.441
//  2017-02-18T14:16:08.592  	  ③ 日付・時刻	YYYY-MM-DDThh:mm:ss	2016-02-24T11:39:02.441
//  14:16:08.593+09:00		 	  ④ 時刻+ 時差	hh:mm:ss±hh:mm	11:39:02.441+09:00
//  2017-02-18T14:16:08.593+09:00 ⑤ 日付・時刻+ 時差	YYYY-MM-DDThh:mm:ss±hh:mm	2016-02-24T11:39:02.441+09:00


// Date and Timeの特徴
//  ●　日付、時刻、日付/ 時刻のためのクラスが個別に提供されている
//  ●　Date and Time API の各クラスは不変オブジェクト（イミュータブル）となるため、マルチスレッド環境下でも安全に使用できる
//  ●　日時演算のためのAPI が充実している
// public final class LocalDate　implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable

// 日付/ 時刻 API を提供するパッケージ(5つ)
// パッケージ名	説明
// java.time	日付/ 時刻 API のメインとなるパッケージ
// java.time.temporal	日付/ 時刻 API の追加機能を提供するパッケージ
// java.time.format	日付と時刻の書式化を行うパッケージ
// Java.time.chrono ISO-8601以外のカレンダーシステムを表す
// Java.time.zone タイムゾーンのサポートAPIを提供

//日付・時刻クラス
//クラス名	説明
//LocalDate	ISO 8601 暦体系におけるタイムゾーンのない日付 例）2007-12-03
//LocalTime	ISO 8601 暦体系におけるタイムゾーンのない時刻 例）10:15:30
//LocalDateTime	ISO 8601 暦体系におけるタイムゾーンのない日付/時刻 例）2007-12-03T10:15:30
//OffsetTime	ISO 8601 暦体系におけるUTC/GMT からのオフセット付きの時刻 例）10:15:30+01:00
//OffsetDateTime	ISO 8601 暦体系におけるUTC/GMT からのオフセット付きの日時 例）2007-12-03T10:15:30+01:00
//ZoneOffset	UTC/GMT からのタイムゾーン・オフセット例）+02:00
//ZonedDateTime	ISO 8601 暦体系におけるタイムゾーン付きの日付/ 時刻 例）2007-12-03T10:15:30+01:00 Europe/Paris
//ZoneId	タイムゾーンを特定するID 例）Asia/Tokyo