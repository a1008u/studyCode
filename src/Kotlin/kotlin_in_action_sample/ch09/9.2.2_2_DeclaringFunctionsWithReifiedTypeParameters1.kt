package ch09.ex2_2_2_DeclaringFunctionsWithReifiedTypeParameters1

/**
 * 具象型パラメータの用途
 * 【できること】
 *  1.型チェックやキャスト
 *  2.KotlinのリフレクションAPIを使用
 *  3.対応するjava.lang.Classを取得
 *  4.他の関数を呼び出す型引数
 *
 *  【できないこと】
 *  1.型パラメータとして指定されたクラスの新しいインスタンスを生成する
 *  2.型パラメータのクラスのコンパニオンオブジェクトのメソッド呼び出し
 *  3.具象型パラメータ付き関数を呼び出す時、型引数として具象でない型パラメータを使用する
 *  4.クラス、プロパティ、非インライン関数の型パラメータにreifiedをマークする
 */

fun main(args: Array<String>) {
    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>()) // [one, three]
}
