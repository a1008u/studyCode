package JavaSE8.type8;

import java.io.*;

public class Sample8_2 {
  public static void main(String[] args) {
	  
	// ストリームとは
	// プログラムからファイルへのデータの書き出しや、逆にファイルからプログラムへのデータの読み込みが発生していることになります。
	// このようなデータの送受信を連続的に行うものをストリーム（データの流れという意味）といいます。

	//ストリームの種類
	//　・入力ストリームと出力ストリーム
	//　　入力ストリームはデータを読み込むときに使用します。
	//   出力ストリームはデータを書き出すときに使用します。
	//   
	//　・バイトストリームとキャラクタストリーム
	//　　- バイトストリームはbyte単位でデータを読み書きするストリーム
	//   - キャラクタストリームはchar単位でデータを読み書きするストリームで

	//	　　　　　　　　バイトストリーム(byte 単位で読み書き)	キャラクタストリーム(char 単位で読み書き)
	// 出力ストリーム	OutputStream	　　　　　　　　　　Writer
	// 入力ストリーム	InputStream	　　　　　　　　　　　　 Reader  
	  
	// FileInputStreamクラスおよびFileOutputStreamクラス：byte単位でファイルの入出力を行うストリーム
	// Fileオブジェクトやファイルパス文字列をもとに、
	// ファイル内に記述されたデータをbyte単位で入出力します 
	  
    FileOutputStream fos = null;
    FileInputStream fis = null;
    
    try {
      fos = new FileOutputStream(new File("src/type8/ren/8_2.txt"));
      
	   // void write(int b) throws IOException	
       // 	引数で指定されたバイトデータをファイル出力ストリームに書き出す
	   // void write(byte[] b) throws IOException	
      // 	引数で指定されたバイト配列をファイル出力ストリームに書き出す
      fos.write(0); 
      fos.write("suzuki".getBytes()); 
      fos.write(99);
      
      fis = new FileInputStream(new File("src/type8/ren/8_2.txt"));
      
      // int read() throws IOException	
      //  入力ストリームからバイトデータを読み込む。ファイルの終わりに達すると-1を返す
      int data = 0;
      while ((data = fis.read()) != -1) {
    	// 読み込んだデータの表示
        System.out.print(data + " ");   
      }
    } catch (FileNotFoundException e){
      System.err.println(" ファイルがありません");
    } catch (IOException e) {
      System.err.println("IO Error");
    } finally {
      try { fos.close(); fis.close(); } catch(IOException e){}
    }
  }
}

// Answer
// 0 115 117 122 117 107 105 99


// ファイルの読み取り方法--------------------------------------------------------------
//主なバイトストリーム
// クラス名	説明
// FileInputStream	ファイルからbyte単位の読み込みを行うストリーム
// FileOutputStream	ファイルからbyte単位の書き出しを行うストリーム
// DataInputStream	基本データ型のデータを読み込めるストリーム
// DataOutputStream	基本データ型のデータを書き出せるストリーム

//主なキャラクタストリーム
// クラス名	説明
// FileReader	ファイルからchar 単位の読み込みを行うストリーム
// FileWriter	ファイルからchar 単位の書き出しを行うストリーム
// BufferedReader	char 単位で、文字、配列、行をバッファリングしながら読み込むストリーム
// BufferedWriter	char 単位で、文字、配列、行をバッファリングしながら書き出すストリーム
// ----------------------------------------------------------------------------------

// FileInputStream クラスとFileOutputStream クラスの主なコンストラクタとメソッド
// コンストラクタ名	説明
// FileInputStream(File file)throws FileNotFoundException	
//  引数で指定されたFile オブジェクトからデータを読み込むための、入力ストリームを作成
// FileInputStream(String name) throws FileNotFoundException	
//  引数で指定されたファイルからデータを読み込むための、入力ストリームを作成
// FileOutputStream(File file)throws FileNotFoundException	
//  引数で指定されたFile オブジェクトへデータを書き出すための、出力ストリームを作成
// FileOutputStream(String name)throws FileNotFoundException	
//  引数で指定されたファイルへデータを書き出すための、出力ストリームを作成

// メソッド名	説明
// int read() throws IOException	入力ストリームからバイトデータを読み込む。ファイルの終わりに達すると -1 を返す
// void close() throws IOException	このストリームを閉じる
// void write(int b) throws IOException	引数で指定されたバイトデータをファイル出力ストリームに書き出す
// void write(byte[] b) throws IOException	引数で指定されたバイト配列をファイル出力ストリームに書き出す
// void close() throws IOException	このストリームを閉じる