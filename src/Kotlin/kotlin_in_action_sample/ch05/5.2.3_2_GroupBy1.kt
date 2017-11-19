package ch05.ex2_3_2_GroupBy1

// メンバ参照を使用した例
fun main(args: Array<String>) {
    val list = listOf("a", "ab", "b")
    println(list.groupBy(String::first)) // {a=[a, ab], b=[b]}
}
