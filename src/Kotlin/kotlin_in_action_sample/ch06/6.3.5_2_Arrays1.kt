package ch06.ex3_5_2_Arrays1

/*
Kotlinで配列を作成
1.arrayOf関数:引数として指定された要素を含む配列を作成
2.arrayOfNulls関数:与えられたサイズのnullを含む配列を作成。null許容型の配列を作成するためだけにも使用
3.Arrayコンストラクタ:配列のサイズとラムダを引数にとり、各要素をラムダを呼び出して初期化する
*/
fun main(args: Array<String>) {
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString("")) // abcdefghijklmnopqrstuvwxyz
}
