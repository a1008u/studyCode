package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_4 {
  public static void main(String[] args) {
	  
    Path path = 
    		Paths.get("/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type9/ren/9_1.txt");
    
    // Path subpath(int beginIndex, int endIndex)	
    // 	開始インデックスから、終了インデックス-1の要素までで構成されたパス（ルート要素は含まない）を返す
    
    System.out.format("1-4     : %s%n", path.subpath(1,4));
    System.out.format("0-2     : %s%n", path.subpath(0,2));
    System.out.format("0-5     : %s%n", path.subpath(0,5));
    System.out.format("2-2     : %s%n", path.subpath(2,2));
  }
}

/*
	Answer
	1-4     : uemototakira/Documents/workspace-sts-3.8.2.RELEASE
	0-2     : Users/uemototakira
	0-5     : Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD
	Exception in thread "main" java.lang.IllegalArgumentException
		at sun.nio.fs.UnixPath.subpath(UnixPath.java:350)
		at sun.nio.fs.UnixPath.subpath(UnixPath.java:43)
		at type9.Sample9_4.main(Sample9_4.java:11)
*/