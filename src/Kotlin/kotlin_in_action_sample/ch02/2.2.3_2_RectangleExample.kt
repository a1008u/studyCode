package geometry.example

import geometry.shapes.createRandomRectangle
import java.util.*

fun main(args: Array<String>) {
    println(createRandomRectangle().isSquare)
}

// 呼ばれるコード
//class Rectangle(val height: Int, val width: Int) {
//    val isSquare: Boolean
//        get() = height == width
//}
//
//fun createRandomRectangle(): Rectangle {
//    val random = Random()
//    return Rectangle(height = random.nextInt(), width = random.nextInt())
//}
