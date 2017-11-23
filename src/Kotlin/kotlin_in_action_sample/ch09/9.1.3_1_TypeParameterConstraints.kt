package ch09.ex1_3_1_TypeParameterConstraints

// 型パラメータ制約(type parameter constraints)
// クラスや関数に対して型引数として使用できる型を制限すること。
// 上限境界(upper bound)
// ジェネリック型の特定のインスタンス化において対応する型は、指定された型でsルカ、そのサブタイプでなければならない
// <T:Number> T - 型パラメータ Number - 上限境界
fun <T : Number> oneHalf(value: T): Double = value.toDouble() / 2.0 // Numberクラスで定義されているメソッドの呼び出し
fun main(args: Array<String>) = println(oneHalf(3)) // 1.5
