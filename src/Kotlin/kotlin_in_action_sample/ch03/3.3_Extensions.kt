package strings

// レシーバ型：拡張するクラスまたはインタフェースの名前（String）
// レシーバオブジェクト：拡張関数を呼び出す値（this[this.length - 1]）
fun String.lastChar(): Char = this[this.length - 1]
fun main(args: Array<String>) = println("Kotlin".lastChar()) // n
