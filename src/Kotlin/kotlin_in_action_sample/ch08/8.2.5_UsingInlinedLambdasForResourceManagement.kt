package ch08.ex2_5_UsingInlinedLambdasForResourceManagement

import java.io.BufferedReader
import java.io.FileReader
import java.io.File

// Javaではtry-with-resourcesを利用して、ファイルから最初の行を読み取るJavaメソッド
fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br -> return br.readLine() }
}
