package JavaSE8.type12;

import java.util.ResourceBundle;
import java.util.Locale;

public class Sample12_7 {
  public static void main(String[] args) {
    ResourceBundle obj
          = ResourceBundle.getBundle("MyResources3", new Locale("en", "US"));
    System.out.println("data : " + obj.getString("data"));
  }
}

/*
	Answer
		data : MyResources3_en_US.properties
*/

/*
	リソースバンドルの検索
		リソースバンドルの実装には、
		クラスファイルを使用する方法（ListResourceBundle クラスの利用）と
		プロパティファイルを使用する方法がありました。
		これらは混在させることも可能です。
		リソースバンドルは検索する順番が規定されているため、
		内容が重複していたとしても、
		先に見つかったリソースバンドルが使用されるしくみになっています。
		ロケールに対応した適切なリソースバンドルが読み込めない場合は、MissingResourceException例外が発生します。
		
	リソースバンドルの検索の優先度は次のとおりです。
		1 　言語コード、国コードが一致するクラスファイル　
		2 　言語コード、国コードが一致するプロパティファイル　
		3 　言語コードが一致するクラスファイル　
		4 　言語コードが一致するプロパティファイル　
		5 　デフォルトロケール用のクラスファイル　
		6 　デフォルトロケール用のプロパティファイル
*/


