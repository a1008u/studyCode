package kotlin_part1.game.Game

import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

/**
 * Created by AU on 2017/07/14.
 */

private val title: String = "*** タイトル：数当てHit&Brow ***"
private val rule: String = "Rule-------------------------------------\n " +
        "\t・3回以内にランダムで設定されている数字（1〜9）を当てよ\n" +
        "\t・打鍵できる回数：3回まで\n" +
        "\t・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了\n" +
        "\t・入力した数値が想定内の数値でないの場合：Browのカウントアップ\n" +
        "\t応援：なるべくBrowのカウントアップせずにクリアしよう\n"

class GameTypeNumbers(val user: User) : GameType(title,rule) {

    // -------------------------------------------------------
    override fun checkInput(): Unit = user.checkInput()

    private fun User.checkInput(): Unit {
        do {
            var again: Boolean = try {
                println("数値を入力(1〜9のどれか1つ) : ")
                this.answer = Scanner(System.`in`).nextInt()
                false

            } catch (e: InputMismatchException) {
                println("入力値の型が違います：　$e")
                println("注意：1~9の数字を入力してください。")
                true
            }
        } while (again)
    }

    // -------------------------------------------------------
    override fun checkAnswer(answer: Int): Unit = user.checkAnswer(answer)

    private fun User.checkAnswer(answer: Int): Unit {
        if (this.answer === answer) this.hit++ else this.blow++
    }

    // -------------------------------------------------------
    override fun confirmUserresult(count: Int, answer: Int): Boolean {
        val resultText: String = "\n ******  結果 ****** \n"
        val congrats: String = "おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ \n"
        val regret: String = "残念でした(；一ω一||)"
        val uncorrect: String = "不正解(；一ω一||) \n"

        println(resultText)
        var result:Boolean = user.run {
            when {
                this.hit === 1 -> trueEnd(congrats)
                this.hit === 0 && count === 3 -> falseEnd(regret, answer)
                else -> falseAgain(uncorrect)
            }
        }
        return result
    }
}

private val falseAgain:(String) -> Boolean = {
    println(it)
    false
}

private val falseEnd:(String,Int) -> Boolean = {regret, answer ->
    println(regret)
    println("答えは【$answer】\n")
    false
}

private val trueEnd : (String) -> Boolean = {
    println(it)
    true
}
