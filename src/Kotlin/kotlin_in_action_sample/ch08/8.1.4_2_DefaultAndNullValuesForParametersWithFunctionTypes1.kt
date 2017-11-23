package ch08.ex1_4_2_DefaultAndNullValuesForParametersWithFunctionTypes1

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        // 関数型の引数をnull許容で宣言
        transform: ((T) -> String)? = null ): String  { val result = StringBuilder(prefix)
                                                        for ((index, element) in this.withIndex()) {
                                                            if (index > 0) result.append(separator)

                                                            //  transformメソッドの実施有無を制御
                                                            val str = transform?.invoke(element) ?: element.toString()
                                                            result.append(str)
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
                                 , transform = { it.toUpperCase() }))
}
