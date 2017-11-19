package ch05.ex1_3_3_SyntaxForLambdaExpressions2

fun main(args: Array<String>) {
    // コードブロック内に入れる必要がある場合は、渡されたラムダを実行するライブラリ関数runを利用する
    run { println(42) }
}
