package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_7 {
  public static void main(String[] args) {
	  
    Path p1 = Paths.get("X");
    Path p2 = Paths.get("Y");
    
    // Path relativize(Path other)	
    //  このパスと指定されたパスとの間の相対パスを返す
    
    System.out.println("X → Y 相対パス : " + p1.relativize(p2));
    System.out.println("Y → X 相対パス : " + p2.relativize(p1));
  }
}

/*
	Answer
		X → Y 相対パス : ../Y
		Y → X 相対パス : ../X
*/