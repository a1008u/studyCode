package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_9 {
  public static void main(String[] args) throws java.io.IOException{
	  
	// static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException	
	// 	新しいディレクトリを作成する  
    Path p1 = Paths.get("src/type9/ren/tmp");
    Files.createDirectory(p1);
    
    Path p2 = Paths.get("src/type9/ren/tmp/x/y");
    
    // static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException	
    // 	必要な存在していない親ディレクトリがあれれば一緒に生成する
    Files.createDirectories(p2);
    Files.delete(p2);
    
    // static boolean deleteIfExists(Path path) throws IOException	
	// 	ファイルが存在する場合は削除する
    Files.deleteIfExists(Paths.get("src/type9/ren/9_9"));
  }
}

