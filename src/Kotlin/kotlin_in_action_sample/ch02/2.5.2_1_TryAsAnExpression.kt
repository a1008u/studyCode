package ch02.ex5_2_1_TryAsAnExpression

import java.io.BufferedReader
import java.io.StringReader

// kotlinでは検査例外と日検査例外を区別していない
// 関数によってスローされる可能性のある例外を宣言する必要がない。
fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)
}
