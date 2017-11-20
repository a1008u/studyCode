package ch07.ex3_2_InOperator

data class Point(val x: Int, val y: Int)
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

// until関数を使って開いたレンジを作り、検証
operator fun Rectangle.contains(p: Point): Boolean = p.x in upperLeft.x until lowerRight.x
                                                     && p.y in upperLeft.y until lowerRight.y

// inの規約
// a in c -> c.aontains(a)
fun main(args: Array<String>) {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect) // true
    println(Point(5, 5) in rect) // false
}
