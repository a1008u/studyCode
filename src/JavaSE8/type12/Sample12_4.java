package JavaSE8.type12;

import java.util.*;

public class Sample12_4 {
  public static void main(String[] args) {
	// デフォルト（日本）
    Locale japan = Locale.getDefault(); 
    // 米国
    Locale us = new Locale("en", "US"); 
    Locale[] locArray = {us, japan};
    
    for(Locale locale : locArray) {
    	
        // static final ResourceBundle getBundle(String baseName, Locale locale)	
        // 	引数で指定された名前と、引数で指定されたロケール、および呼び出し側のクラスローダーを使用して、リソースバンドルを取得する	    	
      ResourceBundle obj1
            = ResourceBundle.getBundle("MResources", locale);
      
      System.out.println("send : " + obj1.getString("send"));
      System.out.println("cancel : " + obj1.getString("cancel"));
    }
  }
}

/* Answer
 * send : P_send
 * cancel : P_cancel
 * send : P_送信
 * cancel : P_取消
 */

/*
PropertyResourceBundleクラスの利用
ListResourceBundleクラスがリソースバンドルをクラスファイルで用意するのに対し、
PropertyResourceBundleクラスではリソースバンドルを、テキスト形式のプロパティファイルで用意します。
プロパティファイルの作成ルールは次のとおりです。

● プロパティファイル名は、ListResourceBundleクラスと同様に、基底名、言語コード、国コードの組み合わせとする
●　拡張子は .propertiesとする
●　リソースであるキーと値のペアは、プロパティファイル内に「キー= 値」の形式で列記する

なお、PropertyResourceBundleクラスによるリソースバンドルの使用では、サブクラス化は必要ありません。
プロパティファイルを作成するだけです。
次のプロパティファイルは、ListResourceBundle クラスの例で使ったボタン名のリソースバンドルと同じ内容のものです。
ただし、キーに対する各値に「P_」を付与しています。
デフォルトロケール用のプロパティファイルとしてMyResources.properties、
米国用のプロパティファイルとしてMyResources_en_US.properties を作成しています。
*/