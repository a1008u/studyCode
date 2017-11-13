package kotlin_part1

import kotlin.reflect.KProperty

/**
 * Created by AU on 2017/07/09.
 */

// 演算子オーバロード--------------------------------------------------------------
// 等価性-------------------------------------------------------------------------
// 中置呼び出し--------------------------------------------------------------------
// 分解宣言-----------------------------------------------------------------------
// データクラス--------------------------------------------------------------------
// ネストしたクラス-----------------------------------------------------------------
// オブジェクト式-------------------------------------------------------------------
// オブジェクト宣言-----------------------------------------------------------------
// コンパニオンオブジェクト----------------------------------------------------------
// 代数的データ型-------------------------------------------------------------------
// 例外----------------------------------------------------------------------------
// メソッドの関数オブジェクト---------------------------------------------------------
// 委譲プロパティ-------------------------------------------------------------------
// アノテーション-------------------------------------------------------------------


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
    // - メンバ関数か拡張関数
    // - 引数が１つだけ
    // - 関数にinfixキーワードが付けられている
    class MyInt3(val value: Int) {
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

}