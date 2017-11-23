package ch09.FieldValidator

import kotlin.reflect.KClass

// Tについての反変として宣言されたインターフェイス
interface FieldValidator<in T> {
    // Tはinポジションのみで使用される(このメソッドはTの値を消費する)
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

fun main(args: Array<String>) {
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator
}
