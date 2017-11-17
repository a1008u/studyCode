package ch04.ex2_3_2_ImplementingPropertiesDeclaredInInterfaces1


interface User {
    // emailはサブクラスでオーバーライドされる必要がある
    val email: String

    // オーバーライド不要
    val nickname: String
        get() = email.substringBefore('@')
}
