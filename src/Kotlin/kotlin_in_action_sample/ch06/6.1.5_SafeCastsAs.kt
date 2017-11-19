package ch06.ex1_5_SafeCastsAs

// as? 安全キャスト
class Person(private val firstName: String, private val lastName: String) {
   override fun equals(o: Any?): Boolean {
      // 型をチェックして一致しなければfalseを返す
      val otherPerson = o as? Person ?: return false

      // 安全キャストの後ではotherPerson変数はPerson型にスマートキャストされている
      return otherPerson.firstName == firstName && otherPerson.lastName == lastName
   }

   override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun main(args: Array<String>) {
    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    println(p1 == p2) // true
    println(p1.equals(42)) // false
}
