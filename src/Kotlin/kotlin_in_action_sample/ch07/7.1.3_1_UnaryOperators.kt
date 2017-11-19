package ch07.ex1_3_1_UnaryOperators

data class Point(val x: Int, val y: Int)

// 単項演算子のオーバーロード
// 単項のマイナス関数は引数を持たない
/*
式------ 関数名-----
+a       unaryPlus
-a       unaryMinus
!a       not
++a, a++ inc
--a, a-- dec
*/


operator fun Point.unaryMinus(): Point = Point(-x, -y)

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(-p) // Point(x=-10, y=-20)
}
