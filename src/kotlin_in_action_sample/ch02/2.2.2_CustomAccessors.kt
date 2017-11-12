package ch02.ex2_2_CustomAccessors

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(height = 41, width = 43)
    println(rectangle.isSquare)
}
