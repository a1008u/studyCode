package ch10.ex2_1_1_ReflectionAPI

import kotlin.reflect.KClass
import kotlin.reflect.memberProperties

/**
 * ■リフレクションとは
 * 事前に何らかのプロパティがあるかを知らずににオブジェクトのプロパティやメソッドを実行時に動的に参照する方法
 *
 * 【利用方法】
 * 1.java.lang.reflectパッケージ
 * 2.kotlin.reflectパッケージ
 */

/** 2.kotlin.reflectパッケージの例
 * Javaなど、各言語で備えるリフレクション機能のKotlin版。
 * クラス構造(プロパティなど)を読み取ったり書き換えたりする機能。
 * KClass(クラス参照)、KProperty(プロパティ参照),KFunction(メソッド参照)を利用する。
 */

class Person(val name: String, val age: Int)

// KotlinのClass参照はKClass型。
// javaすると、Java class referenceが取れる
fun main(args: Array<String>) {
    val person = Person("Alice", 29)

    // エントリポイント(クラスの取得)
    val kClass : KClass<Person> = person.javaClass.kotlin

    // classの確認
    println(kClass.simpleName) // Person

    // フィールドの確認
    kClass.memberProperties.forEach { println(it.name) } // age name
}
