package ch02.ex4_4_1_UsingAnInCheck

// collectionやレンジの一員であることを調べるためにinを使用
// c in 'a'..'z' --- a <= c && c <= z
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('x'))
}
