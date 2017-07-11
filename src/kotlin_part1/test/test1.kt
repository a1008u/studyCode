package kotlin_part1.test

/**
 * Created by AU on 2017/07/11.
 */

fun main(args: Array<String>){

    // 高階関数前の関数--------------------------------------------------------------------------------
    fun firstK(str: String): Int{
        tailrec fun go(str: String, index: Int): Int
                = when{
            str.isEmpty() -> -1
            str.first() == 'K' -> index
            else -> go(str.drop(1), index+1)
        }
        return go(str, 0)
    }

    fun firstUpperCase(str: String): Int{
        tailrec fun go(str: String, index: Int): Int
                = when{
            str.isEmpty() -> -1
            str.first().isUpperCase() -> index
            else -> go(str.drop(1), index+1)
        }
        return go(str, 0)
    }

    println(firstK("teKst"))
    println(firstUpperCase("tttKs"))

    // 高階関数の変形1--------------------------------------------------------------------------------
    fun firstK2(str: String): Int {
        fun isK(c: Char): Boolean = c =='K'
        return first(str, ::isK)
    }

    fun firstK2_1(str: String):Int{
        val isK2_1 :(Char) -> Boolean = {c:Char ->  c == 'K'}
        return first(str, isK2_1)
    }

    fun firstK2_2(str: String):Int{
        val isK2_1 = {c:Char ->  c == 'K'}
        return first(str, isK2_1)
    }

    fun firstK2_3(str: String):Int{
        val isK2_1 :(Char) -> Boolean = {c ->  c == 'K'}
        return first(str, isK2_1)
    }

    fun firstK2_4(str: String):Int = first(str, {c:Char ->  c == 'K'})
    fun firstK2_5(str: String):Int = first(str) {c:Char ->  c == 'K'}

    // インライン関数で定義
    fun firstK2_6(str: String):Int = first(str, ::isK2)
    println(firstK2_6("ttK"))

    println(firstK2("teKst"))

    // 高階関数の変形2--------------------------------------------------------------------------------
    fun firstUpperCase2(str: String): Int{
        fun isUpperCase(c: Char): Boolean = c.isUpperCase()
        return first(str, ::isUpperCase)
    }
    println(firstUpperCase2("tttKs"))
}

// 高階関数--------------------------------------------------------------------------------
fun first(str: String, predicate: (Char) -> Boolean): Int{
    tailrec fun go(str: String, index: Int): Int
            = when{
        str.isEmpty() -> -1
        predicate(str.first()) -> index
        else -> go(str.drop(1), index+1)
    }
    return go(str, 0)
}

inline fun isK2(c: Char): Boolean = c =='K'



