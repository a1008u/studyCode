package ch05.Alphabet

// with関数やapply関数の未使用
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') result.append(letter)
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun main(args: Array<String>) {
    println(alphabet())
}
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Now I know the alphabet!
*/