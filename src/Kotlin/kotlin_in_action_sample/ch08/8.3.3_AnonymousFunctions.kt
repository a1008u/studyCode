package ch08.ex3_3_AnonymousFunctions

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29)
                    , Person("Bob", 31))

// 無名関数は、戻り値の方を指定するため、通常の関数と同じルールに従う
// returnは、funキーワードを使って宣言された最も近い関数からリターンする
fun lookForAlice(people: List<Person>) {
    // forEachの中身を無名関数として記載
    people.forEach(fun (person) { if (person.name == "Alice") return
                                           println("${person.name} is not Alice")
                                         })
}

fun main(args: Array<String>) = lookForAlice(people) // Bob is not Alice

