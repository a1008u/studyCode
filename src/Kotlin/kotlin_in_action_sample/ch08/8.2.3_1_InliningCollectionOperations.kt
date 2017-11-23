package ch08.ex2_3_1_InliningCollectionOperations

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29)
                    , Person("Bob", 31))

// filter関数はインライン関数
// [Person(name=Alice, age=29)]
fun main(args: Array<String>) = println(people.filter { it.age < 30 })
