package JavaSE8.type6;

class Test {
  private int check(int point) {
	 //JavaSE5以降では、コンパイル時点ではアサーション機能は有効になっているため、通常どおりコンパイル可能です。
	// しかし、実行時は無効となっているため、有効にするには、javaコマンドの-eaオプションを使用します。
    assert point > 0 : point + " は不正な値です";
    return point * 100;
  }
  int method(int point) {
    return check(point);
  }
}

public class Sample6_11 {
  public static void main(String[] args){
    Test obj = new Test();
    System.out.println(obj.method(10));
    System.out.println(obj.method(-1));
  }
}

// Answer 
// 1000
// -1は不正な値です

// アサーションとは、プログラマが前提としている条件をチェックし、プログラムの正しい動作を保証するための機能です。
// ①assert boolean 式;
// ②assert boolean 式: メッセージ;
// ※メッセージの有無は任意

//throwable
// Error
//  AssertionError
// Exception

//アサーションを利用する場面
// アサーションの実行を正常動作の一部とするようなプログラムは書くべきではありません。
// たとえば、エンドユーザの入力値をチェックし、その結果に応じて処理を分岐させるといったことにアサーションを使ってはいけません。
// アサーションは、プログラムにバグを残さないための1つの手法です。
// したがって、作成したプログラムをリリースする段階では、必ずAssertionError がスローされないレベルに達している必要があります。
//アサーションは、以下のような条件を検証するときに使用します。
// 事前条件
//  メソッドが呼び出されたときにtrue であるべき条件です。
//  ただし、publicメソッド内の引数チェックに使用することは推奨されていません。
//  なぜならpublicメソッドはアサーションが有効かどうかにかかわらず引数をチェックする必要があるためです。
//  したがって、privateメソッドの引数などの検証に使用します。
// 事後条件
//  メソッドが正常に実行された後にtrueであるべき条件です。
//  事後条件のアサーションはpublicメソッド内、その他のメソッド内で使用できます。
//不変条件
//  常にtrueであるべき条件です。
//  プログラムが正しい動作をするために、常に満たしていなければならない条件を検証するものです。
