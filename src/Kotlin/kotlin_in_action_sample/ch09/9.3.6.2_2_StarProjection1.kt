package ch09.ex3_6_2_2_StarProjection1

// 全てのリストを受け入れる引数(T)
fun <T> printFirst(list: List<T>) {
    if (list.isNotEmpty()) { println(list.first()) } // Tの値として返す
}

fun main(args: Array<String>) = printFirst(listOf("Svetlana", "Dmitry"))

