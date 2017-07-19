package JavaSE8.type8;

import java.io.*;

public class Sample8_4 {
  public static void main(String[] args) {
	  
	// DataInputStreamクラスとDataOutputStreamクラス
	//  DataInputStreamクラスおよびDataOutputStreamクラスは、
	//  int型やfloat型などの基本データ型およびString型のデータを読み書きできるストリームです。
	//  そのため、基本データ型およびString型に対応した読み書き用のメソッドが用意されています。
	//  また、このストリームは単体では使用できないので、他のストリームと連結して使用する必要があります。
	//  具体的には他のストリームをコンストラクタの引数に指定して生成する必要があります  
	  
	//  DataInputStream(InputStream in)	
	//		引数で指定されたInputStreamオブジェクトを使用するDataInputStreamを作成
	//	DataOutputStream(OutputStream out)	
	//		引数で指定されたOutputStreamオブジェクトを使用するDataOutputStreamを作成  
    try (DataOutputStream dos =
            new DataOutputStream(new FileOutputStream("src/type8/ren/8_4.txt"));
         DataInputStream dis =
            new DataInputStream(new FileInputStream("src/type8/ren/8_4.txt"))) {
    	
    	// final void writeInt(int v)throws IOException	
    	//   	 int値を4バイト値として出力ストリームに書き出す。例外がスローされない場合、バイト数は4増加する
    	// final void writeUTF(String str)throws IOException	
    	//   	 引数で指定されたデータをUTF-8エンコーディングを使った形式にして出力ストリームに書き出す
      dos.writeInt(100); dos.writeUTF("tanaka"); dos.writeUTF("田中");
      
      // final int readInt()throws IOException	
      // 	 4バイトの入力データを読み込む。
      //     入力の途中で、予想外のファイルの終了または予想外のストリームの終了があった場合はEOFExceptionがスローされる
      System.out.println(dis.readInt());
      
      // final String readUTF()throws IOException	
      // 	 UTF-8形式でエンコードされた文字列を読み込む。
      //     予想外のファイルの終了または予想外のストリームの終了があった場合はEOFExceptionがスローされる
      System.out.println(dis.readUTF());
      System.out.println(dis.readUTF());
      
    } catch (IOException e) { e.printStackTrace(); }
  }
}

// Answer
// 100
// tanaka
// 田中

// DataInputStreamクラスとDataOutputStreamクラスの主なコンストラクタとメソッド
//  コンストラクタ名	説明
//  DataInputStream(InputStream in)	
//  	引数で指定されたInputStreamオブジェクトを使用するDataInputStreamを作成
//  DataOutputStream(OutputStream out)	
//		引数で指定されたOutputStreamオブジェクトを使用するDataOutputStreamを作成

//   メソッド名	説明
// final int readInt()throws IOException	
//	 4バイトの入力データを読み込む。入力の途中で、予想外のファイルの終了または予想外のストリームの終了があった場合はEOFExceptionがスローされる
// final String readUTF()throws IOException	
//	 UTF-8 形式でエンコードされた文字列を読み込む。予想外のファイルの終了または予想外のストリームの終了があった場合はEOFExceptionがスローされる
// final void writeByte(int v)throws IOException	
//	 byte値を1バイト値として出力ストリームに書き出す。例外がスローされない場合、バイト数は1増加する
// final void writeInt(int v)throws IOException	
//	 int値を4バイト値として出力ストリームに書き出す。例外がスローされない場合、バイト数は4増加する
// final void writeUTF(String str)throws IOException	
//	 引数で指定されたデータをUTF-8 エンコーディングを使った形式にして出力ストリームに書き出す