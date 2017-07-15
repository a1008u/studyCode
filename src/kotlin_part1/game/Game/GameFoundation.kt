package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/15.
 */

abstract class GameFoundation{

    abstract fun start(gameParts:GameTypeNumbers):Unit

    abstract fun doAgain(): Boolean
}