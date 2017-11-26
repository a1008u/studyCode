package ch10.ex2_1_2_ReflectionAPI1

import kotlin.reflect.KFunction

fun foo(x: Int) = println(x + 1)


// KCallableは、関数とプロパティのスーパーインターフェイス
// callメソッドから対応する関数orプロパティのgetterを呼び出すことができる
fun main(args: Array<String>) {
    // public interface KCallable<out R> : KAnnotatedElement {}
    val kFunction= ::foo

    // public fun call(vararg args: Any?): R
    kFunction.call(42) // 43
}
