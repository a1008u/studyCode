package ch07.SplitFilename

import java.io.File

// データを保持するデータクラス（戻りの型）
data class NameComponents(val name: String
                          , val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val result:List<String> = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

fun main(args: Array<String>) {
    val (name, ext) = splitFilename("example.kt")
    println(name) // example
    println(ext) // kt
}
