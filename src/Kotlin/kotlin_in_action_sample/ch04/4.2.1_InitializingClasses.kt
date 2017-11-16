package ch04.ex2_1_InitializingClasses

// ()で囲まれた箇所をプライマリコンストラクタと呼ぶ
class User(val nickname: String,
           val isSubscribed: Boolean = true)

fun main(args: Array<String>) {
    val alice = User("Alice")
    println(alice.isSubscribed) // true

    val bob = User("Bob", false)
    println(bob.isSubscribed) // false

    val carol = User("Carol", isSubscribed = false)
    println(carol.isSubscribed) // false
}
