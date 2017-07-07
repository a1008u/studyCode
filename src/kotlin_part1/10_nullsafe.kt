package kotlin_part1

/**
 * Created by AU on 2017/07/08.
 */

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

    // スマートキャスト（対象の型へのキャストが安全であることを確認できるとき、自動的にキャストされるような機能）
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

}