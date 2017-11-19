package ch05.ex5_2_2_TheApplyFunction1

/* buildString StringBuilderとtoStringの両方を呼び出す
public inline fun buildString(builderAction: StringBuilder.() -> Unit): String = StringBuilder().apply(builderAction)
                                                                                                .toString()
*/
fun alphabet() = buildString { for (letter in 'A'..'Z') append(letter)
                               append("\nNow I know the alphabet!")
                             }

fun main(args: Array<String>) {
    println(alphabet())
}
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Now I know the alphabet!
*/

