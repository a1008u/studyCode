package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_5 {
  public static void main(String[] args) {
	  
    Path path1 = Paths.get("src/type8/ren");
    // Path normalize()	
    // 	このパスから冗長な名前要素を削除したパスを返す
    System.out.format("normalize()    : %s%n", path1.normalize());
    // URI toUri()	
    // 	このパスを表すURIを返す
    System.out.format("toUri()        : %s%n", path1.toUri());
    // boolean isAbsolute()	
    // 	このパスが絶対である場合にのみtrueを返す
    System.out.format("isAbsolute     : %s%n", path1.isAbsolute());
    // Path toAbsolutePath()	
    //  このパスの絶対パスを返す
    System.out.format("toAbsolutePath : %s%n", path1.toAbsolutePath());
    
    // toRealPathメソッドではIOExceptionは必須
    Path path2 = null;
    try {
    	// Path toRealPath(LinkOption... options)throws IOException	
    	//  既存のファイルの実際のパスを返す
    	path2 = path1.toRealPath();
    	System.out.format("toRealPath() : %s%n", path2);
    } catch(java.io.IOException e){ 
    	e.printStackTrace(); 
    }
    
  }
}

// Answer
//  normalize()    : src/type8/ren
//  toUri()        : file:///Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type8/ren/
//  isAbsolute     : false
//  toAbsolutePath : /Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type8/ren
//  toRealPath() : /Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type8/ren
