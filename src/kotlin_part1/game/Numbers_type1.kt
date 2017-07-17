package kotlin_part1.game

import java.util.*

/**
 * Created by AU on 2017/07/14.
 */


// とりあえず、動くゲームを作成　→　これをkotlinらしく修正
fun main(args: Array<String>){

    /* title and rule------------------------------------------ */
    val title: String = "*** タイトル：数当てHit&Brow ***"
    val rule: String ="Rule-------------------------------------\n " +
            "\t・3回以内にランダムで設定されている数字（1〜9）を当てよ\n" +
            "\t・打鍵できる回数：3回まで\n" +
            "\t・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了\n" +
            "\t・入力した数値が想定内の数値でないの場合：Browのカウントアップ\n" +
            "\t応援：なるべくBrowのカウントアップせずにクリアしよう\n"

    println(title)
    println(rule)

    /* game start */

    var morePlay: Boolean = false
    do {

        var answer: Int = Random().nextInt(9) + 1

        var hit: Int =0
        var blow: Int=0
        var userInput: Int=0

        for (count in arrayOf(1,2,3)){

            println("*** " + count + "回目 ***")

            // input------------------------------------------------
            var again : Boolean = false
            do {
                println("数値を入力(1〜9のどれか1つ) : ")
                userInput = Scanner(System.`in`).nextInt()

                if(userInput>=10 || userInput ==0 ) {
                    again = true
                }
            }while (again)

            // answer------------------------------------------------
            if (userInput === answer){
                hit++
            }else{
                blow++
            }

            // fin------------------------------------------------
            val resultText:String = "\n ******  結果 ****** \n"
            val congrats: String = "おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ \n"
            val regret: String = "残念でした(；一ω一||)"
            var uncorrect: String = "不正解(；一ω一||) \n"

            println(resultText)
            if (hit === 1) {
                println(congrats)
                break
            } else {
                if (hit === 0 && count === 3) {
                    println(regret)
                    println("答えは【$answer】\n")
                } else println(uncorrect)
            }

        }

        println("もう１度ゲームをする場合：1")
        println("やめまーす：2")
        println("どちらにしますか？：")
        morePlay = Scanner(System.`in`).nextInt() == 1

    }while (morePlay)

}