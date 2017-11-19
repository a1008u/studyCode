package ch06.ex1_4_1_ElvisOperator

// エルビス演算子(Elvis operator) or null合体演算子(null-coalescing operator)
fun strLenSafe(s: String?): Int = s?.length ?: 0

fun main(args: Array<String>) {
    println(strLenSafe("abc")) // 3
    println(strLenSafe(null)) // 0
}
