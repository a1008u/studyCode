package ch07.PointPlusExtension

data class Point(val x: Int, val y: Int)

// 円座因子を拡張関数として定義
operator fun Point.plus(other: Point): Point = Point(x + other.x, y + other.y)

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2) // Point(x=40, y=60)
}
