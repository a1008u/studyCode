package kotlin_part1.test

/**
 * Created by AU on 2017/07/20.
 */
fun main(args: Array<String>) {

    // ----------------------------------------------------------------------------
    val instrumentedSet = InstrumentedSet(HashSet<String>()).apply {
        add("hoge")
        add("fuga")
        addAll(listOf("a", "b", "c"))
    }
    println(instrumentedSet.addCount) // => 5

    // InstrumentedSetで定義していない実装は委譲先の実装が使われる
    println(instrumentedSet.contains("hoge")) // => true

    // ----------------------------------------------------------------------------
    val person2 = Person2(JapaneseGreeter)

    // personはgreet()メソッドを呼び出せる
    person2.greet2() // => こんにちは

    // personはGreeterのサブタイプ
    val greeter2: Greeter2 = person2
}

// ----------------------------------------------------------------------------
// 挨拶する人のインタフェース
interface Greeter2 {
    fun greet2()
}

// Greeterの実装クラス(というかオブジェクト)
object JapaneseGreeter: Greeter2 {
    override fun greet2() {
        println("こんにちは")
    }
}

// ここでClass Delegationを使っている
class Person2(greeter: Greeter2): Greeter2 by greeter

// ----------------------------------------------------------------------------
class InstrumentedSet<E>(private val s: MutableSet<E>) : MutableSet<E> by s {

    var addCount: Int = 0
        private set

    override fun add(e: E): Boolean {
        addCount++
        return s.add(e)
    }

    override fun addAll(c: Collection<E>): Boolean {
        addCount += c.size
        return s.addAll(c)
    }
}

/*

@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("StandardKt")
package kotlin

/**
 * An exception is thrown to indicate that a method body remains to be implemented.
 */
public class NotImplementedError(message: String = "An operation is not implemented.") : Error(message)

/**
 * Always throws [NotImplementedError] stating that operation is not implemented.
 */

@kotlin.internal.InlineOnly
public inline fun TODO(): Nothing = throw NotImplementedError()

/**
 * Always throws [NotImplementedError] stating that operation is not implemented.
 *
 * @param reason a string explaining why the implementation is missing.
 */
@kotlin.internal.InlineOnly
public inline fun TODO(reason: String): Nothing = throw NotImplementedError("An operation is not implemented: $reason")



/**
 * Calls the specified function [block] and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <R> run(block: () -> R): R = block()

/**
 * Calls the specified function [block] with `this` value as its receiver and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> T.run(block: T.() -> R): R = block()

/**
 * Calls the specified function [block] with the given [receiver] as its receiver and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

/**
 * Calls the specified function [block] with `this` value as its receiver and returns `this` value.
 */
@kotlin.internal.InlineOnly
public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }

/**
 * Calls the specified function [block] with `this` value as its argument and returns `this` value.
 */
@kotlin.internal.InlineOnly
@SinceKotlin("1.1")
public inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }

/**
 * Calls the specified function [block] with `this` value as its argument and returns its result.
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> T.let(block: (T) -> R): R = block(this)

/**
 * Returns `this` value if it satisfies the given [predicate] or `null`, if it doesn't.
 */
@kotlin.internal.InlineOnly
@SinceKotlin("1.1")
public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? = if (predicate(this)) this else null

/**
 * Returns `this` value if it _does not_ satisfy the given [predicate] or `null`, if it does.
 */
@kotlin.internal.InlineOnly
@SinceKotlin("1.1")
public inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? = if (!predicate(this)) this else null

/**
 * Executes the given function [action] specified number of [times].
 *
 * A zero-based index of current iteration is passed as a parameter to [action].
 */
@kotlin.internal.InlineOnly
public inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (index in 0..times - 1) {
        action(index)
    }
}




*/