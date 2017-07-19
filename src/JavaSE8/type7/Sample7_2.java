package JavaSE8.type7;

import java.time.LocalDate;

public class Sample7_2 {
  public static void main(String[] args) {
	 
	// static LocalDate now()	現在の日付からLocalDate オブジェクトを取得する
    LocalDate dateNow = LocalDate.now();
    
    // static LocalDate of(
    //  int year,
    //  int month,
    //  int dayOfMonth)	年、月、日からLocalDate オブジェクトを取得する
    LocalDate dateOf = LocalDate.of(2016, 02, 24);
    //LocalDate dateOf = LocalDate.of(2016, 2, 24);   //OK
    
    // static LocalDate parse(CharSequence text)	
    // 2007-12-03 などのテキスト文字列からLocalDateオブジェクトを取得する
    LocalDate dateP = LocalDate.parse("2016-02-24");
    //LocalDate dateP = LocalDate.parse("2016-2-24");  //実行時エラー
    
    System.out.println("LocalDate.now       : " + dateNow);
    System.out.println("LocalDate.of        : " + dateOf);
    System.out.println("LocalDate.parse     : " + dateP);
  }
}

// Answer
// LocalDate.now       : 2017-02-18
// LocalDate.of        : 2016-02-24
// LocalDate.parse     : 2016-02-24

// 日付・時刻の各クラスのコンストラクタはprivate修飾子が付与されているため、newによるインスタンス化はできません。
// その代わりに、各クラスに共通で用意されているstaticメソッドを使用してオブジェクトを生成します。
// ここでは、LocalDateクラスのメソッドを掲載します。
//
// オブジェクト生成のためのメソッド
// メソッド名 	説明
// static LocalDate now()	現在の日付からLocalDate オブジェクトを取得する
// static LocalDate of(
//        int year,
//        int month,
//        int dayOfMonth)	年、月、日からLocalDate オブジェクトを取得する
// static LocalDate parse(CharSequence text)	2007-12-03 などのテキスト文字列からLocalDateオブジェクトを取得する