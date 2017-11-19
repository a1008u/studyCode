package ch05.ex4_2_SAMConstructors

// run()が単一メソッドとして存在するため、式本体の処理はrun()の実装となる
// SAMコンストラクタ
// 元になる関数型インターフェイスの名前と同じになる
fun createAllDoneRunnable(): Runnable = Runnable { println("All done!") }

// 関数型インターフェイス(functional interface) or SAMインターフェイス(Single Abstract Method interface)
// 単一の抽象メソッドを保持しているインターフェイス
fun main(args: Array<String>) {
    createAllDoneRunnable().run() // All done!
}
