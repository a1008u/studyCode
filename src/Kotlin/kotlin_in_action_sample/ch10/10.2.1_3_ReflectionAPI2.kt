package ch10.ex2_1_3_ReflectionAPI2

var counter = 0

fun main(args: Array<String>) {
    val kProperty = ::counter

    // リフレクションを使ってsetterを呼び出し、引数として21を渡す
    // getを呼び出してプロパティの値を取得
    kProperty.setter.call(21)
    println(kProperty.get()) // 21

    // setとgetの記載を変更
    kProperty.set(32)
    println(kProperty.getter.call()) // 32
}
