package ch07.PointPlusMember

// 算術演算子のオーバーロード（規約）
data class Point(val x: Int, val y: Int) {
    // plusという名前の演算子関数を定義する(operatorキーワードを利用する)
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
}

data class Point2(val x: Int, val y: Int) {
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    val p3 = Point2(10, 20)
    println(p1 + p2 + p3) // Point(x=40, y=60)
}
