package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;

public class Sample9_17{
  public static void main(String[] args) {
	 
	/*  
	 static Stream<Path> walk(Path start, 
	  						  int maxDepth, 
	  						  FileVisitOption... options) throws IOException	
	引数で指定された開始ファイルをルートとし、
	指定された最大階層まで探索を行うファイル・ツリーを参照するStreamを返す
	*/  
	  
    Path path = Paths.get("src/type9/ren/9_XX");
    
    try {
      Files.walk(path)
           .filter(s -> s.toString().endsWith(".jpg"))
           .forEach(System.out::println);
    } catch (IOException 
    		e) { 
    	e.printStackTrace(); 
    }
    
  }
}

/*
	Answer
		src/type9/ren/9_XX/b.jpg
*/