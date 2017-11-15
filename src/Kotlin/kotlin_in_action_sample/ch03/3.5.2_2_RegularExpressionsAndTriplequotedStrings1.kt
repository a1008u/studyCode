package ch03.ex5_2_2_RegularExpressionsAndTriplequotedStrings1

fun parsePath(path: String) {
    // triple-quoted stringを利用
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

// 正規表現使用
fun main(args: Array<String>) {
    // Dir: /Users/yole/kotlin-book, name: chapter, ext: adoc
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
}
