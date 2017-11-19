package ch07.ex1_2_3_CompoundAssignmentOperators2

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list) // [1, 2, 3]
    println(newList) // [1, 2, 3, 4, 5]
}
