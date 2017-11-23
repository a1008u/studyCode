package ch09.CopyDataOut


// 型の使用方法にoutキーワードを追加できる：「in」ポジションにあるTを持つメソッドは使われていない

// 型投影(type projection)
// 型の宣言において、型パラメータの任意の使用方法に変位修飾子を指定できます。
// 関数の引数の型、ローカル変数の型、関数の戻り値の型などです。

// 投影された(projected)MutableListを指定
// 正確に言うと、型パラメータをoutポジションで使用するメソッドのみを呼び出すことができる
// JavaのMutablelist<? extends T>に対応
fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) { destination.add(item) }
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)
    println(anyItems) // [1, 2, 3]
}
