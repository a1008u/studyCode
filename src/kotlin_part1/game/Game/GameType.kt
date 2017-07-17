package kotlin_part1.game.Game


/**
 * Created by AU on 2017/07/15.
 */

abstract class GameType(val title:String, val rule:String){
    abstract fun checkInput()
    abstract fun checkAnswer(answer: Int)
    abstract fun confirmUserresult(count: Int, answer: Int): Boolean
}