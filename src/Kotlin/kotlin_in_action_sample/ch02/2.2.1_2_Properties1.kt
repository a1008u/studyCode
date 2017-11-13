package ch02.person

// 実装コードがないクラスを値オブジェクト(value object)と云う
// Kotlinではプロパティは第1級の言語機能
class Person(
        val name: String // 読み取り専用のプロパティ(フィールド + getter)
        , var isMarried: Boolean // 読み書き先王のプロパティ(フィールド + setter, getter(is))
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)
}
