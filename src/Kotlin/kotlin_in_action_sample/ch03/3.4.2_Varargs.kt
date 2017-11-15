package ch03.ex4_2_Varargs


fun main(args: Array<String>) {
    // スプレッド演算子(spread operator)は配列の中身を取り出す
    val list = listOf("args: ", *args)
    println(list) // [args: ]

    // 中置呼び出し(infix call )
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    val (number,name) = 1 to "one"

    // 分解宣言
    // public fun <K, V> mapOf(pair: Pair<K, V>): Map<K, V> = java.util.Collections.singletonMap(pair.first, pair.second)
    val test = mapOf(1 to "one")
}

