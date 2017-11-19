package ch05.ex2_1_3_FilterMap2

// map関数はコレクション内の各要素に与えられた関数を適用し、その結果を新しいコレクションへと集約する。
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it }) // [1, 4, 9, 16]
}
