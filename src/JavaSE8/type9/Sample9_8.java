package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_8 {
  public static void main(String[] args){
	  
	//  static boolean exists(Path path, LinkOption... options)	
	//	このパスが示すファイルが存在するかどうかをテストする
	  
    Path p1 = Paths.get("src/type9/ren");
    Path p2 = Paths.get("/Users/uemototakira/Documents/workspace-sts-3.8.2.RELEASE/JavaSE8_GOLD/src/type9/ren");
    System.out.format("exists       : %s%n", Files.exists(p1));
    
    try {
    	// static boolean isSameFile(Path path, Path path2)throws IOException	
    	//  2つのパスが同じファイルを検出するかどうかをテストする
    	System.out.format("isSameFile   : %s%n", Files.isSameFile(p1, p2));
    }catch(java.io.IOException e){} 
    
    System.out.format("isDirectory  : %s%n", Files.isDirectory(p1));
    System.out.format("isRegularFile: %s%n", Files.isRegularFile(p1));
    
    // static boolean isReadable(Path path)	
	//  ファイルが読み取り可能かどうかをテストする
    System.out.format("isReadable   : %s%n", Files.isReadable(p1));
    
    // static boolean isExecutable(Path path)	
	//  ファイルが実行可能かどうかをテストする
    System.out.format("isExecutable : %s%n", Files.isExecutable(p1));
  }
}

/*
	Answer
	exists       : true
	isSameFile   : true
	isDirectory  : true
	isRegularFile: false
	isReadable   : true
	isExecutable : true
*/

/*
Filesクラス
Filesクラスは、ファイル、ディレクトリなどを操作するためのクラスで、staticメソッドだけで構成されています。
Files クラスの主なメソッド
メソッド名	説明
static boolean exists(Path path, LinkOption... options)	
	このパスが示すファイルが存在するかどうかをテストする
static boolean notExists(Path path, LinkOption... options)	
	このパスが示すファイルが存在しないかどうかをテストする
static boolean isSameFile(Path path, Path path2)throws IOException	
	2つのパスが同じファイルを検出するかどうかをテストする
static boolean isDirectory(Path path, LinkOption... options)	
	このパスがディレクトリかどうかをテストする
static boolean isRegularFile(Path path, LinkOption... options)	
	通常ファイルかどうかをテストする
static boolean isReadable(Path path)	
	ファイルが読み取り可能かどうかをテストする
static boolean isWritable(Path path)	
	ファイルが書き込み可能かどうかをテストする
static boolean isExecutable(Path path)	
	ファイルが実行可能かどうかをテストする
static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException	
	新しいディレクトリを作成する
static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException	
	必要な存在していない親ディレクトリがあれれば一緒に生成する
static Path copy(Path source, Path target, CopyOption... options) throws IOException	
	ファイルをコピーする。第3引数には、コピーオプションを指定可能。オプションの種類は表9-5 を参照
static Path move(Path source, Path target, CopyOption... options) throws IOException	
	ファイルを移動するか、そのファイル名を変更する。第3引数には、移動オプションを指定可能。オプションの種類は表9-5 を参照
static long size(Path path) throws IOException	
	ファイルのサイズをバイトで返す
static void delete(Path path) throws IOException	
	引数で指定されたパスのファイルを削除する
static boolean deleteIfExists(Path path) throws IOException	
	ファイルが存在する場合は削除する
static List<String> readAllLines(Path path) throws IOException	
	ファイルからすべての行を読み取る
static UserPrincipal getOwner(Path path, LinkOption... options) throws IOException	
	ファイルの所有者を返す
static Object getAttribute(Path path, String attribute, LinkOption... options) throws IOException	
	ファイル属性の値を読み取る
static Path setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException	
	ファイル属性の値を設定する
static Map<String,Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException	
	ファイルの複数の属性を一括操作で読み取る。読み取る属性をString パラメータに指定する
static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException	
	ファイルの複数の属性を一括操作で読み取る。Class<A> パラメータは取得する属性のクラスとする。
static DirectoryStream<Path> newDirectoryStream(Path dir) throws IOException	
	ディレクトリ内のすべてのエントリを反復するためのDirectoryStreamを返す
*/

/*
	copy()およびmove()メソッドのオプション
	copy()メソッドの第3引数に指定できるStandardCopyOption列挙型とLinkOption 列挙型
	定数名	説明
	REPLACE_EXISTING	コピー先ファイルがすでに存在する場合でもコピーを実行する
	COPY_ATTRIBUTES	ファイルに関連づけられたファイル属性をコピー先ファイルにコピーする
	NOFOLLOW_LINKS	シンボリックリンクをたどらないことを指定する。つまり、コピー元のファイルがシンボリックリンクの場合は、リンク自体 がコピーされ、リンク先はコピーされない
	
	move() メソッドの第3引数に指定できるStandardCopyOption列挙型
	定数名	説明
	REPLACE_EXISTING	移動先ファイルがすでに存在する場合でも移動を実行する
	ATOMIC_MOVE	移動をアトミックなファイル操作として実行する。ファイルの移動中に問題が発生した場合には移動処理が完全に取り消されるため、ファイルに破損のないことが保証される
*/