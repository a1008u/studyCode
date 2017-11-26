package Kotlin.kotlin_in_action_sample.ch10

import ru.yole.jkid.deserialization.deserialize



// deserialize ::json形式をオブジェクトに変換
fun main(args: Array<String>) {
    val json = """{"name": "Alice", "age": 29}"""
    println(deserialize<Person>(json)) // Person(name=Alice, age=29)
}

