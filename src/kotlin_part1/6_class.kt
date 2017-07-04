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

    var tom = Person2()
    tom.name = "tom"
    println(tom.name)

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
    get() : Int {return this.name.length} // custom getter：対応プロパティが参照された時に呼び出されr、値を返す。

}

class Person2 {
    var name: String = ""
        set(value) {
            println("${value}がセットされました")
            // fieldはパッキングフィールドを表す暗黙変数
            field = value // name = value とするとカスタムセッターが無限に呼び出される
        }
    var age: Int = 0
    val nameLength: Int
        get() = this.name.length // custom getter：対応プロパティが参照された時に呼び出されr、値を返す。
}