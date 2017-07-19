package JavaSE8.type9;

import java.nio.file.*;
import java.nio.file.attribute.*;

public class Sample9_14 {
  public static void main(String[] args) throws java.io.IOException{
	  
    // DosFileAttributesインタフェース	
	//  属性を表すオブジェクト。
	//  BasicFileAttributesに、DOS属性をサポートするファイルシステムで使用される属性が追加されている  
	  
    Path p1 = Paths.get("src/type9/ren/9_14.txt");
    DosFileAttributes attr =
            Files.readAttributes(p1, DosFileAttributes.class);
    
    System.out.format("isArchive     : %s%n", attr.isArchive());
    System.out.format("isHidden      : %s%n", attr.isHidden());
    System.out.format("isReadOnly    : %s%n", attr.isReadOnly());
    System.out.format("isSystem      : %s%n", attr.isSystem());
  }
}

/*
	Answer
		isArchive  : true
		isHidden   : true
		isReadOnly : true
		isSystem   : false
*/
/*
	DosFileAttributes インタフェースのメソッド
	メソッド名	説明
	boolean isArchive()	アーカイブ属性の値を返す
	boolean isHidden()	隠し属性の値を返す
	boolean isReadOnly()	読み取り専用属性の値を返す
	boolean isSystem()	システム属性の値を返す
*/