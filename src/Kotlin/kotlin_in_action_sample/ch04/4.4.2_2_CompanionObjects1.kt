package ch04.ex4_2_2_CompanionObjects1


fun getFacebookName(accountId: Int) = "fb:$accountId"

// プライマリコンストラクタをprivateに設定
class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = User(getFacebookName(accountId))
    }
}

fun main(args: Array<String>) {
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname) // bob
    print(facebookUser.nickname) // fb:4
}
