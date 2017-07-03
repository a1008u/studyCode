package kotlin_part1


/**
 * Created by AU on 2017/07/03.
 */

private var cnt = 0

fun main(args: Array<String>){

    /* 関数名：succ
     * 引数：Int i
     * 戻り値：Int i+1
     *
     */
    fun succ(i: Int): Int = i + 1
    val result1 = succ(31)
    println(result1)

    // 引数の二乗を返す関数
    fun square(i:Int): Int = i * i
    val result2 = square(5)
    println(result2)

    // 名前として指定した引数に対する挨拶文を返す関数
    fun hello(name: String): String = "Hello, $name!"
    println(hello("Alice"))

    //　引数を2つ渡して、大きい方を返す関数
    fun max(a: Int, b: Int): Int = if(b <= a) a else b
    println(max(12, 13))
    println(max(0, -1))

    // sum関数
    fun sum(ints: Array<Int>): Int {
        var sum = 0
        for (i in ints){
            sum += i
        }
        return sum
    }
    println(sum(arrayOf(1,2,3)))

    // 名前付き引数
    fun sub(minuend: Int, subtrahend: Int): Int = minuend - subtrahend
    println("sub(5, 3):" + sub(5, 3))
    println("sub(minuend = 10, subtrahend =7) : " + sub(minuend = 10, subtrahend =7))
    println("sub(subtrahend = 2, minuend = 6) : " + sub(subtrahend = 2, minuend = 6))

    // デフォルト引数
    fun hellohello(name: String = "World"): String = "Hello, $name!"
    println(hellohello())
    println("// 名前付き引数とデフォルト引数 : "+hellohello("Alice"))

    // 可変長引数　修飾子にvarargをつける
    fun sum(vararg ints: Int): Int {
        var sum =0
        for ( i in ints) {
            sum += i
        }
        return sum
    }
    println("sum(1,2,3) : " + sum(1,2,3))

    // 引数を渡す場合は*をつけるå
    println(sum(*intArrayOf(1,2,3)))

    // for文と再帰呼び出し(スタックオーバーフローを防止する)
    fun sumsum(numbers: List<Long>): Long{
        var sum = 0L
        for (n in numbers){
            sum += n
        }
        return sum
    }

    fun sumsum2(numbers: List<Long>) : Long = if(numbers.isEmpty()) 0 else numbers.first()+ sumsum2(numbers.drop(1))

    // 再帰呼び出しが末尾にくる形
    fun sumsum3(numbers: List<Long>, accumulator: Long = 0): Long
            = if(numbers.isEmpty()) accumulator else sumsum3(numbers.drop(1),accumulator + numbers.first())

    // 再帰呼び出し(修飾子tailrecを関数につけ、TCO(Tail Call Optimization:関数の最後の計算が再帰呼び出しであること))å
    tailrec fun sumsum4(numbers: List<Long>, accumulator: Long=0): Long
        = if(numbers.isEmpty()) accumulator else sumsum4(numbers.drop(1), accumulator + numbers.first())
    println("sumsum4(listOf(1,2,3) : " + sumsum4(listOf(1,2,3)))

    // ローカル関数
    fun sumsum5(numbers: List<Long>): Long{
        tailrec fun go(numbers: List<Long>, accumulator: Long): Long
                = if(numbers.isEmpty()) accumulator else go(numbers.drop(1), accumulator + numbers.first())
        return go(numbers, 0)
    }
    println("sumsum5(listOf(1,2,3) : " + sumsum5(listOf(1,2,3)))

    // 結果を返さない関数（return Unitを省略できる寄って、Unit型を利用するとまるでvoidと同じようになる）
    fun countUp(): Unit{
        cnt++
    }

    fun getCount(): Int =cnt
    countUp();
    println("getCount()" + getCount())

}

