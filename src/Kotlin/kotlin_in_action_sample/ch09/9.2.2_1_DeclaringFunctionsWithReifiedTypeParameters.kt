package ch09.ex2_2_1_DeclaringFunctionsWithReifiedTypeParameters

// インライン関数の型パラメータは、具象化、つまり、実行時に実際の型引数を参照できる
// reifiedは型パラメータが実行時に削除されないことを宣言
inline fun <reified T> isA(value: Any) = value is T

fun main(args: Array<String>) {
    println(isA<String>("abc")) // true
    println(isA<String>(123))   // false
}
