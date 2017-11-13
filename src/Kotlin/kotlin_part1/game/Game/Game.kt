package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/15.
 */

fun main(args: Array<String>) {

    try{
        /* projectTitle and explain------------------------------------------ */
        val projectTitle: String = "*** GAME ***"
        val explain: String ="explain-------------------------------------\n " +
                "\t以下から好きなゲームを選択してください\n" +
                "\t1：数当てゲーム\n" +
                "\t2：占い\n" +
                "\t1or2以外の数字：ゲームをしない\n"
        println(projectTitle)
        println(explain)

        /* gameSet------------------------------------------ */
        val game: GameFoundation = when (Scanner(System.`in`).nextInt()) {
            1 -> GameFoundationNumbers(GameTypeNumbers(user = User()))
            2 -> GameFoundationFortune(GameTypeFortune(user = User()))
            // TODO endクラス
            else -> GameFoundationNumbers(GameTypeNumbers(user = User()))
        }

        /* game start------------------------------------------ */
        do game.start()
        while (game.doAgain())

    } catch(e: InputMismatchException) {
        println("入力値の型が違います： $e")
        println("注意：強制的に終了します。")
    }

}