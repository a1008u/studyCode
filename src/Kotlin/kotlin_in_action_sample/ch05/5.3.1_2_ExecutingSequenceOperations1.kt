package ch05.ex3_1_2_ExecutingSequenceOperations1

import ch05.ex2_3_1_GroupBy.Person

// asSequence()でシーケンスに変換　＊遅延処理となる
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4).asSequence()
                                           .map { print("map($it) "); it * it } // 中間操作
                                           .filter { println("filter($it) "); it % 2 == 0 } // 中間操作
                                           .toList() // 終端操作

    println(list)

    val people = listOf(Person("Alice",29)
                                    ,Person("Bob",31)
                                    ,Person("Charles", 31)
                                    ,Person("Dan", 21))
    println(people.asSequence().map(Person::name).filter { it.length < 4 }.toList())
    println(people.asSequence().filter { it.name.length < 4 }.map(Person::name).toList())
}

/*
map(1) filter(1)
map(2) filter(4)
map(3) filter(9)
map(4) filter(16)
[4, 16]
[Bob, Dan]
[Bob, Dan]
*/





