package JavaSE8.type8;

import java.util.Formatter;

public class Sample8_13 {
  public static void main(String[] args) {
	  
	//	format(<フォーマット指示子>, <引数>)
	//	 第1引数である< フォーマット指示子> は書式化を行うための指示を与え、
	//	 第2引数である< 引数> は書式化されるデータを指定します。
	
	//	-フォーマット指示-
	//	 %[インデックス $][フラグ][幅][.精度] 変数の種類
	//	 インデックス：%の後に、数字$を記述すると置換引数を明示的に指定可能
	//	 フラグ：+ 符号を出力, 0 空きを0で埋める 、数値を桁ごとに「,」で区切る。ロケールに依存
	//	 幅：出力時の最小文字数
	//	 .精度：精度。出力に書き込まれる最大文字数
	//	 変数の種類：b(Boolean値),c(文字),d(整数),f(浮動小数点数),s(文字列),n(区切り文字)  
		  
    String compName = "SE社" ;
    String name = "tanaka";
    int age = 20;
    Formatter fm = new Formatter(); // Formatter()	新しいフォーマッタを生成する
    
    // Formatter format(String format, Object... args)	
    //  第１引数に書式化パターンを指定し、書式化したい値を第2引数で指定し、フォーマッタに書き出す
	fm.format("会社名は %s です。\n", compName);
    fm.format("名前 : %2$s : 年齢 : %1$d \n", age, name);
    System.out.println(fm);
    
    // PrintWriter printf(String format, Object... args)
    //  第１引数に書式化パターンを指定し、書式化したい値を第2引数で指定し、フォーマッタに書き出す
    System.out.format("会社名は %s です。\n", compName);
    System.out.printf("名前 : %2$s : 年齢 : %1$d \n", age, name);
  }
}

// Answer
//  会社名は SE社 です。
//  名前 : tanaka : 年齢 : 20 
//
//  会社名は SE社 です。
//  名前 : tanaka : 年齢 : 20 



//ストリームの書式化
//何かしらのデータを出力する際に書式を整えたい場合があります。
//たとえば、「桁数を10 桁に合わせたい。その際足りない桁は0で埋めたい」や「出力用のテンプレートのみ用意しておいて，実際の値は後から挿入したい」といった場合です。
//Java 言語では入出力ストリームのフォーマットを行うためのAPIが提供されています。　
//java.util.Formatter、java.io.PrintWriter、java.lang.String の各クラスのformat()メソッドを使えば、数値や文字列を書式化できます。
//このメソッドはこれら3つのクラスで同じように機能します。
//format()メソッドを使って入力データを書式化した後は、書式化された出力をFormatterクラスやPrintWriterクラスを使って、ファイルなどの入出力デバイスに流すことができます。
//Formatterクラスは、数値、文字列、一般的なデータ型、日付や時刻のデータなどを書式化するフォーマッタを生成します。
//このフォーマッタはロケール固有の出力もサポートしています。

// Formatter クラスの主なコンストラクタとメソッド
// コンストラクタ名	 説明
// Formatter()	新しいフォーマッタを生成する
// Formatter(Locale l)	指定されたロケールをもつ新しいフォーマッタを生成する
// Formatter(File file) throws FileNotFoundException	
//  指定されたファイルをもつ新しいフォーマッタを生成する
// Formatter(PrintStream ps)	
//  指定された出力ストリームをもつ新しいフォーマッタを生成する
// Formatter(OutputStream os)	
//  指定された出力ストリームをもつ新しいフォーマッタを生成する

// メソッド名	 説明
// void flush()	このフォーマッタをフラッシュする
// void close()	このフォーマッタを閉じる
// Formatter format(String format, Object... args)	
//  第１引数に書式化パターンを指定し、書式化したい 値を第2 引数で指定し、フォーマッタに書き出す
// String toString()	フォーマッタの中身をString オブジェクトで返す
// PrintWriter クラスのformat() メソッドとprintf() メソッドの主なメソッド
//メソッド名	説明
// PrintWriter format(String format, Object... args)	
//  第1引数に書式化パターンを指定し、書式化したい値を第2引数で指定し、このライターに書き出す
// PrintWriter printf(String format, Object... args)	上と同じ

