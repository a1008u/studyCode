package ch03.ex5_1_1_SplittingStrings

// [12, 345, 6, A]
fun main(args: Array<String>) = println("12.345-6.A".split("\\.|-".toRegex()))

