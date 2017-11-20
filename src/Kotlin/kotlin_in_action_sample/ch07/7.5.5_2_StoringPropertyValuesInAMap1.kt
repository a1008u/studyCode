package ch07.ex5_5_2_StoringPropertyValuesInAMap1

class Person {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes // mapを委譲プロパティとして使う(getValueを意味する)
    val company: String by _attributes // mapを委譲プロパティとして使う(getValueを意味する)
}

fun main(args: Array<String>) {
    val p = Person()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data) p.setAttribute(attrName, value)
    println(p.name) // Dmitry
    println(p.company) // JetBrains
}
