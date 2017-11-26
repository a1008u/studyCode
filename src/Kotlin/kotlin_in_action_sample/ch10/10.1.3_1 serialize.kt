package Kotlin.kotlin_in_action_sample.ch10

import ru.yole.jkid.serialization.serialize


data class Person(val name: String, val age :Int)


// serialize ::オブジェクトをjson形式に変換
fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    println(serialize(person)) // {"age": 29, "name": "Alice"}
}

