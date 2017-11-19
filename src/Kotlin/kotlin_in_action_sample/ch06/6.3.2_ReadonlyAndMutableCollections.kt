package ch06.ex3_2_ReadonlyAndMutableCollections

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) target.add(item)
}

// 読み取り専用コレクションが、必ずイミュータブルではない
// 読み取り専用コレクションは、スレッドセーブではない
fun main(args: Array<String>) {
    val source: Collection<Int> = arrayListOf(3, 5, 7) // 読み専
    val target: MutableCollection<Int> = arrayListOf(1) // ミュータブル
    copyElements(source, target)
    println(target) // [1, 3, 5, 7]
}
