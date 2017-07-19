package JavaSE8.type9;

import java.nio.file.*;
import java.nio.file.attribute.*;

public class Sample9_13 {
  public static void main(String[] args) throws java.io.IOException{
	  
	// メタデータ(ファイル属性)の取り扱い---------------------------------------------------------  
	// メタデータ：ファイルやディレクトリに含まれる属性情報です。
	// メタデータには、種類（通常のファイル、ディレクトリ、リンク）、サイズ、作成日、最終更新日、ファイル所有者、アクセス権限などがあります。
	// ファイルおよびファイルシステム属性へのアクセスを提供するインタフェースとクラス群は、java.nio.file.attributeパッケージで提供されています  
	  /*
	  java.nio.file.attribute パッケージの主なインタフェース・クラス
	  インタフェース/ クラス名	説明
	  FileTimeクラス	
	  	ファイルのタイムスタンプ属性の値を表す。
	  	たとえば、ファイルが最後に変更、アクセス、または作成された時間を表す
	  FileAttribute<T> インタフェース	
	  	新しいファイルまたはディレクトリを作成するときに、
	  	自動的に設定できるファイル属性を表すオブジェクト
	  BasicFileAttributesインタフェース	
	  	すべてのファイルシステム実装で必要となる基本的な属性を表すオブジェクト
	  DosFileAttributesインタフェース	
	  	属性を表すオブジェクト。BasicFileAttributesに、DOS属性をサポートするファイルシステムで使用される属性が追加されている
	  PosixFileAttributesインタフェース	
	  	属性を表すオブジェクト。
	  	BasicFileAttributesに、UNIXなど、POSIX 標準ファミリをサポートするファイルシステムで使用される属性が追加されている
	  */
	  
    Path p1 = Paths.get("src/type9/ren/9_13.txt");
    
    // static Map<String,Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException	
	// 	ファイルの複数の属性を一括操作で読み取る。読み取る属性をStringパラメータに指定する
	// static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException	
	// 	ファイルの複数の属性を一括操作で読み取る。Class<A> パラメータは取得する属性のクラスとする。
    // BasicFileAttributesインタフェース	
	//  すべてのファイルシステム実装で必要となる基本的な属性を表すオブジェクト
    
    BasicFileAttributes attr =
            Files.readAttributes(p1, BasicFileAttributes.class);
    
    System.out.format("creationTime     : %s%n", attr.creationTime());
    System.out.format("lastModifiedTime : %s%n", attr.lastModifiedTime());
    System.out.format("size             : %s%n", attr.size());
  }
}

/*
	Answer
		creationTime     : 2017-02-19T12:13:07Z
		lastModifiedTime : 2017-02-19T12:13:07Z
		size             : 31
*/
