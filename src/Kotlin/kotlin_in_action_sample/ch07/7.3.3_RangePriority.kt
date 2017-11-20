package ch07.RangePriority

// rangeTo規約
// start...end -> start.rangeTo(end)
fun main(args: Array<String>) {
    val n = 9
    println(0..(n + 1)) // 0..10
    (0..n).forEach { print(it) } // 0123456789
}

