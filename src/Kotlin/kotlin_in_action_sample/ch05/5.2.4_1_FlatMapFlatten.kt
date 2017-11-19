package ch05.ex2_4_1_FlatMapFlatten

// flatMapとflatte　ネストされたコレクション内の要素操作
/* flatMap ＊引数として与えられた関数に従って各要素をコレクションに変更(map)、次にいくつかのリストを1つに統合(flat)
public inline fun <T, R> Iterable<T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}

public inline fun <T, R, C : MutableCollection<in R>> Iterable<T>.flatMapTo(destination: C, transform: (T) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
*/
fun main(args: Array<String>) {
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() }) // [a, b, c, d, e, f]
}
