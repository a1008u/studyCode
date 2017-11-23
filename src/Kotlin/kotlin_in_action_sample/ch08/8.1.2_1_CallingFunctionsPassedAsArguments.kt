package ch08.ex1_2_1_CallingFunctionsPassedAsArguments

// 関数型の引数の宣言
fun twoAndThree(operation: (Int, Int) -> Int) {
    // 関数型の引数の呼び出し
    val result = operation(2, 3)
    println("The result is $result")
}

fun main(args: Array<String>) {
    twoAndThree({ a : Int, b : Int -> a + b }) // The result is 5
    twoAndThree({ a , b  -> a + b }) // The result is 5
    twoAndThree(){ a, b -> a + b }   // The result is 5
    twoAndThree{ a, b -> a + b }     // The result is 5

    twoAndThree { a, b -> a * b } // The result is 6
}
