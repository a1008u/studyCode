package ch02.ex3_1_DeclaringEnumClasses

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(r = 255, g = 0, b = 0)
    , ORANGE(r = 255, g = 165, b = 0)
    , YELLOW(r = 255, g = 255, b = 0)
    , GREEN(r = 0, g = 255, b = 0)
    , BLUE(r = 0, g = 0, b = 255)
    , INDIGO(r = 75, g = 0, b = 130)
    , VIOLET(r = 238, g = 130, b = 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(args: Array<String>) {
    println(Color.BLUE.rgb()) // 255
}
