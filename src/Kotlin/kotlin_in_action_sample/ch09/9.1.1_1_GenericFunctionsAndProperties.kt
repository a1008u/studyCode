package ch09.ex1_1_1_GenericFunctionsAndProperties

fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2)) // [a, b, c]　型引数の明示的な指定
    println(letters.slice(10..13)) // [k, l, m, n]　TはCharであるとコンパイラが推論される
}
