package ch07.ex1_1_3_BinaryOperators2

data class Point(val x: Int, val y: Int)

// 関数名 *:times
operator fun Point.times(scale: Double): Point = Point((x * scale).toInt(), (y * scale).toInt())

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p * 1.5) // Point(x=15, y=30)
}
