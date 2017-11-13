package ch02.ex4_3_IteratingOverMaps

import java.util.TreeMap

fun main(args: Array<String>) {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) println("$letter = $binary")
}

/*
A = 1000001
B = 1000010
C = 1000011
D = 1000100
E = 1000101
F = 1000110
*/