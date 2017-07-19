package JavaSE8.type12;

import java.time.*;
import java.time.format.*;

public class Sample12_13 {
  public static void main(String[] args) {
    LocalTime time = LocalTime.parse("06:15"); 
    System.out.println(time);
    
    DateTimeFormatter fmt = 
             DateTimeFormatter.ofPattern("yyyy MM dd");
    String target = "2016 03 31";
    // parse()メソッドの引数には
    // 有効な日付/ 時刻（日付はハイフン（-）で区切る、時刻はコロン（:）で区切るなど）を指定しなければいけません。
    LocalDate date = LocalDate.parse(target, fmt);
    System.out.println(date);
  }
}
/*
Answer
	06:15
	2016-03-31
*/

/*
ofPattern()とparse()メソッド

ofPattern()メソッドは引数に任意パターン文字列を指定しフォーマッタを作成します。
パターンは、A～ Z、a ～ z および記号で表現されたパターン文字を組み合わせて作成します。
主なパターン文字
文字	説明	文字	説明
G	紀元、西暦	h	午前/ 午後の時 (1 - 12)
y	年	H	一日における時 (0 - 23)
M	月	m	分
d	月における日	s	秒
E	曜日の名前	SS	ミリ秒
a	午前/ 午後	z	タイムゾーン

d.MM.yy	
	8.08.13	
	8.08.13
yyyy.MM.dd G 'at' hh:mm:ss z	
	2013.08.08 AD at 06:04:33 PST	
	2013.08.08 西暦 at 06:04:33 JST
EEE, MMM d, ''yy	
	Thu, Aug 8, '13	
	木, 8 8, '13
H:mm	
	18:04	
	18:04
H:mm:ss:SSS	
	18:04:33:056	
	18:04:33:056
K:mm a,z	
	6:04 PM,PST	
	6:04 午後,JST
*/