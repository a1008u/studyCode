package ch05.ex2_3_1_GroupBy

data class Person(val name: String, val age: Int)

/* groupBy リストのグループ化
public inline fun <T, K> Iterable<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
    return groupByTo(LinkedHashMap<K, MutableList<T>>(), keySelector)
}
*/
fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 31)
                                     , Person("Bob", 29)
                                     , Person("Carol", 31))

    println(people.groupBy { it.age }) // 戻り値はMap<Int, List<Person>>
    // {31=[Person(name=Alice, age=31), Person(name=Carol, age=31)], 29=[Person(name=Bob, age=29)]}
}
