package ch06.ex1_8_2_LateinitializedProperties1

//import org.junit.Before
//import org.junit.Test
//import org.junit.Assert

class MyService { fun performAction(): String = "foo" }

// 遅延初期化プロパティ
// コンストラクタの外で値が変更されるため、常にvarとなる。
class MyTest {
    // null非許容型のプロパティを初期化なしで宣言する
    private lateinit var myService: MyService

    // これまでと同様にseUpメソッド内でプロパティを初期化する
    //@Before fun setUp() { myService = MyService()}

    // 余分なnullチェックなしにプロパティを参照する
    //@Test fun testAction() { Assert.assertEquals("foo", myService.performAction())}
}
