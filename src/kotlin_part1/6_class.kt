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

    // コンストラクタとイニシャライザ
    val half = Rational(1,2)
    println(half.numerator) // 1
    println(half.denominator) // 2

    val halfR = RationalR(1,2)
    println(halfR.numerator) // 1
    println(halfR.denominator) // 2

    // セカンダリコンストラクタ
    val halfRR = RationalRR(1,2)
    println("${halfRR.numerator}/${halfRR.denominator}") // 1/2を出力

    val halfRR2 = RationalRR(5)
    println("${halfRR2.numerator}/${halfRR2.denominator}") // 5/1を出力


    // イニシャライザ
    RationalRR2(1,1)
    // RationalRR2(1,0) error

    // エクステンション(拡張関数)
    countWords("I like Kotlin") // 2（通常）
    "I like Kotlin".contWords() // 2（拡張関数）
    println("I like Kotlin".wordsCount) // 2(拡張プロパティ)

}

class Greeter{
    fun greet(name: String){
        println("Hello, $name!")
    }
}

class Person {
    var name: String = ""
    var age: Int = 0

    // バッキングフィールド：必ず初期化が必要
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

// 遅い初期化
class MyClass2{
    lateinit var foo: String
}

// コンストラクタとイニシャライザ
// constructorを利用する
class Rational constructor(n: Int, d:Int){
    val numerator: Int = n
    val denominator: Int = d
}

// 引数にvalやvarを用いてインスタンス化する
class RationalR(val numerator: Int, val denominator:Int)


// セカンダリコンストラクタ
// プライマリコンストラクタ：numerator
// セカンダリコンストラクタ：denominator
class RationalRR(val numerator: Int, val denominator: Int){
    // セカンダリコンストラクタの引数リストの後に、:記号を挟んで、プライマリコンストラクタを呼び出す
    constructor(numerator: Int) : this(numerator, 1)
}

// こっちの方が楽かな
class RationalRR2(val numerator: Int, val denominator: Int = 1)


// イニシャライザ
class RationalS(val numerator: Int, val denominator: Int = 1){
    init{
        require(denominator != 0 )
    }
}

// エクステンション（拡張関数）：パッキングフィールドを持てない
// 通常の関数：空白文字で分割して得られたリストの要素数を返す
fun countWords(s: String): Int = s.split("""\s+"""".toRegex()).size

// 拡張関数:既存のクラスに対して、その定義に手を加えず、メソッドの追加をするような仕組み
fun String.contWords(): Int = this.split("""\s+"""".toRegex()).size

// 拡張プロパティ
val String.wordsCount: Int
    get() = split("""\s+"""".toRegex()).size // カスタムgetter(thisの省略)
