package kotlin_part1

/**
 * Created by AU on 2017/07/07.
 */

// クラスのジェネリックス
class Container<T>(var value: T)

interface Hoge2
interface Fuga2
class Foo2<T>
class Bar2<T: Hoge2>

interface piyo: Hoge2, Fuga2
class Baz2<T> where T:Hoge2, T:Fuga2


// 関数やプロパティのジェネリックス
fun <T> box(value: T) : Container<T> = Container(value)
val <T> T.string: String
    get() = toString()

fun main(args: Array<String>){
    // ジェネリックス関数
    val Container: Container<Int> = box(5)
    println(Container.string)

    // ジェネリック制約
    Foo2<Hoge2>() // OK
    Foo2<Fuga2>() // OK

    Bar2<Hoge2>() // OK
    // Bar2<Fuga2>() コンパイルエラー

    Baz2<piyo>()

    // 変位指定
    fun show(container: Container<out Any>){
        println(container.toString())
        println(container.hashCode())
        println(container.value)
    }

    val a: Container<String> = Container("Hello")
    val b: Container<out Any> = a
    // v.value = 123 NG

    class Container3<T>(var value: T){
        fun copyTo(to: Container3<in T>){
            to.value = value
        }
    }

    // 反変(contravariant)
    val a3: Container3<Int> = Container3(15)
    val b3: Container3<Number> = Container3(0)
    a3.copyTo(b3)
    println(b3.value) // 15


    // 宣言場所変位指定
    class Container4<T>(val value:T)
    class Container5<out T>(val value:T)
    // 上記で宣言場所変位指定を行なっているため、下記の書き方でも問題ない
    fun show5(container: Container5<Any>){
        println(container.toString())
        println(container.hashCode())
        println(container.value)
    }

    // スター投影
    val a6: Container<*> = Container<Int>(5)
    val b6: Container<*> = Container<String>("ABC")

    println(a6.value) // 5
    println(b6.value) // ABC

    // 具象型
    // inline fun <reified T> Any.instanceOf(): Boolean = this is T
    // "String".instanceOf<String>()

}

/* 変位指定
変位とは、不変、共変、反変の3種類がある。
不変(invariant)とは、下記の双方向にサブタイプの関係が成り立たない性質のこと。
 - 型Container<String>
 - 型Container<CharSequence>
var a: Container<String>  = Container("Hello")
var b: Container<CharSequence> = a // コンパイルエラー

fun show(container: Container<Any>){
    println(container.toString())
    println(container.hahsCode())
    println(container.value)
}

------------------------------------------------------
不変を解消する　→　型投影(type projection)
＊型に対する可能な操作を制限すること。

fun show(container: Container<out Any>){
    println(container.toString())
    println(container.hashCode())
    println(container.value)
}

val a: Container<String> = Container("Hello")
val b: Container<out Any> = a
// v.value = 123 NG

------------------------------------------------------
反変(contravariant)
＊型Container<String>が、型Container<CharSequence>のスーパータイプとなる性質のこと。
＊型投影により制限される操作：指定した型パラメータに対応する値の読み取り

class Container<T>(var value: T){
    fun copyTo(to: Container<in T>{
        to.value = value
    }
}

val a: Container<Int> = Container(15)
val b: Container<Number> = Container(0)
a.copyTo(b)
println(b.value) // 15

<まとめ>
変位：不変(修飾子：なし) X<A>はX<B>の間にサブタイプの関係が成り立たない　操作：入出力
変位：共変(修飾子：out) X<A>はX<B>のサブタイプとなる　操作：出力
変位：反変(修飾子：in) X<A>はX<B>のスーパタイプとなる　操作：入力

 */

/* 宣言場所変位指定
型投影は
対象のクラスやインターフェースを実際に使う場面で変位を指定していましたが、
これに対して宣言場所変位指定では、クラスの宣言場所(クラス定義コード上)で変位を指定することができる
*/

/* スター投影
対象の型パラメータに対応するオブジェクトの変更が行えなくなり、取得時には型Any?となる
*/






