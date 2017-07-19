package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_1 {
  public static void main(String[] args) {
	  
	// Path インタフェース
	// java.nio.file.Pathインタフェースは、
	// ファイルシステム内のファイルを特定するために使用される、
	// システムに依存するファイルパスを表します。
	// Pathオブジェクトは、そのパスを構成するために使用されるファイル名とディレクトリ名を含んでおり、
	// ファイルの調査、場所の特定、操作に使用されます。  
	// SE7の時点でjava.io.Fileクラスからファイル・ディレクトリ操作等を分離した。
	  
	// static Path get(String first, String... more)
	// 1つのパス文字列、もしくは第2 引数以降で指定されたパス文字列をもとにPath オブジェクトに変換する  
	  
    Path path1 = Paths.get("src/type9/ren/9_1.txt");
    Path path2 = Paths.get("/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type9/ren/9_1.txt");
    Path path3 = Paths.get("Users/", "sample", "Chap09", "ren", "9_1.txt");
    System.out.println(path1);
    System.out.println(path2);
    System.out.println(path3);
  }
}

/*
	java.nio.file
		ファイル、ファイル属性、およびファイルシステムにアクセスするためのインタフェースとクラスを提供。
	
	java.nio.file.attribute
		ファイルおよびファイルシステム属性へのアクセスを提供するインタフェースとクラスを提供。
*/

// static Path get(URI uri)	
// 指定されたURIをPathオブジェクトに変換する

// Answer
// src/type9/ren/9_1.txt
// /Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type9/ren/9_1.txt
// Users/sample/Chap09/ren/9_1.txt
 
// java.nio.file パッケージの主なインタフェース・クラス
// インタフェース/ クラス名	説明
// Pathインタフェース	
// ファイルシステム内のファイルを特定するために使用される、システムに依存するファイルパスを表す
// Pathsクラス	
// パス文字列またはURIを変換してPathオブジェクトを返すstaticメソッドを提供する
// FileSystemsクラス	
// ファイルシステム用のファクトリクラス。デフォルトのファイルシステムおよびファクトリメソッドを取得して他の種類のファイルシステムを構築する
// FileSystemクラス	
// ファイルシステムへのインタフェースを提供し、ファイルシステム内のファイルやその他のオブジェクトにアクセスするため手段を提供する