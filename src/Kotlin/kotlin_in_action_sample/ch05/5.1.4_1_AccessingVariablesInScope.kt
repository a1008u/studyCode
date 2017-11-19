package ch05.ex1_4_1_AccessingVariablesInScope

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    // ラムダ式の本体内で引数の値を利用
    messages.forEach { println("$prefix $it") }
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
}

/*
Error: 403 Forbidden
Error: 404 Not Found
*/