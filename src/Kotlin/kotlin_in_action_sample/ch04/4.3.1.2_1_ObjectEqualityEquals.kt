package ch04.ex3_1_2_1_ObjectEqualityEquals

class Client(val name: String, val postalCode: Int)

// オブジェクトの等価性：equals()
// == はkotlinでは、オブジェクトが等しいことをチェックする(equalsと同等)
fun main(args: Array<String>) {
    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)
}
