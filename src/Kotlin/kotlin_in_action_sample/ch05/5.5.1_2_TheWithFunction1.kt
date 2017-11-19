package ch05.ex5_1_2_TheWithFunction1

// with関数 ラムダコードを実行した返り値を返す
fun alphabet(): String {

    // レシーバ(receiver)の設定
    val stringBuilder = StringBuilder()

    return with(stringBuilder) { for (letter in 'A'..'Z') this.append(letter)
                                 append("\nNow I know the alphabet!")
                                 this.toString()
                               }
}

fun main(args: Array<String>) { println(alphabet()) }
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Now I know the alphabet!
*/




