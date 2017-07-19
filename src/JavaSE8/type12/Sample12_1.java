package JavaSE8.type12;

import java.util.Locale;

public class Sample12_1 {
	  public static void main(String[] args) {
		// 日本
	    // static Locale getDefault()	
		//	実行中のJava実行環境のデフォルトロケールを返す
		// final String getDisplayCountry()	
		// 	ロケールオブジェクトがもつ国名を返す
		// final String getDisplayLanguage()	
		// 	ロケールオブジェクトがもつ言語名を返す
	    Locale japan = Locale.getDefault(); 
	    System.out.println(japan.getDisplayCountry() + " : " +
	                       japan.getDisplayLanguage());
	    // 米国
	    // Locale(String language, String country)	
		//  引数で指定された言語コード、国コードからロケールオブジェクトを生成する
	    Locale us = new Locale("en", "US"); 
	    
	    //Locale us = Locale.US; // 米国
	    System.out.println(us.getDisplayCountry() + " : " +
	                       us.getDisplayLanguage());
	    // String getDisplayCountry(Locale inLocale)	
		//  引数で指定したロケールの表示で国名を返す
		// String getDisplayLanguage(Locale inLocale)	
		//  引数で指定したロケールの表示で言語名を返す
	    System.out.println(us.getDisplayCountry(us) + " : " +
	                       us.getDisplayLanguage(us));
	    // String getCountry()	
		//  ロケールオブジェクトがもつ国コードを返す
		// String getLanguage()	
		//  ロケールオブジェクトがもつ言語コードを返す
	    System.out.println(us.getCountry() + " : " +
	                       us.getLanguage());
	    
	    Locale lb = new Locale.Builder().setLanguage("ja")
	                                    .setScript("Jpan")
	                                    .setRegion("JP")
	                                    .build();
	    
	    System.out.println(lb.getCountry() + " : " +
	                       lb.getLanguage());
	  }
	}
/*
	Answer
		日本 : 日本語
		アメリカ合衆国 : 英語
		United States : English
		US : en
		JP : ja
*/

/*ロケールとは、国や言語などで分けた「地域」を表す情報です。
 * プログラムを実行する地域によって表示を変えたい場合などに使用します。
 * ロケールは、java.util.Locale クラスのオブジェクト（ロケールオブジェクト）で表します。
 * ロケールオブジェクトはnewを使用してインスタンス化する以外に、Localeクラスの定数やgetDefault()メソッドからも取得できます。
 */

/*
Locale クラスの主なコンストラクタ・メソッド・定数
コンストラクタ	説明
Locale(String language)	
	引数で指定された言語コードからロケールオブジェクトを生成する
Locale(String language, String country)	
	引数で指定された言語コード、国コードからロケールオブジェクトを生成する
	
メソッド名	説明
static Locale getDefault()	
	実行中のJava実行環境のデフォルトロケールを返す
static void setDefault(Locale newLocale)	
	引数で指定したロケールをデフォルトロケールとして設定する
final String getDisplayCountry()	
	ロケールオブジェクトがもつ国名を返す
String getDisplayCountry(Locale inLocale)	
	引数で指定したロケールの表示で国名を返す
String getCountry()	
	ロケールオブジェクトがもつ国コードを返す
final String getDisplayLanguage()	
	ロケールオブジェクトがもつ言語名を返す
String getDisplayLanguage(Locale inLocale)	
	引数で指定したロケールの表示で言語名を返す
String getLanguage()	
	ロケールオブジェクトがもつ言語コードを返す
	
定数	説明
static final Locale US	米国を表すロケールオブジェクト
static final Locale JAPAN	日本国を表すロケールオブジェクト
static final Locale FRANCE	フランスを表すロケールオブジェクト
 */

/*

*/