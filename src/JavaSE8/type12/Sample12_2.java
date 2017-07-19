package JavaSE8.type12;

import java.util.ResourceBundle;
import java.util.stream.Stream;
import java.util.Locale;

public class Sample12_2 {
  public static void main(String[] args) {
	// デフォルト（日本）
    Locale japan = Locale.getDefault();
    // 米国
    Locale us = Locale.US;  
    Locale[] locArray = {japan, us};
    
    for(Locale locale : locArray) {
    	
    // static final ResourceBundle getBundle(String baseName, Locale locale)	
    // 	引数で指定された名前と、引数で指定されたロケール、および呼び出し側のクラスローダーを使用して、リソースバンドルを取得する	
      ResourceBundle obj1
            = ResourceBundle.getBundle("com.se.MyResources", locale);
      
        System.out.println("send   : " + obj1.getString("send"));
        System.out.println("cancel : " + obj1.getString("cancel"));
    }
    
    ResourceBundle obj2
            = ResourceBundle.getBundle("com.se.MyResources");
    System.out.println("検証用 : " + obj2.getString("send"));
  }
}

/* Answer
 * send   : 送信
 * cancel : 取消
 * send   : send
 * cancel : cancel
 * 検証用 : 送信
 * */

/*
	リソースバンドルとは
		アプリケーションのユーザインタフェースにおいて、
		ロケールがUSの場合は英語で、JPの場合は日本語で、と自動的に表示を切り替えたい場合があります。
		このようなアプリケーションの国際化を実現するには、リソースバンドルを使用します。
		リソースバンドルはロケール固有のリソース（メニューに表示する文字列など）の集合です。
		アプリケーションはユーザのロケールに合致するリソースを、リソースバンドルから取得します。
*/
/*
ListResourceBundleクラスとPropertyResourceBundleクラス
クラス名	説明
ListResourceBundle	リソースバンドルをリソースのリストとして管理するクラス
PropertyResourceBundle	リソースバンドルをプロパティファイルで管理するクラス

ListResourceBundleクラスの利用
ListResourceBundleクラスは、リソースバンドルをクラスとして定義します。
定義のルールは次のとおりです。

●　ListResourceBundleクラスを継承したpublicなクラスを作成する
●　getContents() メソッドをオーバーライドし、配列でリソースのリストを作成する
●　リソースは、キーと値を要素とする配列として作成する

getContents() メソッド
メソッド名	説明
protected abstract Object[][] getContents()	
	各リソース（キーと値のペア）をObject 型の配列にして返す
戻り値の型がObject型の2次元配列になっているのは、
getContents() メソッドが内部でリソースバンドルを配列
（キーと値のペア＝リソース）の配列（リソースのリスト）として保持し、
それを戻り値としているためです。
*/

/*
getBundle() メソッド
メソッド名	説明
static final ResourceBundle getBundle(String baseName)	
	引数で指定された名前、デフォルトのロケール、および呼び出し側のクラスローダーを使用して、リソースバンドルを取得する
static final ResourceBundle getBundle(String baseName, Locale locale)	
	引数で指定された名前と、引数で指定されたロケール、および呼び出し側のクラスローダーを使用して、リソースバンドルを取得する

引数のbaseNameは、リソースバンドルの基底名を文字列で指定します。
リソースバンドルをパッケージ化している場合は「パッケージ名. 基底名」と指定します。
取得したリソースバンドルオブジェクトに格納されているキーや値を取り出すにはResourceBundleクラスの検索用メソッドを使用します。

リソースバンドル内の検索用メソッド
メソッド名	説明
boolean containsKey(String key)	
	引数で指定されたキーがこのリソースバンドルに含まれる場合は true、それ以外の場合はfalseを返す
final Object getObject(String key)	
	引数で指定されたキーに格納されたオブジェクトを返す
final String getString(String key)	
	引数で指定されたキーに格納された文字列を返す
final String[] getStringArray(String key)	
	引数で指定されたキーに格納された文字列の配列を返す
Set<String> keySet()	
	このリソースバンドルに含まれるすべてのキーをSet 型で返す
*/