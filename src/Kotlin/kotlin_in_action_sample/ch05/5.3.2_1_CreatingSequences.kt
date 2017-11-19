package ch05.ex3_2_1_CreatingSequences

fun main(args: Array<String>) {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 } // 遅延処理
    println(numbersTo100.sum()) // 5050　遅延処理　sum()が終端処理
}
