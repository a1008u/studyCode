package ch03.ex1_1_CreatingCollectionsInKotlin

/**
 * 3.1 Kotlinにおけるコレクションの生成
 * 3.2 関数呼び出しを簡単にする
 * 3.2.1 名前付き引数
 * 3.2.2 デフォルト引数
 * 3.2.3 静的なユーティリティクラスをなくす：トップレベル関数とプロパティ
 * 3.3 他人のクラスにメソッドを追加する：拡張関数と拡張プロパティ
 * 3.3.1 インポートと拡張関数
 * 3.3.2 拡張関数をJavaから呼び出す
 * 3.3.3 拡張としてのユーティリティ関数
 * 3.3.4 拡張関数をオーバーライドできない
 * 3.3.5 拡張プロパティ
 * 3.4 コレクションを扱う：可変長引数、中置呼び出し、ライブラリのサポート
 * 3.4.1 JavaのコレクションAPIの拡張
 * 3.4.2 可変長引数：任意の数の引数をとる関数
 * 3.4.3 ペアを扱う：中置呼び出しと分解宣言
 * 3.5 文字列と正規表現を扱う
 * 3.5.1 文字列の分割
 * 3.5.2 正規表現とトリプルクオート文字列
 * 3.5.3 複数行のトリプルクオート文字列
 * 3.6 コードを整理する：ローカル関数と拡張
 * 3.7 まとめ
 */


val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main(args: Array<String>) {
    println(set.javaClass) // class java.util.HashSet - hashSet
    println(list.javaClass) // class java.util.ArrayList - arrayList
    println(map.javaClass) // class java.util.HashMap - hashMap

}
