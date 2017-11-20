package ch07.ex4_1_DestructuringDeclarationsAndLoops

fun printEntries(map: Map<String, String>) {
    // mapも繰り返し処理ができる
    for ((key, value) in map) { println("$key -> $value") }
}

// 分解宣言はmapに内のエントリを列挙すること
fun main(args: Array<String>) {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

/*
Oracle -> Java
JetBrains -> Kotlin
 */