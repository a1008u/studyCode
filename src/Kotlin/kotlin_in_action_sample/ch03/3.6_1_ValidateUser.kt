package ch03.ValidateUser

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {

    // if文が重複

    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address")
    }

    print("Save user to the databaseb")
}

fun main(args: Array<String>) = saveUser(User(1, "aaaa", "t@t"))
