package kotlin_part1

/**
 * Created by AU on 2017/07/05.
 */

// インタフェーズの定義と実装----------------------------------------------------
// デフォルト実装とコンフリクトの回避---------------------------------------------
// インタフェースの継承---------------------------------------------------------
// デリゲーション--------------------------------------------------------------

// インタフェーズの定義と実装----------------------------------------------------
// 実装するオブジェクトの境界におけるプロトコル（規約、取り決め）を表現するもの
interface Greeter3{
    val language: String
    fun sayHello(target: String)
}

// 実装は複数のインターフェース指定可能、継承は１つのみ
class EnglishGreeter2 : Greeter3 {
    override val language = "English"
    override fun sayHello(target: String) {
        println("Hello, $target!")
    }
}

// 複数実装
open class Superclass

interface FFF
interface BBB

class MyCCC: Superclass(), FFF, BBB

// デフォルト実装とコンフリクトの回避---------------------------------------------
// interfaseの実装①
interface Foo3 {
    fun execute()
}

interface Bar3 {
    fun execute()
}

class FooBar : Foo3, Bar3 {
    override fun execute() = print("FooBar")
}

// interfaceの実装②
interface Foo4 {
    fun execute()
}

open class Superclass4{
    open fun execute() = println("Superclass")
}

class FooSubclass : Superclass4(), Foo4

// interfaceの実装③　実装できない
interface Hoge5{
    fun execute() = println("Hoge")
}
interface Fuga5{fun execute() = println("Fuga")}

// class HogeFuga: Hoge5, Foga5 コンパイルエラー(executeの実装が曖昧なため)
// オーバーライド時にexecuteの実装を明確にする
class HogeFuga : Hoge5, Fuga5 {
    override fun execute() = super<Fuga5>.execute()
}

// インタフェースの継承---------------------------------------------------------
interface FOO {
    fun aaa()
    fun bbb()
}

interface BAR: FOO {
    override fun aaa(){}
    fun ccc()
}

class BAZ: BAR {
    override fun bbb() {}
    override fun ccc() {}
}

// デリゲーション--------------------------------------------------------------
// 例---------------------------------------
interface Greeter7 {
    fun sayHello(target: String)
    fun sayHello()
}

open class JapaneseGreeter7: Greeter7{
    override fun sayHello(target: String) = println("こんにちは、$target!")
    override fun sayHello() = print("こんにちは、匿名さん")
}

// 名前を記憶する機能をつける（欠陥あり）
class JapaneseGreeterWithRecording7 : JapaneseGreeter7() {
    private val _targets: MutableSet<String> = mutableSetOf()

    val targets: Set<String>
     get() = _targets

    override fun sayHello(target: String) {
        _targets += target
        super.sayHello(target)
    }
}

// 委譲
class JapaneseGreeterWithRecording : Greeter7{
    private val greeter: Greeter7 = JapaneseGreeter7()

    private val _targets: MutableSet<String> = mutableSetOf()

    val targets: Set<String>
    get() = _targets

    override fun sayHello() = greeter.sayHello()

    override fun sayHello(target: String) {
        _targets += target
        greeter.sayHello(target)
    }
}

// デリゲーション(委譲の代わりに)
// by greeter：このクラスは、インタフェースGreeterを実装するけど、オーバライドしていないメンバは、greeterに委譲するよという表明
class GreeterWithRecording(private val greeter: Greeter7): Greeter7 by greeter{
    private val _targets: MutableSet<String> = mutableSetOf()

    val targets: Set<String>
        get() =_targets

    override fun sayHello(target: String) {
        _targets += target
        greeter.sayHello(target)
    }
}
