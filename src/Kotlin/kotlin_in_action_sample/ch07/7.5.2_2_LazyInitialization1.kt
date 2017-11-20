package ch07.ex5_2_2_LazyInitialization1

class Email { /*...*/ }
fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

// lazy関数は、byと利用することで、委譲プロパティを作成できる。 スレッドセーフ
// @kotlin.jvm.JvmVersion
// public fun <T> lazy(initializer: () -> T): Lazy<T> = SynchronizedLazyImpl(initializer)
class Person(val name: String) {
    val emails by lazy { loadEmails(this) }
}

fun main(args: Array<String>) {
    val p = Person("Alice")
    p.emails // Load emails for Alice
    p.emails
}
