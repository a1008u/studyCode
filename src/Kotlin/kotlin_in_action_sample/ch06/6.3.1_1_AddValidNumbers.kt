package ch06.AddValidNumbers

import java.util.ArrayList
import java.io.BufferedReader
import java.io.StringReader

fun readNumbers(reader: BufferedReader): List<Int?> {
    // null許容型Intのリストを生成
    val result = ArrayList<Int?>()

    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            // リストに数値(null非許容型)を追加
            result.add(number)
        }
        catch(e: NumberFormatException) {
            // 現在の行が数値にパースできないのでリストにnullを追加
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) sumOfValidNumbers += number
        else invalidNumbers++
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}
/*
Sum of valid numbers: 43
Invalid numbers: 1
*/
