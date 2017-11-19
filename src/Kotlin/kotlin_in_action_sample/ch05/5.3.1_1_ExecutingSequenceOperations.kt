package ch05.ex3_1_1_ExecutingSequenceOperations

// mapとfilterの療法でListを返しているため、シーケンスを使用する（一時オブジェクトを生成させない）
// 中間操作のみしか記載していないため、コンソールに表示されない
fun main(args: Array<String>) {
    listOf(1, 2, 3, 4).asSequence()
                      .map { print("map($it) "); it * it } // 中間操作
                      .filter { print("filter($it) "); it % 2 == 0 } // 中間操作
}
