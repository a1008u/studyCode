package JavaSE8.type8;

import java.io.*;

public class Sample8_1 {
  public static void main(String[] args){
	  
	// java.io.Fileクラスは、ディスクに保存されているファイルやディレクトリをオブジェクトとして表現するクラスです。
	// 具体的には、ファイル名やパス名の獲得、ファイルの有無など、特定のファイルに関する情報を獲得するために使います。
	// 
	// Fileクラスを使うには、どのディレクトリの何という名前のファイルを扱いたいのかを表現するために、パス名が必要になります。
	// Fileクラスの実行
	// ・パス名を入力するためのコンストラクタ
	// ・Fileオブジェクトをもとに、メソッドを使用してファイルシステム内のファイルに対する各種処理を実行  
	  
	// File(String pathname)	
	//		指定されたパス名文字列を抽象パス名に変換して、Fileオブジェクトを生成  
    File f1 = new File("src/type8/ren/dir");
    System.out.println(f1.getParent());
    
	// File(String parent, String child)	
	// 	親パス名文字列および子パス名文字列からFile オブジェクトを生成
    File f2 = new File("ren", "a.txt");
    
	// File(File parent, String child)	
	// 	親抽象パス名および子パス名文字列からFileオブジェクトを生成
    File f3 = new File(f1, "x.txt");
    
    // File[] listFiles()	
    //  この抽象パス名が示すディレクトリ内のファイル、ディレクトリをFile配列として返す
    for(File f : f1.listFiles()) {
      if(f.isFile()) {
        System.out.println("ファイル     :" + f.getName());
      }else if (f.isDirectory()){
        System.out.println("ディレクトリ :" + f.getName());
      }
    }
    
    // String getAbsolutePath()	
    // この抽象パス名の絶対パス名文字列を返す
    System.out.println("path for f1  :" + f1.getAbsolutePath());
    System.out.println("path for f2  :" + f2.getAbsolutePath());
    System.out.println("path for f3  :" + f3.getAbsolutePath());
    
    System.out.println("使用しているパスの区切り文字 " + System.getProperty("file.separator"));
  }
}

// Answer
// src/type8/ren
// ファイル     :.DS_Store
// ディレクトリ :java
// ファイル     :x.txt
// ファイル     :y.txt
// path for f1  :/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type8/ren/dir
// path for f2  :/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/ren/a.txt
// path for f3  :/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type8/ren/dir/x.txt
// 使用しているパスの区切り文字 /

// File クラスの主なコンストラクタとメソッド
// コンストラクタ名	説明
// File(String pathname)	
//	指定されたパス名文字列を抽象パス名に変換して、File オブジェクトを生成
// File(String parent, String child)	
//	親パス名文字列および子パス名文字列からFile オブジェクトを生成
// File(File parent, String child)	
//	親抽象パス名および子パス名文字列からFile オブジェクトを生成

// メソッド名	説明
// boolean createNewFile() throws IOException	この抽象パス名が示す空の新しいファイルを作成する
// File[] listFiles()	この抽象パス名が示すディレクトリ内のファイル、ディレクトリをFile配列として返す
// boolean isFile()	この抽象パス名が示すファイルが普通のファイルかどうかを判定する
// boolean isDirectory()	この抽象パス名が示すファイルが普通のディレクトリかどうかを判定する
// boolean delete()	この抽象パス名が示すファイルまたはディレクトリを削除する
// boolean mkdir()	この抽象パス名が示すディレクトリを生成する
// boolean mkdirs()	この抽象パス名が示すディレクトリを生成する。必要な存在していない親ディレクトリがあれれば一緒に生成する
// boolean renameTo(File dest)	この抽象パス名が示すファイルの名前を変更する
// String getAbsolutePath()	この抽象パス名の絶対パス名文字列を返す
// String getName()	この抽象パス名が示すファイルまたはディレクトリの名前を返す