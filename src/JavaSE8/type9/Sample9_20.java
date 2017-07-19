package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Sample9_20{
  public static void main(String[] args) {
	  
	// static Stream<String> lines(Path path) throws IOException	
	//  ファイル内のすべての行をStreamとして読み取る
	  
    Path path = Paths.get("src/type9/ren/9_20.txt");
    
    try {
      System.out.println(
             Files.lines(path)
                  .filter(s -> s.startsWith("File"))
                  .map(word -> word.length())
                  .peek(word -> System.out.println(word))
                  .collect(Collectors.toList()));
    } catch (IOException e) { e.printStackTrace(); }
    
  }
}

/*
Answer
	10
	5
	5
	[10, 5, 5]
*/

/* txtの中身
FileSystem
LinkPermission
Paths
Files
SimpleFileVisitor
StandardWatchEventKinds
Files
*/