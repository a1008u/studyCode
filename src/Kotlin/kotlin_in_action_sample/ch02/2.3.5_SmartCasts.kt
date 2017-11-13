package ch02.ex3_5_SmartCasts

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// SmarCast:::目的の型かチェックすれば、その変数を後からキャストする必要がなくなる(別変数への格納不要)
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // Numへの明示的なキャストは冗長
        return n.value
    }
    if (e is Sum) return eval(e.right) + eval(e.left) // eはスマートキャスト
    throw IllegalArgumentException("Unknown expression")
}

fun main(args: Array<String>) = println(eval(Sum(Sum(Num(1), Num(2)), Num(4)))) // 7

