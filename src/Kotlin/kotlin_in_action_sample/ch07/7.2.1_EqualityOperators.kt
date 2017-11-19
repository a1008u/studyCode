package ch07.ex2_1_EqualityOperators

// Anyクラスで定義されているため、operator修飾子ではなく、override修飾子となる
// Anyクラスからの継承されるメソッド実装は、常に拡張関数よりも優勢となる
class Point(val x: Int, val y: Int) {
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true // 最適化：引数がthisと同じオブジェクトか確認
        if (obj !is Point) return false // 引数の方を検証
        return obj.x == x && obj.y == y // スマートキャストを使ってPointのxとyのプロパティにアクセス
    }
}

// 等価比較の演算子:equals ==
// ===演算子はオーバーロードできない
fun main(args: Array<String>) {
    println(Point(10, 20) == Point(10, 20)) // true
    println(Point(10, 20) != Point(5, 5)) // true
    println(null == Point(1, 2)) // false
}
