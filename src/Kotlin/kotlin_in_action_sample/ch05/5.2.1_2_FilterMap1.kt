package ch05.ex2_1_2_FilterMap1

data class Person(val name: String, val age: Int)

// filter関数は不要な要素をコレクションから取り除きますが、要素自体は変更しない
fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 }) // [Person(name=Bob, age=31)]
}
