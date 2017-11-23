package ch09.CopyDataAny

/**
 * 宣言場所変位指定(declaration-site variance)
 * クラス宣言に変位修飾子を指定する機能は、クラスが使用される全ての場所に適用される
 *
 * 使用場所変位指定(use-site variance)
 * 型パラメータ付きの型を使用するたび、その型パラメータがサブタイプまたはスーパータイプで置換できるのかを指定できる
 */


// copy元の要素の型はcopy先の要素の型のサブタイプであるべき
fun <T: R, R> copyData(source: MutableList<T>, destination: MutableList<R>) {
    for (item in source) { destination.add(item) }
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems) // intはAnyのサブタイプなので、この関数を呼び出せる
    println(anyItems) // [1, 2, 3]
}
