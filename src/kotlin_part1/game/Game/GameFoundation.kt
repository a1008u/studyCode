package kotlin_part1.game.Game

import java.util.*

/**
 * Created by AU on 2017/07/15.
 */

abstract class GameFoundation{

    // abstract fun start(gameParts:GameType):Unit

    open fun doAgain(): Boolean {
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

    abstract fun start():Unit
}