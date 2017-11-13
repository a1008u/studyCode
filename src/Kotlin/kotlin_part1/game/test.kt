package kotlin_part1.game

import java.util.*

/**
 * Created by AU on 2017/07/14.
 */


// とりあえず、動くゲームを作成　→　これをkotlinらしく修正
fun main(args: Array<String>) {


        val listNumber2 = listOf(Math.abs(Random().nextInt(100))
                , Math.abs(Random().nextInt(100)))

        println(listNumber2)

        var aaa =listNumber2.apply {
            var A = this.iterator().next()
            this.iterator().forEach {
                if(it > A)   println("$it  【1番目の数値の方が大きい】")
                if(it === A) println("$it  【1番目と2番目は同じ数値です】")
                if(it < A)   println("$it  【2番目の数値の方が大きい】")
            }
        }
}

