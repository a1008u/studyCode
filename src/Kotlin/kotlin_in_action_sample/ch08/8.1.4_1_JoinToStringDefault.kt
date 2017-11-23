package ch08.JoinToStringDefault

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        // ラムダをデフォルト値とする関数型引数を宣言する
        transform: (T) -> String = { it.toString() }): String { val result = StringBuilder(prefix)
                                                                for ((index, element) in this.withIndex()) {
                                                                    if (index > 0) result.append(separator)
                                                                    result.append(transform(element))
                                                                }

                                                                result.append(postfix)
                                                                return result.toString()
                                                              }

fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString()) // Alpha, Beta
    println(letters.joinToString { it.toLowerCase() }) // alpha, beta

    // ALPHA! BETA!
    println(letters.joinToString(separator = "! "
                                 , postfix = "! "
                                 , transform = { it.toUpperCase()} ) )
}


