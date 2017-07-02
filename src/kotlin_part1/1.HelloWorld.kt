package kotlin_part1

/**
 * Created by AU on 2017/07/02.
 */

// コンパイル:kotlinc 1.HelloWorld.kt -include-runtime -d HelloWrold.jar
// 実行：java-jar HelloWrold.jar

// fun：関数定義(関数は、パッケージレベルに定義できる)
// 型は変数名の後に
fun main(args: Array<String>){
    // ;は不要(あっても問題ない)
    println("HELLO WORLD")
}