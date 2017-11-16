package ch04.ex1_2_1_OpenFinalAbstractModifiers

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

// openのため、他のクラスはこれを継承できる
open class RichButton : Clickable {

    // finalのため、オーバーライドできない
    fun disable() {}

    // この関数はopenなので、サブクラスでオーバーライドすることができる
    open fun animate() {}

    // この関数もopenな関数をオーバーライドしており、これもopenとなる
    override fun click() {}
}
