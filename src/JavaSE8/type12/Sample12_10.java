package JavaSE8.type12;

import java.text.DecimalFormat;

public class Sample12_10 {
  public static void main(String[] args) {
	  
    customFormat("###,###.###"       ,123456.789);
    customFormat("###.##"            ,123456.789);
    customFormat("000000.000"        ,123.78);
    customFormat("$###,###.###"      ,12345.67);
    customFormat("\u00a5###,###.###" ,12345.67);
  }
  
  static public void customFormat(String pattern, double value ) {
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String fData = myFormatter.format(value);
    System.out.println(fData);
  }
}

/*
Answer
	123,456.789
	123456.79
	000123.780
	$12,345.67
	¥12,345.67
*/

/*
DecimalFormatクラスは、指定したパターンで数値を自由にフォーマットすることができます。
パターンは、基本的には0や#などのパターン文字を組み合わせて作成します。
主なパターン文字
記号	説明
0	数字
#	数字。ゼロだと表示されない
.	数値桁区切り文字、または通貨桁区切り文字
-	マイナス記号
,	カンマ区切り文字
%	100 倍してパーセントを表す
¥u00a5	通貨記号で置換される通貨符号
*/