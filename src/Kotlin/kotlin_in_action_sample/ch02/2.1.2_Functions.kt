package ch02.ex1_2_Functions

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun main(args: Array<String>) = println(max(1, 2))

/**
 * {}に本体が入る形で関数が記述されていた場合、関数は「ブロック本体（block body）を持つ」と云う
 * もし式を直接返すなら「式本体（expression body）を持つ」と云う
 */
