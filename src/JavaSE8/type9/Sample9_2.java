package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_2 {
  public static void main(String[] args) {
	  
	// FileSystemsクラス(ファイルシステム用のファクトリクラス)
    // 　FileSystemsクラスからFileSystemクラスを作成する。
	// FileSystemクラス	
	//  ファイルシステムへのインタフェースを提供し、
	//  ファイルシステム内のファイルやその他のオブジェクトに
	//  アクセスするため手段を提供する  
	//  
	  
	/*  
	    FileSystemsクラスとFileSystemクラスを使用してPathオブジェクトを取得するコードを確認します。
	    FileSystemsクラスのgetDefault()メソッドによりデフォルトのFileSystemオブジェクトを取得した後、
	    FileSystemクラスのgetPath()メソッドを使用して、Pathオブジェクトを取得します 
    */
	  
	// デフォルトのFileSystem オブジェクトを取得した
    FileSystem fs = FileSystems.getDefault();
    Path path1 = fs.getPath("src/type9/ren/9_1.txt");
    Path path2 = fs.getPath("C:\\sample\\Chap09\\ren\\9_1.txt");
    Path path3 = fs.getPath("C:", "sample", "Chap09", "ren", "9_1.txt");
    
    System.out.println(path1);
    System.out.println(path2);
    System.out.println(path3);
  }
}


// Answer
// src/type9/ren/9_1.txt
// C:\sample\Chap09\ren\9_1.txt
// C:/sample/Chap09/ren/9_1.txt