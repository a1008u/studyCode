package ch06.ex1_3_1_SafeCallOperator

// 安全呼び出し演算子（safe-call operator）?.
fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

fun main(args: Array<String>) {
    printAllCaps("abc") // ABC
    printAllCaps(null) // null
}
