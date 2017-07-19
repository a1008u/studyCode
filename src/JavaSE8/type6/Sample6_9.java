package JavaSE8.type6;

import java.sql.*;

class MyResource implements AutoCloseable{
  private String msg ;
  public MyResource(String msg) { this.msg = msg; }
  public void close() throws Exception {
    System.out.println("close() : "+ msg);
  }
}
public class Sample6_9 {
  public static void main(String[] args){
	  
	//try-with-resources
	// finallyブロックの使用例として、リソースの解放（データベースのclose 処理やファイルのclose処理など）があげられると説明しました。
	// これらの処理は、リソースにアクセスするロジックでは必須となるため、JavaSE7からtry-with-resources文が導入されました。
	// tryブロックにリソースに関する実装を記述することで、tryブロックが終了する際に暗黙的にclose()メソッドが呼び出され、リソースが解放されます。
	// つまり、close()メソッドを呼び出すコードを明示的に記述する必要はありません。
	// ・try-with-resourcesのときは、tryのみの使用が可能です。
	// tryの後に()を記述し、その中にクローズの対象となるリソースの生成処理を記述します。
	// リソースが複数ある場合はセミコロンで区切って記述します。
	// なお、tryの()内に記述できるものは、java.lang.AutoCloseableもしくは、java.io.Closeableインタフェースの実装クラスです。
	// Closeableインタフェースは、AutoCloseableインタフェースのサブインタフェースです。
	// JavaSE7のtry-with-resources文の機能追加により、
	// java.ioパッケージやjava.sqlパッケージなどのリソース関連クラスはこれらのインタフェースを実装しているため、リソースを暗黙的に解放することができます。
	// また、ストリーム関連クラスも実装しています。
	// なお、独自のクラスにAutoCloseableやCloseableインタフェースを実装することも可能です。
	// 各インタフェースはclose()メソッドのみ宣言されているため、実装クラスではオーバーライドが必要です。
	  
    try (MyResource obj1 = new MyResource("obj1");
         MyResource obj2 = new MyResource("obj2")) {
      System.out.println("try ブロック内の処理");
      throw new SQLException();
    } catch (SQLException e) {
      System.out.println("catch ブロック：SQLException");
    } catch (Exception e) {
      System.out.println("catch ブロック：Exception");
    } finally {
      System.out.println("finally ブロック");
    }
  }
}

//　Answer
//　try ブロック内の処理
//　close() : obj2
//　close() : obj1
//　catch ブロック：SQLException
//　finally ブロック

//
// tryブロック内での構文は次のとおりです。
//  try(リソース;[リソース];……n) { }