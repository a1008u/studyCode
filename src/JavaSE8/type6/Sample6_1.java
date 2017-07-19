package JavaSE8.type6;

public class Sample6_1 {
  public static void main(String[] args) {
	 
	// Javaの例外について(checked例外とunchecked例外の2パターンある)
	// checked例外
	//		データベースなどJava実行環境以外の環境が原因で発生する例外です。
	//		例外処理が必須であることです。
    // unchecked例外
	//		実行中のプログラムが原因で発生する例外（実行時例外）やメモリ不足など、プログラムの例外処理では復旧できない例外です。
	//		unchecked例外は、例外処理が必須ではなく任意です。
    //
	// 例外クラスの分類
	//		●　Errorクラスおよびそのサブクラス（unchecked例外）
	//		●　RuntimeExceptionクラスおよびそのサブクラス（unchecked例外）
	//		●　RuntimeExceptionクラス以外のExceptionのサブクラス（checked例外）
    //
	// 例外処理が必須か任意かは処理内容ではなく、処理した結果、発生する可能性のある例外クラスが何であるかによって決定します。
	//		・RuntimeExceptionクラスおよびそのサブクラスである場合には任意。
	//		・RuntimeExceptionクラス以外のException のサブクラスである場合には必須。 
	  
    int[] num = {10, 20, 30};
    
    for (int i = 0; i < 4; i++) {
      try {
        System.out.print("num :" + num[i]);
        System.out.println(" : " + (i+1) + " 回目のループ");
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.println(" 例外が発生しました");
      } finally {
        System.out.println("--"+ (i+1) +"回目のfinallyの実行");
      }
    }
    
    System.out.println("-- end --");
  }
}

/*
    Answer
	num :10 : 1 回目のループ
	--1回目のfinallyの実行
	num :20 : 2 回目のループ
	--2回目のfinallyの実行
	num :30 : 3 回目のループ
	--3回目のfinallyの実行
	 例外が発生しました
	--4回目のfinallyの実行
	-- end --
*/

// 独自クラスの実装
// [修飾子] class クラス名 extends Exception{ }

//主な例外クラス 
//カテゴリ	 クラス名	説明
//・Error のサブクラスunchecked例外（例外処理は任意）	
//	AssertionError	assert 文を使用している際に、boolean 式でfalse が返ると発生
//	StackOverflowError	アプリケーションでの再帰の回数が多すぎる場合に発生
//	NoClassDefFoundError	読み込もうとしたクラスファイルが見つからない場合に発生
//・RuntimeExceptionのサブクラスunchecked 例外（例外処理は任意）	
//	ArrayIndexOutOfBoundsException	不正なインデックスで要素にアクセスしようとした場合に発生
//	ArrayStoreException	不正な型のオブジェクトを配列に格納した場合に発生
//	ClassCastException	参照変数において間違ったキャストを行った場合に発生
//	IllegalStateException	メソッドの呼び出しが正しくない状態で行われた場合に発生
//	DateTimeException	日付/ 時間の計算時に誤った処理を行った場合に発生
//	MissingResourceException	リソースが見つからない場合に発生
//	ArithmeticException	整数をゼロで除算した場合に発生
//	NullPointerException	null が代入されている参照変数に対して、メソッド呼び出しを行った場合に発生
//	NumberFormatException	整数を表さない文字列を整数に変換しようとした場合に発生
//・RuntimeException 以外のException のサブクラスchecked 例外（例外処理は必須）	
//	IOException	入出力を行う場合に発生
//	FileNotFoundException	ファイル入出力において、目的のファイルがなかった場合に発生
//	ParseException	解析中に予想外のエラーがあった場合に発生
//	SQLException	データベース・アクセス時にエラーがあった場合に発生
//
//Throwable クラスの主なメソッド
//メソッド名	説明
//	void printStackTrace()	エラートレース（エラーを追跡し発生箇所を特定する）を出力する
//	String getMessage()	エラーメッセージを取得する


// try-catch-finallyについて
//・try ブロック→　例外が発生しそうな箇所をtryブロックで囲む
//・catch ブロック→　例外が発生したときの処理をcatch ブロックの中に定義する　
//・finally ブロック→　例外が発生してもしなくても必ず実行したい処理をfinally ブロックに定義する
//-構文-
//・try-catch
//・try-finally
//・try-catch-finally
//・従来のtryブロック定義の場合、tryのみの使用はコンパイルエラー。後述するtry-with-resourcesのときは、tryのみの使用が可能