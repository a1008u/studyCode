package JavaSE8.type9;

import java.nio.file.*;

public class Sample9_10 {
  public static void main(String[] args) throws java.io.IOException{
	  
    Path p1 = Paths.get("src/type9/ren/9_10.txt");
    Path p2 = Paths.get("src/type9/ren//9_10_cp.txt");
    Path p3 = Paths.get("src/type9/ren//9_10_org.txt");
    Path p4 = Paths.get("src/type9/ren//9_10_mv.txt");
    
    // static Path copy(Path source, Path target, CopyOption... options) throws IOException	
	// 	ファイルをコピーする。第3引数には、コピーオプションを指定可能。
	// static Path move(Path source, Path target, CopyOption... options) throws IOException	
	// 	ファイルを移動するか、そのファイル名を変更する。第3引数には、移動オプションを指定可能。
    Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
    Files.move(p3, p4, StandardCopyOption.REPLACE_EXISTING);
    Files.delete(p1);
  }
}

/*
copy()およびmove()メソッドのオプション
copy()メソッドの第3引数に指定できるStandardCopyOption列挙型とLinkOption列挙型
定数名	説明
REPLACE_EXISTING	
	コピー先ファイルがすでに存在する場合でもコピーを実行する
COPY_ATTRIBUTES	
	ファイルに関連づけられたファイル属性をコピー先ファイルにコピーする
NOFOLLOW_LINKS	
	シンボリックリンクをたどらないことを指定する。
	つまり、コピー元のファイルがシンボリックリンクの場合は、
	リンク自体がコピーされ、リンク先はコピーされない

move() メソッドの第3引数に指定できるStandardCopyOption列挙型
定数名	説明
REPLACE_EXISTING	
	移動先ファイルがすでに存在する場合でも移動を実行する
ATOMIC_MOVE	
	移動をアトミックなファイル操作として実行する。
	ファイルの移動中に問題が発生した場合には移動処理が完全に取り消されるため、
	ファイルに破損のないことが保証される
*/
