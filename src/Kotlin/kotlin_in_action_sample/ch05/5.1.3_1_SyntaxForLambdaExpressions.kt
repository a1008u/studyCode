package ch05.ex1_3_1_SyntaxForLambdaExpressions

fun main(args: Array<String>) {

    // ラムダ式を変数に格納して利用する
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
}
