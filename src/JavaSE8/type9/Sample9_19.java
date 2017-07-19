package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;

public class Sample9_19{
  public static void main(String[] args) {
	  
	/*
	static Stream<Path> find(Path start, 
						   	 int maxDepth, 
							 BiPredicate<Path, BasicFileAttributes> matcher, 
							 FileVisitOption... options) throws IOException	
	引数で指定された開始ファイルをルートとし、条件にあったパスを持ち、
	かつ、指定された最大階層まで探索を行うファイル・ツリーを参照するStreamを返す  
	BiPredicateインタフェース（メソッドは「boolean test(T t, U u)」）
	long toMillis() : 値をミリ秒単位で返します。
	*/
	  
    Path p = Paths.get("src/type9/ren/9_XX");
    long dateF = 1457325000000L;
    try {
      Files.find(p, 
                 10, 
                 (path, attr) -> 
                       path.toString().endsWith(".jpg") && 
                       attr.creationTime().toMillis() > dateF)
           .forEach(System.out::println);
    } catch (IOException e) { e.printStackTrace(); }
  }
}

/*
	Answer
		src/type9/ren/9_XX/b.jpg
*/