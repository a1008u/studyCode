package JavaSE8.type12;

import java.util.Locale;
import java.text.NumberFormat;

public class Sample12_8 {
  public static void main(String[] args) {
	
	/*
    static final NumberFormat getInstance()	
		現在のデフォルトロケールに対応した、数値用フォーマット形式をもつNumberFormatオブジェクトを返す
	static NumberFormat getInstance(Locale inLocale)	
		引数で指定したロケールに対応した、数値用フォーマット形式をもつNumberFormatオブジェクトを返す
	static NumberFormat getCurrencyInstance(Locale inLocale)	
		引数で指定したロケールに対応した通貨用フォーマット形式をもつNumberFormatオブジェクトを返す  
	*/  
	  
	// 日本
    NumberFormat jpNum = NumberFormat.getInstance(); 
    NumberFormat jpCur = NumberFormat.getCurrencyInstance();
    System.out.println("日本の数値 : " + jpNum.format(50000));
    System.out.println("日本の通貨 : " + jpCur.format(50000));
    
    // 米国
    NumberFormat usNum = NumberFormat.getInstance(Locale.US); 
    NumberFormat usCur = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.println("米国の数値 : " + usNum.format(50000));
    System.out.println("米国の通貨 : " + usCur.format(50000));
  }
}

/*
	Answer
		日本の数値 : 50,000
		日本の通貨 : ￥50,000
		米国の数値 : 50,000
		米国の通貨 : $50,000.00
*/

/*
フォーマットとは
扱うデータによっては、格納している形式と表示形式を変えたい場合があります。
たとえば、「1000」という値を格納しているデータを「¥1,000」と表示したいといった場合です。
このような処理をフォーマット（書式化）と呼びます。

主なフォーマット処理用クラス
カテゴリ	クラス名
数値および通貨	
	NumberFormat
	DecimalFormat
	DecimalFormatSymbols
日付および時刻	
	DateFormat
	SimpleDateFormat
	DateFormatSymbols
テキストメッセージ	
	MessageFormat
	ChoiceFormat
数値、通貨、日付、時刻、およびテキストメッセージをフォーマットするために使用される主なクラスです。
java.text パッケージで提供されています。

数値および通貨をフォーマットするには、 java.text.NumberFormatクラスを使用します。
NumberFormatクラスは抽象クラスであるため、newによるインスタンス化はできません。
NumberFormatクラスで提供されているstaticメソッドを使用して、特定のロケールに対応したNumberFormatオブジェクトを取得します。

NumberFormat オブジェクト取得用メソッド
メソッド名	説明
static final NumberFormat getInstance()	
	現在のデフォルトロケールに対応した、数値用フォーマット形式をもつNumberFormat オブジェクトを返す
static NumberFormat getInstance(Locale inLocale)	
	引数で指定したロケールに対応した、数値用フォーマット形式をもつNumberFormat オブジェクトを返す
static NumberFormat getCurrencyInstance(Locale inLocale)	
	引数で指定したロケールに対応した通貨用フォーマット形式をもつNumberFormat オブジェクトを返す
static NumberFormat getIntegerInstance(Locale inLocale)	
	引数で指定したロケールに対応した整数型数値フォーマット形式をもつNumberFormat オブジェクトを返す
Number parse(String source) throws ParseException	
	引数で指定された文字列を解析して数値を生成する
取得したNumberFormatオブジェクトを使って数値や通貨をフォーマットするにはformat()メソッドを使用します。
NumberFormat クラスのメソッド
メソッド名	説明
final String format(double number)	引数で指定された数値をフォーマットする
final String format(long number)	引数で指定された数値をフォーマットする
*/