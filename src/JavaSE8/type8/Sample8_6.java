package JavaSE8.type8;

import java.io.*;

public class Sample8_6 {
  public static void main(String[] args) {
	
	// BufferedReaderクラスとBufferedWriterクラス
	// 	文字列をブロック単位で読み書きするためのストリームを生成します。
	// 	クラス名の一部にあるBufferedとはバッファを表しており、データを一時的にためておくという意味です。
	// 	つまり1文字ずつ入出力するのではなくバッファに文字列をためていき、
	// 	たまった文字列をまとめて読み込んだり、書き出したりすることができます。
	// 	このため、このストリームを使用することで、入出力を効率よく行えます。  
	  
	// BufferedReader(Reader in)	 
	//  引数で指定された入力ストリームからデータを読み込むための、BufferedReaderオブジェクトを作成。
	//  デフォルトサイズのバッファでバッファリングする。
	// BufferedWriter(Writer out)	
	//  引数で指定された出力ストリームへデータを書き出すための、BufferedWriterオブジェクトを作成。
	//  デフォルトサイズのバッファでバッファリングする
    try(BufferedWriter bw =
          new BufferedWriter(new FileWriter("src/type8/ren/8_6.txt"));
        BufferedReader br =
          new BufferedReader(new FileReader("src/type8/ren/8_6.txt"))) {
    	
      // void write(String str) throws IOException	
      //  引数で指定された文字列を書き出す（このメソッドはスーパークラスであるWriterクラスのメソッド）
      // void newLine() throws IOException	
      //  改行文字を書き出す。改行文字は、システムのline.separatorプロパティにより定義
      bw.write("おはよう"); bw.newLine(); bw.write("こんにちは");
      
      // void flush() throws IOException		
      //  目的の書き出し先に、ただちに文字を書き出す
      bw.flush();
      
      // String readLine() throws IOException	
      //  1行のテキストを読み込む。1行の終わりは、改行（「¥n」） か、復帰（「¥r」）、
      // または復行とそれに続く改行のどれかで認識される。終わりに達するとnullを返す
      String data = null;
      while ((data = br.readLine()) != null) {
        System.out.println(data);
      }
    } catch (IOException e) { e.printStackTrace(); }
  }
}

// Answer
// おはよう
// こんにちは



//BufferedReaderクラスとBufferedWriterクラスの主なコンストラクタとメソッド
//コンストラクタ名	説明
// BufferedReader(Reader in)	 
//  引数で指定された入力ストリームからデータを読み込むための、BufferedReader オブジェクトを作成。デフォルトサイズのバッファでバッファリングする
// BufferedReader(Reader in, int sz)	
//  引数で指定された入力ストリームからデータを読み込むための、BufferedReader オブジェクトを作成。引数で指定されたバッファサイズでバッファリングする
// BufferedWriter(Writer out)	
//  引数で指定された出力ストリームへデータを書き出すための、BufferedWriter オブジェクトを作成。デフォルトサイズのバッファでバッファリングする
// BufferedWriter(Writer out, int sz)	
//  引数で指定された出力ストリームへデータを書き出すための、BufferedWriter オブジェクトを作成。引数で指定されたサイズでバッファリングする

// メソッド名	 説明
// int read() throws IOException	
//  ストリームから単一文字を読み込む。ファイルの終わりに達すると-1 を返す
// String readLine() throws IOException	
//  1行のテキストを読み込む。1 行の終わりは、改行（「¥n」） か、復帰（「¥r」）、または復行とそれに続く改行のどれかで認識される。終わりに達するとnull を返す
// void mark(int readAheadLimit)throws IOException	
//  ストリームの現在位置にマークを設定する。引数にはマークを保持しながら読み込むことができる文字数の上限を指定する
// void reset() throws IOException	
//  ストリームを、mark() によりマークされた位置にリセットする
// long skip(long n) throws IOException	
//  引数で指定された文字数をスキップする
// void write(String str) throws IOException	
//  引数で指定された文字列を書き出す（このメソッドはスーパークラスであるWriter クラスのメソッド）
// void newLine() throws IOException	
//  改行文字を書き出す。改行文字は、システムのline.separatorプロパティにより定義
// void flush() throws IOException	
//  目的の書き出し先に、ただちに文字を書き出す