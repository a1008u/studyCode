package ch07.ex4_1_DestructuringDeclarations

data class Point(val x: Int, val y: Int)

/*
val (a, b) = p
|
val a = p.component1()
val b = p.component2()
 */
fun main(args: Array<String>) {
    val p = Point(10, 20)
    val (x, y) = p
    println(x) // 10
    println(y) // 20
}
