package ch09.ex2_1_2_GenericsAtRuntimeTypeChecksAndCasts1

// 型情報がコンパイル時に既に判明している時は、isチェックを使用する
fun printSum(c: Collection<Int>) { if (c is List<Int>) println(c.sum()) }
fun main(args: Array<String>) = printSum(listOf(1, 2, 3)) // 6
