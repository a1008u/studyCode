package ch06.ex1_10_NullabilityOfTypeParameters


// 型パラメータのnull許容性の区別

// tはnullになるかもしれないので安全呼び出しを使わなければならない
fun <T> printHashCode(t: T) = println(t?.hashCode())

// null非許容型として定義
fun <T: Any> printHashCode2(t: T) = println(t.hashCode())

// TはAny?と推論されている
fun main(args: Array<String>) {
    printHashCode(null) // null
    // printHashCode2(null) コンパイルできない
}