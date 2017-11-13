package kotlin_part1

/**
 * Created by AU on 2017/07/02.
 */

// val:変更不可　var:変更可能
class Rational1(val numerator: Int, val denominator: Int)
/*
REPLを利用

$kotlinc
val half = Rational(1,2)
half.denominator

*/

/* toString()メソッド */
// 書き方１
class Rational2(val numerator: Int, val denominator: Int){
    // toString()をオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"
}

// 書き方2
class Rational3(val numerator: Int, val denominator: Int){
    override fun toString(): String {
        return "${numerator}/${denominator}"
    }
}

/*
REPLを利用

$kotlinc
val half1 = Rational(1,2)
val half2 = Rational(2,5)

*/


/* イニシャライザー */
// 書き方１
class Rational4(val numerator: Int, val denominator: Int){

    init{
        // イニシャライザー(require関数を利用)
        require(denominator != 0, {"denominator must not be null"})
    }

    // toString()をオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"
}

// 書き方2
class Rationa5(val numerator: Int, val denominator: Int){

    init{
        // イニシャライザー(require関数を利用)
        require(denominator != 0, {"denominator must not be null"})
    }

    override fun toString(): String {
        return "${numerator}/${denominator}"
    }
}

/*
REPLを利用

$kotlinc
val half1 = Rational(1,2)
val half2 = Rational(2,0) 例外をスロー
*/

/* 非公開プロパティとメソッド */
class Rational5(n: Int, d: Int){

    init{
        // イニシャライザー(require関数を利用)
        require(d != 0, {"denominator must not be null"})
    }

    private val g= gcd(Math.abs(n), Math.abs(d))
    val numerator: Int = n/g
    val denominator: Int = d/g

    // toString()をオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"

    // 引数a,bの最大公約数を返すメソッド
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b==0) a
            else gcd(b, a % b)
}
/*
REPLを利用

$kotlinc
val half1 = Rational(17,17) 1/1
val half2 = Rational(55,100) 11/20
*/

/* 演算子オーバーロード */
class Rational6(n: Int, d: Int){

    init{
        // イニシャライザー(require関数を利用)
        require(d != 0, {"denominator must not be null"})
    }

    private val g by lazy {gcd(Math.abs(n), Math.abs(d))}
    val numerator: Int by lazy { n/g }
    val denominator: Int by lazy { d/g }

    // 分数の足し算を追加
    fun plus(that: Rational6): Rational6 = Rational6(
            numerator * that.denominator + that.numerator * denominator,
            denominator * that.denominator
    )

    // toString()をオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"

    // 引数a,bの最大公約数を返すメソッド
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b==0) a
            else gcd(b, a % b)
}
/*
REPLを利用

$kotlinc
Rational6(1,4).plus(Rational6(1,2)) 3/4
Rational6(1,3).plus(Rational6(4,7)) 19/21
*/

class Rational7(n: Int, d: Int){
    init{
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy {gcd(Math.abs(n), Math.abs(d))}
    val numerator: Int by lazy { n/g }
    val denominator: Int by lazy { d/g }
    operator fun plus(that: Rational7): Rational7 = Rational7(
            numerator * that.denominator + that.numerator * denominator,
            denominator * that.denominator
    )
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b==0) a
            else gcd(b, a % b)
}
/*
REPLを利用

$kotlinc
Rational6(1,2) + Rational6(1,5) 7/10
Rational6(1,6) + Rational6(1,3) + Rational6(1,2) 1/2
*/

/* メソッドのオーバーロード */
class Rational8(n: Int, d: Int){
    init{
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy {gcd(Math.abs(n), Math.abs(d))}
    val numerator: Int by lazy { n/g }
    val denominator: Int by lazy { d/g }
    fun plus(that: Rational8): Rational8 = Rational8(
            numerator * that.denominator + that.numerator * denominator,
            denominator * that.denominator
    )
    operator fun plus(n: Int): Rational8 = Rational8(
           numerator + n * denominator, denominator
    )
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b==0) a
            else gcd(b, a % b)
}
/*
REPLを利用

$kotlinc
Rational8(1,4) + 1 5/4
Rational8(1,1) + 2 3/1
*/

/* 拡張関数(既存のクラスやインタフェースに追加されたメソッドのように見える関数) */
class Rational9(n: Int, d: Int){
    init{
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy {gcd(Math.abs(n), Math.abs(d))}
    val numerator: Int by lazy { n/g }
    val denominator: Int by lazy { d/g }
    operator fun plus(that: Rational9): Rational9 = Rational9(
            numerator * that.denominator + that.numerator * denominator,
            denominator * that.denominator
    )
    operator fun plus(n: Int): Rational9 = Rational9(numerator + n * denominator, denominator)
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b==0) a
            else gcd(b, a % b)
}
operator fun Int.plus(r: Rational9): Rational9 = r + this
/*
REPLを利用

$kotlinc
3 + Rational8(2,1) 5/1
1 + Rational8(1,2) + 2 7/2
*/
