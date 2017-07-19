package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_12 {
  public static void main(String[] args) throws java.io.IOException{
	  
	  
	// static Object getAttribute(Path path, String attribute, LinkOption... options) throws IOException	
    //  ファイル属性の値を読み取る  
	  
	Path path = Paths.get("src/type9/ren/9_12.txt");
	Object obj1 = Files.getAttribute(path, "creationTime");
	Object obj2 = Files.getAttribute(path, "lastModifiedTime");
	Object obj3 = Files.getAttribute(path, "size");
	
	System.out.format("creationTime     : %s%n", obj1);
	System.out.format("lastModifiedTime : %s%n", obj2);
	System.out.format("size             : %s%n", obj3);
  }
}

/*
	Answer
		creationTime     : 2017-02-19T12:13:07Z
		lastModifiedTime : 2017-02-19T12:13:07Z
		size             : 31
*/

