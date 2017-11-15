package ch03.ParsePath

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

// 正規表現未使用
fun main(args: Array<String>) {
    // Dir: /Users/yole/kotlin-book, name: chapter, ext: adoc
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
}
