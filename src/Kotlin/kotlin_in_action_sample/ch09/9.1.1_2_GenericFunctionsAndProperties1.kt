package ch09.ex1_1_2_GenericFunctionsAndProperties1

// ＜T＞ - 型パラメータ　＊型パラメータは、レシーバと戻り値の型で使用される
// ジェネリック拡張プロパティは任意のリストで呼び出し可能
val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).penultimate) // 3
}
