package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_3 {
  public static void main(String[] args) {
	  
    // Windows
    // Path path = Paths.get("C:\\sample\\Chap09\\ren\\9_1.txt");
	  
    // Linux
    Path path = Paths.get("/sample/Chap09/ren/9_1.txt");
    
    // String toString()	
    // 	このパスの文字列表現を返す
    System.out.format("toString    : %s%n", path.toString());
    // Path getFileName()	
    // 	名前要素シーケンスの最後の要素を返す
    System.out.format("getFileName : %s%n", path.getFileName());
    // Path getName(int index)	
    // 	指定したインデックスに対応するパス要素が返る。
    //  0番目の要素はルートに最も近いパス要素
    System.out.format("getName(0)  : %s%n", path.getName(0));
    // int getNameCount()	
    // 	パス内の要素数を返す
    System.out.format("getNameCount: %d%n", path.getNameCount());
    // Path getRoot()	
    // 	パスのルートを返す
    System.out.format("getRoot     : %s%n", path.getRoot());
    
    while((path = path.getParent()) != null) {
        System.out.format("  getParent   : %s%n", path);
    }
    
    Path p = Paths.get("ren\\9_1.txt");
    System.out.format("getRoot     : %s%n", p.getRoot());
  }
}

// Answer
//  toString    : /sample/Chap09/ren/9_1.txt
//  getFileName : 9_1.txt
//  getName(0)  : sample
//  getNameCount: 4
//  getRoot     : /
//   getParent   : /sample/Chap09/ren
//   getParent   : /sample/Chap09
//   getParent   : /sample 
//   getParent   : /
//  getRoot     : null

// Path インタフェースの主なメソッド
//  メソッド名 	説明
// String toString()	
//	このパスの文字列表現を返す
// Path getFileName()	
//	名前要素シーケンスの最後の要素を返す
// Path getName(int index)	
//	指定したインデックスに対応するパス要素が返る。0番目の要素はルートに最も近いパス要素
// int getNameCount()	
//	パス内の要素数を返す
// Path subpath(int beginIndex, int endIndex)	
//	開始インデックスから、終了インデックス-1の要素までで構成されたパス（ルート要素は含まない）を返す
// Path getParent()	
//	親ディレクトリのパスを返す
// Path getRoot()	
//	パスのルートを返す
// Path normalize()	
//	このパスから冗長な名前要素を削除したパスを返す
// URI toUri()	
//	このパスを表すURIを返す
// boolean isAbsolute()	
//	このパスが絶対である場合にのみtrueを返す
// Path toAbsolutePath()	
//  このパスの絶対パスを返す
// Path toRealPath(LinkOption... options)throws IOException	
//  既存のファイルの実際のパスを返す
// Path resolve(String other)	
//  ルート要素を含まない部分パスを引数に指定すると、既存パスに部分パスが追加されたPathオブジェクトを返す。
//  絶対パスの場合は、引数のotherをそのまま返す
// Path relativize(Path other)	
//  このパスと指定されたパスとの間の相対パスを返す
// Iterator<Path> iterator()	
//  ディレクトリ階層の要素を返すイテレータを取得。
//  イテレータでは、ルートコンポーネント( 存在する場合) は返さない
// boolean endsWith(String other)	
//  引数で指定したパス文字列で終わっているとtrue が返る