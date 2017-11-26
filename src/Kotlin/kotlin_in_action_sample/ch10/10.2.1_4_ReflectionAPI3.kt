package ch10.ex2_1_4_ReflectionAPI3

class Person(val name: String, val age: Int)


/**
 * メンバプロパティはKProperty1インタフェイスのインスタンで表わされ、
 * そのインスタンスは引数が1つのgetメソッドを持っている
 * 値を参照するには、その値に対するオブジェクトのインスタンスが必要。
 */
fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val memberProperty = Person::age

    // ageフィールドの呼び出し
    println(memberProperty.get(person)) // 29
    println(memberProperty.getter.call(person)) // 29
}
