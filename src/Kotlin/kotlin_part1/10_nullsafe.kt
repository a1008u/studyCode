package kotlin_part1

/**
 * Created by AU on 2017/07/08.
 */


// Javaにおけるnull-------------------------------------------------------------
// Null安全という答え------------------------------------------------------------
// スマートキャスト--------------------------------------------------------------
// 安全呼び出し------------------------------------------------------------------
// !!演算子---------------------------------------------------------------------
// エルビス演算子----------------------------------------------------------------
// 安全キャスト------------------------------------------------------------------
// 注意-------------------------------------------------------------------------



/*
ぬるぽの原因
1.nullとなり得る参照と、そうでない参照の区別がない
2.nullとなり得ることをプログラマが知らない、確かめない

対策
1.アノテーションの利用
 @Nonnull
 @Nullable
2.値がないかもしれないことをプログラマに認識させる
 <T>Optional<T> first(List<T> list){...}
*/

/*
null-safety(Null安全)
　nullとなり得るか田舎を明確に区別することで、null参照などを防ぐ

*/

fun main(args: Array<String>){

    // val s: String = null NG(Stringの型にnullを代入できない)

    // 型の前に「?」をつけるとnullがで移入できる
    val s:String? = null
    println("sの中身はnullとなる:"+ s)
    // println("sはコンパイルエラーとなる:"+ s.toUpperCase())

    // スマートキャスト（対象の型へのキャストが安全であることを確認できるとき、自動的にキャストされるような機能）----------------------------------------------
    // Nullable(nullとなり得る型) NotNull(nullにはなり得ない型)
    val a: String? = null
    val b: String? = "Hello"

    if(a != null) println("aの結果：" + a.toUpperCase()) // NotNull確認
    if(b != null) println("bの結果：" + b.toUpperCase())

    val list: List<Any> = listOf(1, 'a', false)
    for(e in list){
        val result: Any? = when(e){
            is Int -> e+5
            is Char -> e.toUpperCase()
            is Boolean -> e.not()
            else -> null
        }
        println("resultの結果:" + result)
    }

    // 安全呼び出し----------------------------------------------
    // nullならnullを返すだけ
    val a2: Int? =5
    val aInc : Int? = if(a2 != null) a2.inc() else null

    // 安全呼び出し(.の前に?を付ける)
    // レシーバとなるオブジェクトへの参照がnullでない場合はメンバアクセスに成功し、
    // nullであるばいは何もせずに単にnullを返すだけです。
    val aInc2: Int? = a2?.inc()

    // NotNullな引数をとる関数にNullableを渡す
    fun square3(i:Int): Int = i * i
    val a3: Int? = 5
    if(a3 != null) square3(a3) else null

    // NotNullな引数をとる関数にNullableを渡す(let+安全呼び出し)
    // 構文：public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
    // letとは、任意の型Tに対する拡張関数です。(T)->Rという関数オブジェクトを引数blockに取り、
    // そのblockに対して、letのレシーバとなるオブジェクトを引数として与えて呼び出す。
    val aSquare = a3?.let{ square3(it)}

    // !!演算子(Nullableな参照を、NotNullに強制的に変換する操作)----------------------------------------------
    val foo: String? = "Hello"
    val bar: String = foo!!
    println(bar.toUpperCase()) // HELLO

    // val hoge: String? = null
    // val fuge: String = hoge!! // kotlin.KotlinNullPointerException

    val foo2: String? ="Hello"
    val bar2: String = requireNotNull(foo2,{"nullなわけがない"})
    println(bar2.toUpperCase()) // HELLO

    val hoge2: String? = null
    val fuga2: String = requireNotNull(hoge2,{"hogeはnullであってはダメ"})
    println(fuga2.toUpperCase()) //java.lang.IllegalArgumentException: hogeはnullであってはダメ

    //　エルビス演算子----------------------------------------------
    // normal
    val foo4: String? = "Hello"
    (if(foo4 != null) foo4 else "default").toUpperCase() // HELLO
    val hoge4: String? = null
    (if(hoge4 != null) hoge4 else "default") //default

    // エルビス演算子というNullableに対する操作が提供
    // 「?:」の前にNullableを取り、後にデフォルト値を取ります。
    val foo5: String? = "Hello"
    (foo5 ?: "default").toUpperCase() // HELLO

    val hoge5: String? = null
    hoge5 ?: "default" // default

    // NullableからNotNullへの変換を行い、変換できない場合に任意の例外をスローすることもできる
    val foo6: String? = "Hello"
    foo6 ?: throw AssertionError() // Hello

    val hoge6: String? = null
    hoge6 ?: throw AssertionError() // Exception in thread "main" java.lang.AssertionError

    // 安全キャスト----------------------------------------------
    // 「as?」キャストに失敗した場合、nullを返す。

    val str : Any = "本当は文字列"
    println(str as String)
    // println(str as Int) // Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
    println(str as? Int) // null


}