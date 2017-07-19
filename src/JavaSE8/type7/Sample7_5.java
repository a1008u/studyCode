package JavaSE8.type7;

import java.time.*;
import java.time.format.*;

public class Sample7_5 {
  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE;
    
    System.out.println(dateTime);
    System.out.println(fmt.format(dateTime));
    System.out.println(dateTime.format(fmt));
  }
}

// Answer
// 2017-02-18T14:38:52.354
// 2017-02-18
// 2017-02-18


// DateTimeFormatter クラスの主なフォーマッタ用
// DateTimeFormatter クラスのstatic定数として提供
// 定数	説明	例
// ISO_DATE	オフセット付きまたはオフセットなしの日付に対し、書式設定や解析を行うフォーマッタ	
// 	2011-12-03
// 	2011-12-03+01:00
// ISO_TIME	オフセット付きまたはオフセットなしの時刻に対し、書式設定や解析を行うフォーマッタ	
// 	10:15
// 	10:15:30
// 	10:15:30+01:00 
// ISO_DATE_TIME	オフセット付きまたはオフセットなしの日付／時刻に対し、書式設定や解析を行うフォーマッタ	
// 	2011-12-03T10:15:30
// 	2011-12-03T10:15:30+01:00
