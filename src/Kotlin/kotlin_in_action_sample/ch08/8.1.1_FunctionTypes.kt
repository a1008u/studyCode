package ch08.ex1_1_FunctionTypes


/*
高階関数(kotlin)
1.ラムダや関数参照を引数として渡すことができる関数
2.ラムダか関数参照を返す関数
 */

fun performRequest(
       url: String,
       callback: (code: Int, content: String) -> Unit
) {
    /*...*/
}

fun main(args: Array<String>) {
    val url = "http://kotl.in"
    performRequest(url) { code, content -> /*...*/ }
    performRequest(url) { code, page -> /*...*/ }
}
