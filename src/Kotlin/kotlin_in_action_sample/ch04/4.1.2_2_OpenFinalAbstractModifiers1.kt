package ch04.ex1_2_2_OpenFinalAbstractModifiers1

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {
    // finalなしのoverrideはopenであることを意味するが、finalのためオーバーライドできなくなる
    final override fun click() {}
}
