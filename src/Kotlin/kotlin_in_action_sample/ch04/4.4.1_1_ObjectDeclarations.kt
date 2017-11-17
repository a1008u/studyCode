package ch04.ex4_1_1_ObjectDeclarations

import java.util.Comparator
import java.io.File

// objectキーワード：クラスの宣言とインスタンスの生成の組み合わせ
// オブジェクト宣言(object declaration) シングルトンを定義する方法
// コンパニオンオブジェクト(companion object) ファクトリメソッドやその関連するメソッドなどを含める。クラス名を使ってアクセス。
// オブジェクト式(object expression) java無名内部クラスの代わりに使う。

// シングルトン java
// privateコンストラクタとそのクラスのインスタンスを静的フィールドに１つだけ持つクラスを定義

// object declaration コンストラクタでなく定義時点で即座にインスタンスが生成
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    // 呼び出し
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user"))) // 0

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator)) // [/a, /Z]
}
