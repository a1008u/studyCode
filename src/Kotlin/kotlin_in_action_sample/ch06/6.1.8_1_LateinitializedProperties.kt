package ch06.ex1_8_1_LateinitializedProperties

//import org.junit.Before
//import org.junit.Test
//import org.junit.Assert

class MyService { fun performAction(): String = "foo" }

class MyTest {
    // null許容型のプロパティを宣言し、nullで初期化
    private var myService: MyService? = null

//    初期化
//    @Before fun setUp() { myService = MyService()}

//    !!や?を使ったりしてnull許容性の区別に気をつける必要がある
//    @Test fun testAction() { Assert.assertEquals("foo",　myService!!.performAction())}
}
