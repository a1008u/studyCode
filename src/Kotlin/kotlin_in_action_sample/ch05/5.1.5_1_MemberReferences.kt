package ch05.ex1_5_1_MemberReferences

// メンバ参照(member reference)  【記載方法】クラス::メンバ
fun salute() = println("Salute!")
fun main(args: Array<String>) = run(::salute) // トップレベル関数への参照 run関数で実行
