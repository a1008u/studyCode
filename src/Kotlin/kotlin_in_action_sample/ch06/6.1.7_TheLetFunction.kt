package ch06.ex1_7_TheLetFunction

// let関数　null非許容型の引数を取る関数にnull許容型の引数を渡す場合に利用
fun sendEmailTo(email: String) = println("Sending email to $email")

fun main(args: Array<String>) {
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) } // Sending email to yole@example.com
    email?.let { email -> sendEmailTo(email) } // Sending email to yole@example.com

    email = null
    email?.let { sendEmailTo(it) }
}
