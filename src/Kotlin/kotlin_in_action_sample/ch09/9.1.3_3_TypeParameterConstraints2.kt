package ch09.ex1_3_3_TypeParameterConstraints2

import java.time.Period


// 型パラメータに対する複数の制約の指定
// 型引数のCharSequenceとAppendableの両インターフェイスを必ず実装する
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) seq.append('.')
}

fun main(args: Array<String>) {
    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld) // Hello World.
}
