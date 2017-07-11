package kotlin_part1

import com.sun.tools.doclint.DocLint
import kotlin.reflect.KFunction

/**
 * Created by AU on 2017/07/04.
 */

// 関数オブジェクト-------------------------------------------------------------------------
// 関数型----------------------------------------------------------------------------------
// 高階関数--------------------------------------------------------------------------------
// ラムダ式--------------------------------------------------------------------------------
// クロージャ------------------------------------------------------------------------------
// インライン関数--------------------------------------------------------------------------
// 非ローカルリターンとラベルへのリターン------------------------------------------------------
// 無名関数--------------------------------------------------------------------------------


fun main(args: Array<String>){

    // 関数オブジェクト-------------------------------------------------------------------------
    /*
     * 関数を変数に代入できたり、引数として与えたり、関数の結果として返す。
     * ::を記載すると、その関数の関数オブジェクトを取得できる。
     */
    fun square(i: Int): Int= i*i;
    val square_ramda6: (Int) -> Int = {i -> i*i}
    // squareメソッドを関数オブジェクトとして取得
    println(::square)
    println(square_ramda6(10)) // 100

    // 関数オブジェクトの代入と呼び出し
    val functionObject = ::square
    println(functionObject(5)) //25

    // 関数型----------------------------------------------------------------------------------
    // (Int) -> Intが型
    // 引数：(Int)
    // 戻り値：Int
    val functionObject2: (Int) -> Int = ::square
    println(functionObject2(10)) //100

    // 高階関数--------------------------------------------------------------------------------
    println(firstK("sssKa"))
    println(firstUpperCase("aaA"))

    // クロージャ------------------------------------------------------------------------------
    // コードを記述した時のスコープで変数が扱える関数
    fun getCounter(): ()->Int {
        var count = 0
        return { count++ }
    }

    val counter1 = getCounter()
    val counter2 = getCounter()
    println(counter1()) // 0
    println(counter1()) // 1
    println(counter2()) // 0
    println(counter1()) // 2
    println(counter2()) // 1


    // インライン関数--------------------------------------------------------------------------
    // 引数の関数オブジェクトが、コンパイル時にインライン展開される関数
    // インライン関数でない
    fun log(debug: Boolean = true, message: ()-> String){
        if(debug) println(message())
    }
    log{"このメッセージは出力される"}
    log(false){"このメッセージは出力されない"}

    // インライン関数(高階関数の実行コストを下げる)
    if(true) println("このメッセージは表示される")
    if(false) println("このメッセージは表示されない")
}

// 高階関数--------------------------------------------------------------------------------
// 高階関数前の関数
fun firstK(str: String): Int{
    tailrec fun go(str: String, index: Int): Int
     = when{
        str.isEmpty() -> -1
        str.first() == 'K' -> index
        else -> go(str.drop(1), index+1)
    }
    return go(str, 0)
}

fun firstUpperCase(str: String): Int{
    tailrec fun go(str: String, index: Int): Int
     = when{
        str.isEmpty() -> -1
        str.first().isUpperCase() -> index
        else -> go(str.drop(1), index+1)
    }
    return go(str, 0)
}

// 高階関数
fun first(str: String, predicate: (Char) -> Boolean): Int{
    tailrec fun go(str: String, index: Int): Int
        = when{
        str.isEmpty() -> -1
        predicate(str.first()) -> index
        else -> go(str.drop(1), index+1)
    }
    return go(str, 0)
}

fun firstK2(str: String): Int {
    fun isK(c: Char): Boolean = c =='K'
    return first(str, ::isK)
}

fun firstUpperCase2(str: String): Int{
    fun isUpperCase(c: Char): Boolean = c.isUpperCase()
    return first(str, ::isUpperCase)
}

// 以下をラムダを利用し簡潔にする
fun firstWhitespace(str: String): Int{
    val isWhitespace : (Char) -> Boolean = {
        it.isWhitespace()
    }

    return first(str, isWhitespace)
}

// どちらでも上記と同じ動作となる
fun firstWhitespace2(str: String): Int = first(str, {it.isWhitespace()})
fun firstWhitespace3(str: String): Int = first(str) {it.isWhitespace()} // 構文糖衣（ラムダ式を引数リストから出す）

// ラムダ式--------------------------------------------------------------------------------
// ラムダの記載(return不要)
val square_ramda:(Int) -> Int = {i: Int -> i*i}

// ラムダの型推論
val square_ramda2 = {i:Int -> i*i }
val square_ramda3 : (Int) -> Int = {i -> i*i}

// 引数が一つの場合、it(暗黙の変数)を利用できる
val square_ramda4 : (Int) -> Int = { it*it }

// 無名関数--------------------------------------------------------------------------------
// 無名関数(returnを使える点が、非ローカルリターンとの違い)
val square_noname:(Int) -> Int = fun(i: Int): Int { return i * i}

// 無名関数　省略バージョン
val square_noname2:(Int) -> Int = fun(i: Int) = i*i


// クロージャ------------------------------------------------------------------------------
fun foo():Int{
    val a = 1
    val b = 2
    return a+b
}

/*
fun bar(): Int{
    val c = 3
    return a+c // aにアクセスできずコンパイルエラー
}
*/


// インライン関数--------------------------------------------------------------------------
// 引数の関数オブジェクトがコンパイル時にインライン展開される関数のこと。
inline fun log2(debug: Boolean = true, message: ()-> String){
    if(debug) println(message())
}

// 非ローカルリターンとラベルへのリターン------------------------------------------------------
// 非ローカルリターン：外側の関数からのリターン
// 文字列を走査するインライン関数
inline fun forEach(str: String, f:(Char) -> Unit){
    for (c in str) f(c)
}

// ラベルへのリターン(forEachからの出る)
fun containsDigit(str : String): Boolean {
    var result = false
    forEach(str) here@ {
        if(it.isDigit()) {
            return true
            return@here
        }
    }
    return result
}

// リターンの対象が推論できる場合に限り、ラベル名ではなく、関数名を指定してリターンできる
fun containsDigit2(str : String): Boolean {
    var result = false
    forEach(str) {
        if(it.isDigit()) {
            return true
            return@forEach
        }
    }
    return result
}