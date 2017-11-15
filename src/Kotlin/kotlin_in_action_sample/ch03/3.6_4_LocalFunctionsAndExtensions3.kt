package ch03.ex6_4_LocalFunctionsAndExtensions3

class User(val id: Int, val name: String, val address: String)

// ローカル関数は１段階以上の入れ子の仕様は推奨しない
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user $id: empty $fieldName")
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    print("Save user to the databaseb")
}

fun main(args: Array<String>) = saveUser(User(1, "", ""))

