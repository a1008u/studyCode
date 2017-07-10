package kotlin_part1

import com.sun.tools.doclint.DocLint

/**
 * Created by AU on 2017/07/05.
 */


// クラスの継承--------------------------------------------------------------
// メンバのオーバライド-------------------------------------------------------
// スーパタイプとサブタイプ----------------------------------------------------
// Any----------------------------------------------------------------------
// 抽象クラス-----------------------------------------------------------------
// 可視性--------------------------------------------------------------------

// クラスの継承--------------------------------------------------------------
// 継承の基本
// Person1のスーパークラスはAnyクラスです。（JavaのObjectかな）
// openをつけることで、継承ができる
open class Person1(open val name: String){
    open fun introduceMyself(){
        println("I am $name.")
    }
}

class Student(name: String, val id: Long) : Person1(name)

fun main(args: Array<String>){

    // クラスの継承--------------------------------------------------------------
    val person: Person1 = Person1("key")
    person.introduceMyself() // Iam key.

    val student: Student = Student("kumi", 123)
    println(student.id)       // 123
    println(student.name)     // kumi
    student.introduceMyself() // I am kumi.

    // メンバのオーバライド-------------------------------------------------------
    val student2: Student2 = Student2("tim", 123)
    student2.introduceMyself() // Iam tim(id=123)

    // スーパタイプ(スーパークラス)とサブタイプ(サブクラス)---------------------------
    val person3: Person1 = Student("oby", 456)
    person3.introduceMyself() // I am oby(id=456)
    // person3.id err

    // Any----------------------------------------------------------------------
    /*
     Anyは全てのオブジェクトに共通する基本的なメソッドを提供するクラス。
     open fun toString(): String
     open operator fun equals(other:Any?):Boolean
     open fun hashCode():Int
     */

    // 抽象クラス-----------------------------------------------------------------
    EnglishGreeter("kotlin").sayHello() // Hello, Kotlin
    JapaneseGreeter("Java").sayHello() //  こんにちは、Java

}

// メンバのオーバライド-------------------------------------------------------
class Student2(name: String, val id: Long) : Person1(name){
    override fun introduceMyself() {

        /* オーバライド前に元のメソッドを利用する（super）
        println("-----------------------")
        super.introduceMyself() // オーバライド前のメソッドを利用
        println("-----------------------")
        */

        println(" I am $name(id=$id")
    }
}

// 継承元の引数にopenが付いていて、継承先のクラスの引数にoverride val/varがあると、
// プロパティもオーバライドできる
class Student2_1(override val name: String, val id: Long) : Person1(name){
    override fun introduceMyself() {

        /* オーバライド前に元のメソッドを利用する（super）
        println("-----------------------")
        super.introduceMyself() // オーバライド前のメソッドを利用
        println("-----------------------")
        */

        println(" I am $name(id=$id")
    }
}

// 抽象クラス-----------------------------------------------------------------
abstract class Greeter1(val target: String){
    abstract fun sayHello()
}

class EnglishGreeter(target: String): Greeter1(target){
    override fun sayHello() = println("Hell $target!")
}
class JapaneseGreeter(target: String): Greeter1(target){
    override fun sayHello() = println("こんにちは、$target!")
}

// 可視性--------------------------------------------------------------------
/* パッケージにより名前空間を区切り、直下には、プログラム構成要素を宣言できる。
 * 　ー　method
 * 　ー　プロパティ
 * 　ー　クラス
 * 　ー　インタフェース
 * 　ー　オブジェクト
 * 　
 * 　可視性修飾子
 * 　パッケージ直下に宣言できる、関数やクラスなどに付けれる
 *   - public   : 公開範囲に制限はなく、どこからでもアクセス可能（デフォルト）
 *   - internal : 同一モジュール（同一のコンパイル単位であること）内に限り、全公開
 *   - private  : 同一ファイル内のみ、アクセス可能
 *
 *   クラスにおける可視性修飾子
 *   クラスやインタフェースのメンバにも、可視性修飾子を付けれる。
 *   - public    : 公開範囲に制限はなく、どこからでもアクセス可能（デフォルト）
 *   - internal  : 同一モジュール（同一のコンパイル単位であること）内に限り、全公開
 *   - protected : 同一クラス内と、サブクラス内からアクセス可能。
 *   - private   : 同一ファイル内のみ、アクセス可能
 *
 */

/*記載例
package sample.fuga
import sample.hoge.Foo
import sample.fuga.Baz as Beer // 「as + 別名」を付けれる
class Baz

class Baz{
    fun doSomethingGood(){
        Foo()
        sample.hoge.Foo()
        Beer()
    }
}
 */
/*記載例（可視性修飾子）
package sample

public fun publicFunction(){}
private fun privateFunction(){}
internal fun internalFunction(){}

-------------------------------------------
(別ファイル)
package sample

fun main(args: Array<Stirng>){
    publicFunction()
    privateFunction() // コンパイルエラー（別クラスのため）
}
 */

/* 記載例（クラスにおける可視性修飾子）*/
open class Foo{
    private fun privateMethod(){}
    protected fun protectedMethod(){}
}

class Bar: Foo(){
    fun execute(){
        // privateMethod() コンパイルエラー
        protectedMethod()
    }
}

class  Baz{
    // fun execute(foo: Bar) = foo.protectedMethod コンパイルエラー
}

open class Hoge private constructor()
// class Fuga: Hoge() コンパイルエラー