package ch08.ex3_2_3_ReturningFromLambdas2

// [1, 2, 3]
fun main(args: Array<String>) {
    // ラムダの暗黙的なレシーバはthis@sbを参照する
    println(StringBuilder().apply sb@{
       listOf(1, 2, 3).apply {
           // this@sb - 外部のレシーバに明示的なラベル経由で参照
           // this - スコープ内で最も内側の暗黙のレシーバを参照
           this@sb.append(this.toString())
       }
    })
}
