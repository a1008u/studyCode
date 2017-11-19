package ch06.ex1_6_NotnullAssertions

// 非null表明(not-null assertion):!!
fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun main(args: Array<String>) {
    ignoreNulls(null) // kotlin.KotlinNullPointerException
}
