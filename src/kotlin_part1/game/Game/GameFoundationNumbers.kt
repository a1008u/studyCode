package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/15.
 */
class GameFoundationNumbers(val gameParts: GameType) : GameFoundation() {

    override fun start() {
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
}