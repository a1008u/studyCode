package ch04.ex2_5_ChangingAccessorVisibility

// getterやsetterの前に可視性修飾子を置くことで、プロパティと別の修飾子を設定できる。
// 通常はプロパティと同じになる。
class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter) // 3
}
