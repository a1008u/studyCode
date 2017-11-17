package ch04.ex3_3_ClassDelegationUsingTheByKeyword

import java.util.HashSet


// クラス委譲：by
// デコレータパターン
// 元のクラスと同じインタフェースを実装し、元のクラスをフィールドとして保持して、新しいクラスを作成
// 元のクラスの振る舞いを変更する必要のないメソッドは、元のクラスメソッドへ転送される。
// kotlinでは、委譲パターンが第1級言語機能としてサポートし、インターフェースにbyを付ける。
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    // 委譲せずに異なる実装をしている
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    // 委譲せずに異なる実装をしている
    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))

    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
    // 3 objects were added, 2 remain
}
