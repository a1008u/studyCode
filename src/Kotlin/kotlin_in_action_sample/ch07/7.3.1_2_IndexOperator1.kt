package ch07.ex3_1_2_IndexOperator1

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = MutablePoint(10, 20)
    p[1] = 42 // x[a,b] = c -> x.set(a,b,c) となる
    println(p) // MutablePoint(x=10, y=42)
}
