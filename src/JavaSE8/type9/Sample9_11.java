package JavaSE8.type9;

import java.nio.file.*;
import java.util.List;

public class Sample9_11 {
  public static void main(String[] args) throws java.io.IOException{
	  
	// static List<String> readAllLines(Path path) throws IOException	
	// 	ファイルからすべての行を読み取る
    Path path = Paths.get("src/type9/ren/9_11.txt");
    List<String> lines = Files.readAllLines(path);
    
    for(String line : lines) {
      System.out.println(line);
    }
    
    lines.stream().map(s -> s.toUpperCase())
                  .forEach(System.out::println);
  }
}

/*
	Answer
		Read all lines from a file. 
		Bytes from the file are decoded into characters using the UTF-8 charset.
		READ ALL LINES FROM A FILE. 
		BYTES FROM THE FILE ARE DECODED INTO CHARACTERS USING THE UTF-8 CHARSET.
*/
