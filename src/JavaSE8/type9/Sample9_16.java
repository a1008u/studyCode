package JavaSE8.type9;

import java.io.*;
import java.nio.file.*;

public class Sample9_16{
  public static void main(String[] args) {
	 
	/* Filesクラス (import java.nio.file.Files;)
	 *  ファイルやディレクトリの作成・削除・コピー・移動・ファイル属性の取得設定を行える
	 *  static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException	
	 *  引数で指定された開始ファイルをルートとしたファイル・ツリーを参照するStreamを返す
	 */
	  
    Path path = Paths.get("src/type9/ren/9_XX");
    try {
      Files.walk(path).forEach(System.out::println);
    } catch (IOException e) { 
    	e.printStackTrace(); 
    }
  }
}

/*
	Answer
		src/type9/ren/9_XX
		src/type9/ren/9_XX/a.txt
		src/type9/ren/9_XX/b.jpg
		src/type9/ren/9_XX/X
		src/type9/ren/9_XX/X/y.txt
*/

/*
Filesクラスに追加されたメソッド
メソッド名	説明
static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException	
	引数で指定された開始ファイルをルートとしたファイル・ツリーを参照するStream を返す
static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException	
	引数で指定された開始ファイルをルートとし、指定された最大階層まで探索を行うファイル・ツリーを参照するStream を返す
static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path,BasicFileAttributes> matcher, FileVisitOption... options) throws IOException	
	引数で指定された開始ファイルをルートとし、条件にあったパスを持ち、かつ、指定された最大階層まで探 索を行うファイル・ツリーを参照するStream を返す
static Stream<Path> list(Path dir) throws IOException	
	ディレクトリ内のエントリを要素に持つStream を返す
static Stream<String> lines(Path path) throws IOException	
	ファイル内のすべての行をStreamとして読み取る
*/