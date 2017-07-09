package kotlin_part1

import kotlin.reflect.KProperty

/**
 * Created by AU on 2017/07/09.
 */

fun main(args: Array<String>){

    // 演算子オーバロード---------------------------------------------------------------------
    // あるメソッドを対応する演算子で呼び出すためには、そのメソッドに修飾子operatorを付ける必要がある。
    class MyInt(val value: Int) {
        operator fun times(that: MyInt): MyInt = MyInt(value * that.value)
    }

    val product = MyInt(3)* MyInt(5)
    println(product.value) // 15

    // 拡張関数の場合
    operator fun MyInt.mod(that: MyInt): MyInt = MyInt(value % that.value)
    println((MyInt(20) % MyInt(3)).value) //2

    // オブジェクト自体が関数の用に呼び出せるようにする
    class Service{
        operator fun invoke(): Char = 'A'
        operator fun invoke(c: Char) = c
    }

    val service = Service()
    println(service())    // A
    println(service('B')) // B
    println(service.invoke('C')) // C


    // 等価性---------------------------------------------------------------------------------
    // 「===演算子：２つの参照が等価であるかをテスト」
    val a = setOf(1)
    val b = a
    println(if (a===b) true else false) // true
    println(if(a === setOf(1)) true else false ) // false
    println(if(b !== setOf(1)) true else false ) // true
    println(if(a === null) true else false) // false
    println(if(null === null) true else false) // true

    val i: Int? =127
    println(if(i === 127) true else false) // true
    val j: Int? = 128
    println(if(j === 128) true else false) // false(intは-128〜127までのため)

    // 2つのオブジェクトの構造上の等価性をテストするには「==演算子」を使用する
    class MyInt2(val value:Int){
        // equalsは、Anyで定義されているため、それをオーバーロードする
        override fun equals(other: Any?): Boolean = if(other is MyInt) value == other.value else false
    }
    println(if(MyInt2(2) == MyInt2(2)) true else false) // true
    println(if(MyInt2(1) == MyInt2(3)) true else false) // false
    println(if(MyInt2(1) != MyInt2(2)) true else false) // true


    // 中値呼び出し----------------------------------------------------------------------------
    // メソッド呼び出しが、組み込みの命令のように見える記法のこと
    class MyInt3(val value: Int){
        infix fun plus(that: MyInt3): MyInt3 = MyInt3(value + that.value)
    }
    println((MyInt3(1) plus MyInt3(2)).value) // 3

    // infix指定されたメソッド(Kotlin標準ライブラリ)
    println(5 shl 2) // 20
    println(0b1010 ushr 1)  // 5
    println(true and false) // false
    println(true xor false) // true
    println((1..10 step 3).toList()) //[1, 4, 7, 10]
    println((100 downTo 0 step 20).toList()) //[100, 80, 60, 40, 20, 0]


    // 分解宣言-------------------------------------------------------------------------------
    // 標準ライブラリのPairクラスを利用する
    val pair = Pair("Taro", 27)
    println(pair.first) // Taro
    println(pair.second) // 27

    // オブジェクトを分解して、複数の変数に、そのオブジェクトのデータを代入する機能を、分解宣言(destructuring declaration)
    val(name, age) = Pair("Taro", 27)
    println(name)
    println(age)

    // ルール
    // operator付きメソッドcomponentNの存在です（Nは整数に置き換わります）
    val (c, d, e) = object{
        operator fun component1(): String = "Hello"
        operator fun component2(): Int = 123
        operator fun component3(): List<Char> = listOf('A', 'B')
    }
    println(c) // Hello
    println(d) // 123
    println(e) // [A, B]


    // データクラス----------------------------------------------------------------------------
    // Anyクラスをデータクラスに持たせる方法(dataによるデータクラスによって、equals,hashCode,toStringの実装が手に入る)
    data class User(val id: Long, val name: String)
    println(if(User(1,"Taro") == User(1,"Taro")) true else false) // true
    println(User(2," Hanako")) // User(id=2, name= Hanako) [toStringメソッド]

    val taro = User(1, "Taro")
    println(taro) // User(id=1, name=Taro)
    val newTaro = taro.copy(id=112233)
    println(newTaro) // User(id=112233, name=Taro)
    println(taro)    // User(id=1, name=Taro)

    // データクラスは、書くプロパティに対応するメソッドcomponentNも自動生成してくれる
    val(id2, name2) = User(1, "Taro")
    println(id2)  // 1
    println(name2) // Taro


    // ネストしたクラス-------------------------------------------------------------------------
    // 内部クラス(inner class)
    // 外部クラスのオブジェクトの参照を囲むような、内部のクラスも定義可能(修飾しinnerを付けて、単なる内側のクラスと区別する)
    data class User2(val id: Long, val name: String){
        inner class Action{
            fun show(): String = "$name($id)"
        }
    }
    val user = User2(123, "Taro")
    val action : User2.Action = user.Action()
    println(action.show()) // Taro(123)


    // オブジェクト式---------------------------------------------------------------------------
    // オブジェクトリテラル：キーワードobjectの後に波括弧を展開し、オブジェクトを定義し、生成して返す
    val myObject = object{ fun greet(){ println("Hello") } }
    println(myObject) //
    println(myObject.greet()) // Hello

    val ggreeter = object: Ggreeter{ override fun greet(){println("Hello")} }
    println("ggreeter.greet() : " + ggreeter.greet()) // Hello


    // オブジェクト宣言---------------------------------------------------------------------------
    // シングルトンなクラスを定義する(class → objectを使用することで、クラス名で唯一のオブジェクトを参照することができるようになる)
    // コンストラクタを記述することはできず、呼び出すこともできない
    JapaneseGreeter4.greet("たろう") // こんにちは、たろうさん
    val greeter4: JapaneseGreeter4 = JapaneseGreeter4
    greeter4.greet("じろう") // こんにちは、じろうさん


    // コンパニオンオブジェクト-------------------------------------------------------------------
    // 1つのクラスにつき1つまでしか存在できない
    // コンパニオンオブジェクトは名前を省略することが可能
    val dummy = User5.Pool.DUMMY
    println("${dummy.id}, ${dummy.name}") // 0, dummy
    println(User5.DUMMY.name) // dummy

    // 名前を省略した場合の比較(Companionを利用する)
    println(if(User6.Companion.DUMMY === User6.DUMMY) true else false)


    // 代数的データ型---------------------------------------------------------------------------
    // 直和型
    class Cons<T>(val head: T, val tail: MyList<T>) : MyList<String> {override fun toString() = "$head:$tail"}
    println(Cons("foo", Cons("baz", Nil)))

    fun headString(list: MyList<*>): String =when (list){is Cons<*> -> list.head.toString() else -> "要素なし"}
    println(headString(Cons("foo",Nil))) // foo
    println(headString(Nil)) // 要素なし

    // シールドクラス(継承可能な範囲をコントロールする)
    // class Hoge: MyList2<Any>() error

    fun headString(list2: MyList2<*>): String =
            when(list2){
                is MyList2.Cons<*> -> list2.head.toString()
                is MyList2.Nil -> "要素なし"
            }
    println(headString(Cons("foo",Nil))) // foo
    println(headString(Nil)) // 要素なし

    // 列挙型
    val myFavoriteSize: DrinkSizeType = DrinkSizeType.Large
    println(myFavoriteSize) // kotlin_part1.DrinkSizeType$Large@41629346

    // enum
    val myFavoriteSize2: DrinkSizeType2 = DrinkSizeType2.LARGE
    print(myFavoriteSize2) // LARGE
    println(DrinkSizeType3.SMALL.milliliter) // 300

    println(DrinkSizeType4.MEDIUM.message()) // 無難な選択だ
    val types: Array<DrinkSizeType4> = DrinkSizeType4.values()
    println(types.toList()) //[SMALL, MEDIUM, LARGE]
    println(DrinkSizeType4.valueOf("LARGE")) // LARGE
    // println(DrinkSizeType4.valueOf("EXTRA_LARGE")) // IllegalArgumentExcepiton
    println(DrinkSizeType4.values().map { type -> type.ordinal }) // [0, 1, 2]


    // 例外-----------------------------------------------------------------------------------
    // try-catchによる例外の捕捉は義務付けられていない
    class MyException(message: String): Exception(message)
    // throw MyException("例外だよ")

    // try-catch-finally
    println(try{ println(1)} catch(e: Exception){println(2)} finally { println(3)})

    println(try{"123".toInt()} catch(e: Exception){null}) // 123

    println(try {"ONE".toInt()}
            catch (e:Exception) {null}
            finally { println("finally") })


    // メソッドの関数オブジェクト-----------------------------------------------------------------
    // 通常の感と同じようにメソッドの関数オブジェクトを取得することも可能。
    println(5.inc()) // 6
    val method = Int::inc
    println(method) // fun kotlin.Int.inc(): kotlin.Int

    // レシーバの型.(引数の型リスト)　-> 戻り値の型
    // メソッドの関数オブジェクトは、メソッドのように呼び出すということです
    val method2: Int.()-> Int = Int::inc
    println(123.method2()) // 124

    // public infix fun and(other: Int): Int
    val andObject2: Int.(Int) -> Int = Int::and
    println("andObject"+ 5.andObject2(10)) // 2

    // A.(B)->Cのような型は、型(A,B)->Cのサブタイプ
    val a2: Int.(Int) -> Int = Int::and
    val b2: (Int, Int) -> Int = a2
    println(b2(0b1100,0b1000)) // 8

    // ラムダ式
    println(listOf(1,2,3).map{it.inc()}) // [2,3,4]
    println(listOf(1,2,3).map(Int::inc)) // [2,3,4]

    val length: String.() -> Int = String::length
    println(listOf("Java", "Kotlin").map(length)) // [4,6]


    // 委譲プロパティ---------------------------------------------------------------------------
    // プロパティのアクセスがあった際に、その後の処理を別のオブジェクトに委譲します。
    class MyClass2{
        var _str: String? = null
        var str: String? by object {
            operator fun getValue(thisRef: MyClass2,
                                  property: KProperty<*>): String?{
                println("${property.name}がgetされました")
                return _str
            }

            operator fun setValue(thisRef: MyClass2,
                                  property: KProperty<*>, value: String?) {
                println("${property.name}に${value}がsetされました")
                _str = value
            }
        }
    }

    val myClass2 = MyClass2() // strがgetされました
    println(myClass2.str) // null
    myClass2.str = "ラーメン" //strにラーメンがsetされました
    println(myClass2.str) // strがgetされました ラーメン


    // アノテーション---------------------------------------------------------------------------
    /*
    class UserService{
        @Inject
        lateinit var userRepository: UserRepository
    }
    */

}

// オブジェクト式----------------------------------------------------------------------------
interface Ggreeter { fun greet() }

// オブジェクト宣言----------------------------------------------------------------------------
interface Greeter4 { fun greet(name: String) }
object JapaneseGreeter4: Greeter4{ override fun greet(name: String){ println("こんにちは、${name}さん") }}

// コンパニオンオブジェクト----------------------------------------------------------------------------
// シングルトンオブジェクトをクラス内に定義するには、キーワードcompanionを修飾する
class User5(val id: Long, val name: String){companion object Pool {
    val DUMMY = User5(0, "dummy")
}}

// object名省略----------------------------------------------------------------------------
class User6(val id: Long, val name: String){companion object {
    val DUMMY = User6(0, "dummy")
}}

// 代数的データ型-----------------------------------------------------------------------------
interface MyList<out T>
object Nil: MyList<Nothing>{fun toSting()="Nil"}

//シールドクラスとは、そのクラスの継承可能な範囲を制御するようなクラスのこと
// 修飾子sealedを伴い、そのクラスを継承可能なのは、ネスとされたクラスに限定されたMyListをシールドクラスとして、改めてリストを実施します
sealed class MyList2<out T>{
    object Nil: MyList2<Nothing>(){
        override fun toString() = "Nil"
    }
    class Cons<T>(val head: T, val tail: MyList2<T>): MyList2<T>(){override fun toString() = "$head:$tail"}
}

// 列挙型
sealed class DrinkSizeType{
    object small: DrinkSizeType()
    object Medium: DrinkSizeType()
    object Large: DrinkSizeType()
}

enum class DrinkSizeType2{
    SMALL,MEDIUM,LARGE
}

enum class DrinkSizeType3(val milliliter: Int){
    SMALL(300), MEDIUM(350), LARGE(500)
}

enum class DrinkSizeType4(val milliliter: Int){
    SMALL(300) {override fun message(): String = "少ないよ"}
    , MEDIUM(350){override fun message(): String = "無難な選択だ"}
    , LARGE(500){override fun message(): String = "流石に飲み過ぎ"};

    abstract fun message(): String
}