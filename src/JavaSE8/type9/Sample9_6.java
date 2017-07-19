package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_6 {
  public static void main(String[] args) {
	  
	// Path resolve(String other)	
	//  ルート要素を含まない部分パスを引数に指定すると、
    //  既存パスに部分パスが追加されたPathオブジェクトを返す。
	//  絶対パスの場合は、引数のotherをそのまま返す
	  
    Path path1 = Paths.get("ren/../type9");
    Path path2 = Paths.get("X");
    System.out.format("resolve : %s%n", path1.resolve(path2));
    
    Path path3 = Paths.get("C:\\sample");
    System.out.format("resolve : %s%n", path1.resolve(path3));
    Path path = Paths.get("C:\\sample\\Chap09");
  }
}

// Answer
//  resolve : ren/../type9/X
//  resolve : ren/../type9/C:\sample
