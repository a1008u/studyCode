package ch06.ex1_9_ExtensionsForNullableTypes


// input.isNullOrBlank()
// input - null許容型の値
// . - 安全呼び出しなし
// isNullOrBlank() - null許容型の拡張関数
fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) println("Please fill in the required fields")
}

fun main(args: Array<String>) {
    verifyUserInput(" ") // Please fill in the required fields
    verifyUserInput(null) // Please fill in the required fields
}
