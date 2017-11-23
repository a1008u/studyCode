package ch09.CopyDataIn

// コピー先要素の型をコピー元要素の型のスーパタイプとすることを許可している
// JavaのMutablelist<? super T>に対応
fun <T> copyData(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) { destination.add(item) }
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)
    println(anyItems) // [1, 2, 3]
}
