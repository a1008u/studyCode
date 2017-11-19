package ch06.ex1_11_1_2_PlatformTypes1

import Kotlin.kotlin_in_action_sample.ch06.Person

// PersonはJavaで定義されている
// プラットフォーム型はJavaのフィールドに対して、@Nullableや@NotNullなどの明記がされていないこと
fun yellAtSafe(person: Person) = println((person.name ?: "Anyone").toUpperCase() + "!!!")

// プラットフォーム型を意識せず、nullチェックを省いてメソッドを定義した例
fun yellAtSafe2(person: Person) = println(person.name.toUpperCase() + "!!!")

fun main(args: Array<String>) {
    yellAtSafe(Person(null)) // ANYONE!!!
    yellAtSafe2(Person(null)) // kotlin.TypeCastException: null cannot be cast to non-null type java.lang.String
}
