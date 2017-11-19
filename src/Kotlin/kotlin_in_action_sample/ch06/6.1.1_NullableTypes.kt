package ch06.ex1_1_NullableTypes

// null許容型として宣言する(String or null)
fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun main(args: Array<String>) {
    val x: String? = null
    println(strLenSafe(x)) // 0
    println(strLenSafe("abc")) // 3
}
