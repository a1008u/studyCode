package ch03.ex6_3_LocalFunctionsAndExtensions2

class User(val id: Int, val name: String, val address: String)

// ローカル関数は外部の関数の全ての引数や変数にアクセスできる
fun saveUser(user: User) {

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${user.id}: " + "empty $fieldName")
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    print("Save user to the databaseb")
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}
