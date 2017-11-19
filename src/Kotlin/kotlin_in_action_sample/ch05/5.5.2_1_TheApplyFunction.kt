package ch05.ex5_2_1_TheApplyFunction

// apply関数の利用
// ラムダ実行後、レシーバオブジェクトを返す
fun alphabet() = StringBuilder().apply { for (letter in 'A'..'Z') append(letter)
                                         append("\nNow I know the alphabet!")
                                       }.toString()

fun main(args: Array<String>) {
    println(alphabet())
}
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Now I know the alphabet!
*/



