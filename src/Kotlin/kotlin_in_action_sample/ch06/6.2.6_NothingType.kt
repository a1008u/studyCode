package ch06.ex2_6_NothingType

// Nothing型　この関数は値を返さない
fun fail(message: String): Nothing = throw IllegalStateException(message)

fun main(args: Array<String>) {
    fail("Error occurred") // Exception in thread "main" java.lang.IllegalStateException: Error occurred
}
