package kotlin_part1

/**
 * Created by AU on 2017/07/04.
 */

// 自動的にコンストラクタを作成する
class MyClass

fun main(args: Array<String>){

    // インスタンス化
    val myClass: MyClass = MyClass()
    println(myClass)

    val greeter = Greeter()
    greeter.greet("Kotlin") // Hello, Kotlin!

    var hanako = Person()
    println(hanako.name)
    println(hanako.age)
    hanako.name ="hanako"
    hanako.age = 25
    println(hanako.name) // hanako
    println(hanako.age)  // 25
    println(hanako.nameLength) //6

}

class Greeter{
    fun greet(name: String){
        println("Hello, $name!")
    }
}

class Person {
    var name: String = ""
    var age: Int = 0

    // バッキングフィールド：
    val nameLength: Int
    get() : Int {return this.name.length}

}