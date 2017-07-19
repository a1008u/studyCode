package JavaSE8.type8;

import java.io.*;

public class Sample8_5 {
  public static void main(String[] args) {
	  
	// FileReaderクラスとFileWriterクラス
	//  FileReaderクラスおよびFileWriterクラスは、キャラクタストリームに属するクラスで、
	//  char単位で読み書きを行い、入出力データの文字コードは自動的に変換されます。
	//  Java言語は、1文字をUnicode（16ビットデータ）として扱っています。
	//  キャラクタストリームを使用すると、Javaのプログラムからファイルが保存されているOSの文字コードを意識することなく入出力を行えます。  
	 
	// FileReader(File file) throws FileNotFoundException	
    //		 引数で指定されたFileオブジェクトからデータを読み込むための、FileReader オブジェクトを作成
	// FileWriter(File file) throws IOException	
    //		 引数で指定されたFile オブジェクトへデータを書き出すための、FileWriter オブジェクトを作成
    try (FileWriter fw = new FileWriter(new File("src/type8/ren/8_5.txt"));
         FileReader fr = new FileReader(new File("src/type8/ren/8_5.txt"))){
    	
    	// void write(String str) throws IOException	
		//   	 引数で指定された文字列を書き出す（このメソッドはスーパークラスであるWriterクラスのメソッド）
		// void flush() throws IOException	
		//   	 目的の送信先に、ただちに文字を書き出す（このメソッドはスーパークラスであるOutputStreamWriter クラスのメソッド）
	    fw.write("田中");
	    fw.flush();
	    
	    int i = 0;
		while ((i = fr.read()) != -1) {
			System.out.print((char)i +" - ");
	    }
      
    } catch (IOException e) { e.printStackTrace(); }
  }
}

// Answer
// 田 - 中 - 

// FileReader クラスとFileWriter クラスの主なコンストラクタとメソッド
// コンストラクタ名	説明
// FileReader(File file) throws FileNotFoundException	
//	 引数で指定されたFileオブジェクトからデータを読み込むための、FileReader オブジェクトを作成
// FileReader(String fileName) throws FileNotFoundException	
//	 引数で指定されたファイルからデータを読み込むための、FileReader オブジェクトを作成
// FileWriter(File file) throws IOException	
//	 引数で指定されたFile オブジェクトへデータを書き出すための、FileWriter オブジェクトを作成
// FileWriter(String fileName) throws IOException	
//	 引数で指定されたファイルへデータを書き出すための、FileWriter オブジェクトを作成
//
//	メソッド名	説明
// int read() throws IOException	
//	 ストリームから 単一文字を読み込む。ファイルの終わりに達すると-1を返す。
//	 （ このメソッドはスーパークラスであるInputStreamReader クラスのメソッド）
// void write(String str) throws IOException	
//	 引数で指定された文字列を書き出す（このメソッドはスーパークラスであるWriter クラスのメソッド）
// void flush() throws IOException	
//	 目的の送信先に、ただちに文字を書き出す（このメソッドはスーパークラスであるOutputStreamWriter クラスのメソッド）

// もしすでにファイルにデータが存在しており、追記で書き込みを行いたい場合は以下のコンストラクタを使用します。
//  構文1：FileWriter(File file, boolean append) throws IOException
//  構文2：FileWriter(String fileName, boolean append) throws IOException
// 各コンストラクタの第2 引数にtrueを指定すると追記となります。falseを指定すると先頭から書き込みが行われます。