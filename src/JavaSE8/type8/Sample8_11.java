package JavaSE8.type8;

import java.io.*;

public class Sample8_11 {
  public static void main(String[] args) {
	  
	// JavaSE6からjava.io.Consoleクラスが提供されています。
	// Consoleオブジェクトを使用することで、コンソール上での入力（標準入力）、出力（標準出力）を扱えます。
	// Consoleクラスのコンストラクタはprivate指定されているため、newによるインスタンス化はできません。
	// Console オブジェクトはSystemクラスのconsole()メソッドで取得します。  
	  
    Console console = System.console();
    PrintWriter pw = console.writer();
    
    while (true) {
      //String readLine()	
      //    	コンソールから単一行のテキストを読み込む
      String str = console.readLine();
      if (str.equals("")) { break; }
      pw.append(" 入力されたデータ : " + str + "\n");
      pw.write(" 入力されたデータ : " + str + '\n');
      pw.flush();
    }
    
  }
}

// Answer
// 入力されたデータ : aaa ← aaaとコンソール上で入力
// 入力されたデータ : bbb ← bbbとコンソール上で入力

// コンソール・デバイスが利用できない場合、console()メソッドはnullを返します。

//Console クラスの主なメソッド
//メソッド名	説明
//PrintWriter writer()	PrintWriter オブジェクトを取得する
//Console format(String fmt, ... args)	
//	指定された書式文字列および引数を使用して、書式付き文字列をこのコンソールの出力ストリームに書き出す
//Console printf(String format, Object... args)	
//	指定された書式文字列および引数を使用して、書式付き文字列をこのコンソールの出力ストリームに書き出す
//String readLine()	
//	コンソールから単一行のテキストを読み込む
//String readLine(String fmt,	Object... args)	
//	書式設定されたプロンプトを提供し、次にコンソールから単一行のテキストを読み込む
//char[] readPassword()	
//	エコーを無効にしたコンソールからパスワードまたはパスフレーズを読み込む
//char[] readPassword(String fmt,	Object... args)	
//	書式設定されたプロンプトを提供し、次にエコーを無効にしたコンソールからパスワードまたはパスフレーズを読み込む