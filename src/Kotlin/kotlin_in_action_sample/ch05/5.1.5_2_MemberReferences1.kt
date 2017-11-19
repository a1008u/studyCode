package ch05.ex1_5_2_MemberReferences1

data class Person(val name: String, val age: Int)
fun Person.isAdult() = age >= 21

fun main(args: Array<String>) {
    // コンストラクタ参照(constructor reference) ::クラス名
    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p) // Person(name=Alice, age=29)

    // 拡張関数の利用
    val predicate = Person::isAdult
    println(predicate(p)) // true
    println(p.isAdult()) // true
}
