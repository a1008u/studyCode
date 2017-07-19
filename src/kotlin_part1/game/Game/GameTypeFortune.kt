package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/18.
 */



private val title: String = "=========== あなたの運勢を占います ==========="
private val rule: String = "Rule-------------------------------------\n " +
        "\t・ランダムで設定されている数字（1〜3）までで好きな値を1つ入力してください\n" +
        "\t・そこからあなたの今日の運勢を占います\n"

class GameTypeFortune(val user: User) : GameType(title,rule) {

    override fun checkInput(): Unit = user.checkInput()
    private fun User.checkInput(){
        do {
            var again: Boolean = try {
                println("数値を入力(1〜3のどれか1つ) : ")
                this.answer = Scanner(System.`in`).nextInt()
                false

            } catch (e: InputMismatchException) {
                println("入力値の型が違います：　$e")
                println("注意：1~3の数字を入力してください。")
                true
            }
        } while (again)
    }

    // -------------------------------------------------------------------
    override fun checkAnswer(answer: Int): Unit = user.checkAnswer(answer)
    private fun User.checkAnswer(answer: Int){

        when (Math.abs(this.answer - answer)) {
            0 -> println("超運がいい日だよ\n")
            1 -> println("無難な一日だよ\n")
            2 -> println("お察しします\n")
            else -> println("あなたの入力値では占うことができません\n")
        }

    }

    override fun confirmUserresult(count: Int, answer: Int): Boolean {
        return true
    }

}