package ch09.printFirst

// スター投影(star-projection)
// ジェネリック引数に関する情報を持たない示すために使用する
// Any?に一致することのみ保証
fun printFirst(list: List<*>) {
    // isNotEmpty()はジェネリック型パラメータを使わない
    if (list.isNotEmpty()) { println(list.first()) }// Any?として返す
}

fun main(args: Array<String>) = printFirst(listOf("Svetlana", "Dmitry")) // Svetlana