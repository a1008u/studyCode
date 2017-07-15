package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/15.
 */
class GameFoundationNumbers: GameFoundation() {

    override fun start(gameParts:GameTypeNumbers):Unit {
        var answer: Int = Random().nextInt(9) + 1

        println(gameParts.title)
        println(gameParts.rule)
        for (count in arrayOf(1, 2, 3)) {

            println("*** " + count + "回目 ***")

            // input----------------------------------------------
            gameParts.checkInput()

            // checkAnswer----------------------------------------
            gameParts.checkAnswer(answer)

            // fin------------------------------------------------
            if (gameParts.confirmUserresult(count, answer)) break
        }
    }

    override fun doAgain(): Boolean {
        var morePlay: Boolean = false
        try {
            println("もう１度ゲームをする場合：1")
            println("やめまーす：1以外の数値")
            println("どちらにしますか？：")
            morePlay = Scanner(System.`in`).nextInt() == 1
        } catch(e: InputMismatchException) {
            println("入力値の型が違います： $e")
            println("注意：強制的に終了します。")
        }
        return morePlay
    }
}