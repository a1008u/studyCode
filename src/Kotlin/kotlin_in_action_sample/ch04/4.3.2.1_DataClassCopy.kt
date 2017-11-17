package ch04.ex3_2_1_DataClassCopy

// dataの生成機能（一部）
// インスタンス比較のためのequals
// HashMapなどのハッシュベースのコンテナのキーとして使われるhashCode
// 全てのフィールドを宣言順に並べた文字列表現を生成するtoString

// equalsとhashCodeはプライマリコンストラクタで宣言された全てのプロパティを考慮する


// データクラスと不変性：copy()
data class Client(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555)) // Client(name=Bob, postalCode=382555)
}
