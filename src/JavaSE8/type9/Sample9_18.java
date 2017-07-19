package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;

public class Sample9_18{
  public static void main(String[] args) {
	  
	// static Stream<Path> list(Path dir) throws IOException	
	//	ディレクトリ内のエントリを要素に持つStreamを返す  
	  
    Path path = Paths.get("src/type9/ren/9_XX");
    
    try {
      Files.list(path)
      	   .forEach(System.out::println);
      
      System.out.println();
      
      Files.list(path)
	       .filter(s -> !Files.isDirectory(s))
	       .forEach(System.out::println);
    } catch (IOException e) { 
    	e.printStackTrace(); 
    }
    
  }
}

/*
Answer
	src/type9/ren/9_XX/a.txt
	src/type9/ren/9_XX/b.jpg
	src/type9/ren/9_XX/X
	
	src/type9/ren/9_XX/a.txt
	src/type9/ren/9_XX/b.jpg
*/