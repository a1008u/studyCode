package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;
import java.util.function.Consumer;

public class Sample9_15{
  public static void main(String[] args) {
	   
	// FileSystemクラス→ディレクトリ操作
	// FileSystemクラスには、ルートディレクトリを取得するgetRootDirectories()メソッドが提供されています。
	// また、FilesクラスのnewDirectoryStream()メソッドを使用すると、ディレクトリの内容リストを取得できます。  
	  
    FileSystem fs = FileSystems.getDefault();
    Iterable<Path> dirs = fs.getRootDirectories();
    dirs.forEach(name ->System.out.println("RootDirectories : " + name));
    
    Path path = Paths.get("src/type9/ren/9_15");
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
      for (Path file: stream) {
        System.out.println(file.getFileName());
      }
    } catch (IOException e) { 
    	e.printStackTrace(); 
    }
    
  }
}

/*
	Answer
		RootDirectories : /
		X.txt
		Y
*/