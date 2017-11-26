package ch06.ex1_1_NullableTypes

/**
 * 6.1 null許容性の区別
 * 6.1.1 null許容型
 * 6.1.2 型の意味
 * 6.1.3 安全呼び出し演算子：?.
 * 6.1.4 エルビス演算子：?:
 * 6.1.5 安全キャスト：as?
 * 6.1.6 非null表明：!!
 * 6.1.7 let関数
 * 6.1.8 遅延初期化プロパティ
 * 6.1.9 null許容型の拡張関数
 * 6.1.10 型パラメータのnull許容性の区別
 * 6.1.11 null許容性の区別とJava
 * 6.2 プリミティブ型と基本的な型
 * 6.2.1 プリミティブ型：Int、Booleanなど
 * 6.2.2 null許容プリミティブ型：Int?, Boolean?など
 * 6.2.3 数字の変換
 * 6.2.4 AnyとAny?：基本型
 * 6.2.5 Unit型：Kotlinにおけるvoid型
 * 6.2.6 Nothing型：この関数は値を返さない
 * 6.3 コレクションと配列
 * 6.3.1 null許容型の区別とコレクション
 * 6.3.2 読み取り専用コレクションとミュータブルコレクション
 * 6.3.3 KotlinのコレクションとJava
 * 6.3.4 コレクションとプラットフォーム型
 * 6.3.5 オブジェクトとプリミティブ型の配列
 * 6.4 まとめ
 *
 */


// null許容型として宣言する(String or null)
fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun main(args: Array<String>) {
    val x: String? = null
    println(strLenSafe(x)) // 0
    println(strLenSafe("abc")) // 3
}
