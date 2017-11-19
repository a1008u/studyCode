package ch05.ex1_3_4_SyntaxForLambdaExpressions3

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val names = people.joinToString(separator = " ", transform = { p: Person -> p.name })
    println(names) // Alice Bob

    // カッコの外にラムダを置く
    val names2 = people.joinToString(" "){p: Person -> p.name }
    println(names2) // Alice Bob

    val names3 = people.joinToString(" "){ (name) -> name }
    println(names3) // Alice Bob

    val names4 = people.joinToString(" "){ it.name }
    println(names4) // Alice Bob

}
