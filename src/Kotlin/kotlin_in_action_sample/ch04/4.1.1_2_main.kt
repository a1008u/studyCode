package ch04.main

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")

    // 1つのメンバに大使2つ以上の実装が継承されている場合、明示的にそのメソッドを実装させる
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    // 1つ呼び出す場合
    // override fun showOff() = super<Focusable>.showOff()
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!") // default
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}

/*
I'm clickable!
I'm focusable!
I got focus.
I was clicked
*/