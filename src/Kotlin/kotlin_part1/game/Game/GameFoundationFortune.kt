package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/18.
 */

class GameFoundationFortune(val gameParts: GameType) : GameFoundation() {

    override fun start() {
        var fortune: Int = Random().nextInt(3) + 1

        println(gameParts.title)
        println(gameParts.rule)

        // input----------------------------------------------
        gameParts.checkInput()

        // checkAnswer----------------------------------------
        gameParts.checkAnswer(fortune)

        // fin------------------------------------------------
        gameParts.confirmUserresult(count=1, answer = fortune)

    }
}

