package ch05.ex5_1_3_TheWithFunction2

// thisは省略可能
fun alphabet() = with(StringBuilder()) { for (letter in 'A'..'Z') this.append(letter)
                                         append("\nNow I know the alphabet!")
                                         toString()
                                       }

fun main(args: Array<String>) { println(alphabet()) }
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Now I know the alphabet!
*/


