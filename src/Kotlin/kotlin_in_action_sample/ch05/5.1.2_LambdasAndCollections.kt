package ch05.ex1_2_LambdasAndCollections

/**
 * 5.1 ラムサ式とメンバ参照
 * 5.1.1 ラムダの紹介：関数の引数としてのコードブロック
 * 5.1.2 ラムダとコレクション
 * 5.1.3 ラムダしきの構文
 * 5.1.4 スコープ内の変数アクセス
 * 5.1.5 メンバ参照
 * 5.2 コレクション操作のための関数型API
 * 5.2.1 必須の関数：filterとmap
 * 5.2.2 all, any, count, find：コレクションに述部を適用する
 * 5.2.3 groupBy：リストのグループ化
 * 5.2.4 flatMapとflatten：ネストされたコレクション内の要素操作
 * 5.3 遅延コレクション操作：シーケンス
 * 5.3.1 シーケンス操作の実行：中間操作と終端操作
 * 5.3.2 シーケンスの作成
 * 5.4 Javaの関数型インターフェイスの使用
 * 5.4.1 Javaメソッドに引数としてラムダを渡す
 * 5.4.2 SAM変換ラムダの関数型インターフェイスへの明示的な変換
 * 5.5 レシーバ付きラムダ：withとapply
 * 5.5.1 with関数
 * 5.5.2 apply関数
 * 5.6 まとめ
 */

data class Person(val name: String, val age: Int)

// ラムダを利用せずに自前でメソッドを実装
fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people) // Person(name=Bob, age=31)

    // ライブラリ関数利用
    println(people.maxBy({ p:Person -> p.age })) // Person(name=Bob, age=31) 短縮構文を利用しない
    println(people.maxBy() { p:Person -> p.age }) // 改善① ラムダ式が関数呼び出しの最後の引数であればカッコの外に移動
    println(people.maxBy{ p:Person -> p.age }) // 改善② ラムダが関数の唯一の引数であれば、関数呼び出し空からのカッコを取り除く
    println(people.maxBy{ p -> p.age }) // 改善③　型推論機能を利用する
    println(people.maxBy{ it.age }) // 改善④ itを利用する

    println(people.maxBy(Person::age)) // Person(name=Bob, age=31) メンバ参照（ラムダが単に関数やプロパティを呼び出す場合）
}
