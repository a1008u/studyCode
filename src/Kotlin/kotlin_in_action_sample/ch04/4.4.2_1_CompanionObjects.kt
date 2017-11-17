package ch04.ex4_2_1_CompanionObjects

// コンパニオン：ファクトリメソッドと静的メンバの置き場
// staticキーワードをkotlinではパッケージレベル関数とオブジェクト宣言で表現する

class A {
    // コンパニオンオブジェクトを表す
    companion object { fun bar() = println("Companion object called") }
}

// クラス名を使ってアクセスできる
fun main(args: Array<String>) { A.bar() }  // Companion object called
