package kotlin_part1.test

/**
 * Created by AU on 2017/07/18.
 */

fun main(args: Array<String>) {


    /*
        不変：同じ型でなければならない
        共変：広い定義に狭い定義のものを入れることができる　(出力のみ)
        反変：共変の逆になる　(入力のみ)
    */

    // 不変------------------------------------------------------------
    /*
        -Java
        List<String> strList = new ArrayList<String>();
        List<Object> objList = strList; //コンパイルエラー  不変のため代入できない
     */

    //配列
    val intArray: Array<Int> = arrayOf(1,2)
    //　val numArray: Array<Any?> = intArray コンパイルエラー　共変ではないため

    //リスト
    val strList: java.util.ArrayList<String> = arrayListOf("1st", "2nd")

    // 共変------------------------------------------------------------
    /*
        - Java
        //配列
        String[] strArray = {"hoge", "foo"};
        Object[] objArray = strArray;

        //上限付き境界ワイルドカード
        List<String> strList = new ArrayList<String>();
        List<? extends Object> objList = strList;

        objArray[0] = 1; //ランタイムエラー(実体はStringのため)
     */

    val intArray2: Array<Int> = arrayOf(1,2)
    val numArray: Array<out Any?> = intArray2 // outキーワードで型パラメータ指定
    println(numArray[0]) // 1

    // 反変------------------------------------------------------------
    /*
        -Java
        //下限付き境界ワイルドカード
        List<Object> objList = new ArrayList<Object>();
        List<? super String> strList = objList;
    */

    var hoge = Hoge(1)
    val hogeList: java.util.ArrayList<Hoge> = arrayListOf(hoge)
    val fooList: java.util.ArrayList<in Foo> = hogeList  //反変だから代入できる

    val foo = fooList[0]

    println(hoge == foo) // true
    println(hoge.a)  //1が出力される
    // println(foo.a)  コンパイルエラー
}
open class Hoge(val a: Int)
class Foo: Hoge(0)
