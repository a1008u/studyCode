package ch08.ex1_5_1_ReturningFunctionsFromFunctions

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

// 関数を返す関数の宣言
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {

    // 関数からラムダを返す
    if (delivery == Delivery.EXPEDITED) return { order -> 6 + 2.1 * order.itemCount }

    // 関数からラムダを返す
    return { order -> 1.2 * order.itemCount }
}

fun main(args: Array<String>) {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)

    // 返された関数の呼び出し
    println("Shipping costs ${calculator(Order(3))}") // Shipping costs 12.3
}
