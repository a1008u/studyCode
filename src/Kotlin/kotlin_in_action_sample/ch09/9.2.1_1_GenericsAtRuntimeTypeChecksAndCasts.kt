package ch09.ex2_1_1_GenericsAtRuntimeTypeChecksAndCasts


// 上限境界を持っていない型パラメータはAny?を上限境界とする

// スター投影
// 道の方引数をもった型(*を利用)
fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun main(args: Array<String>) = printSum(listOf(1, 2, 3)) // 6
