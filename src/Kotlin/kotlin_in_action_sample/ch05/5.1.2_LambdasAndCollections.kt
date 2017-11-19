package ch05.ex1_2_LambdasAndCollections

data class Person(val name: String, val age: Int)


// ラムダを利用せずに自前でメソッドを実装
fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people) // Person(name=Bob, age=31)

    // ライブラリ関数利用
    println(people.maxBy({ p:Person -> p.age })) // Person(name=Bob, age=31) 短縮構文を利用しない
    println(people.maxBy() { p:Person -> p.age }) // 改善① ラムダ式が関数呼び出しの最後の引数であればカッコの外に移動
    println(people.maxBy{ p:Person -> p.age }) // 改善② ラムダが関数の唯一の引数であれば、関数呼び出し空からのカッコを取り除く
    println(people.maxBy{ p -> p.age }) // 改善③　型推論機能を利用する
    println(people.maxBy{ it.age }) // 改善④ itを利用する

    println(people.maxBy(Person::age)) // Person(name=Bob, age=31) メンバ参照（ラムダが単に関数やプロパティを呼び出す場合）
}
