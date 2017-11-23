package ch09.ex3_1_WhyVarianceExists

/**
 * 変位：ジェネリクスとサブタイプ
 * 基本となる方は同じであっても方引数が異なるような方同士が、相互にどのように関連しているのかを表現
 *
 * 不変(invariant)：共通のジェネリッククラスの型パラメータが異なる場合、サブタイプでもサブクラスでもないこと
 * 共変(covariant)：サブタイプが成り立つ(維持されている)場合
 *
 */
// サブタイプ(subtype)
// 型Aの値が要求されるいかなる時も型Bの値が使用できるなら、型Bは型Aのサブタイプ
// 例：IntはNumberのサブタイプ　IntはStringのサブタイプでない
//     Intはサブタイプ Numberはスーパータイプ
// null非許容型は、null許容型バージョンのサブタイプですが、逆はできない
// outキーワードをつけることで、型パラメータを共変と宣言する

fun printContents(list: List<Any>) = println(list.joinToString())
fun main(args: Array<String>) = printContents(listOf("abc", "bac")) // abc, bac

