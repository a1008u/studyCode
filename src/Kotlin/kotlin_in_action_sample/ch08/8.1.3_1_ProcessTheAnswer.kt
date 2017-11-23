@file:JvmName("ProcessTheAnswer")
package ch08.ProcessTheAnswer

// 関数型の変数はFunctionNインタフェースの実装
/* Kotlin declaration */
fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}
