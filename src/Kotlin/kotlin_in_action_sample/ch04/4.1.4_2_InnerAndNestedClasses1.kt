package ch04.ex1_4_2_InnerAndNestedClasses1

class Outer {
    // 内部クラス（外部クラスへの参照を保持）
    inner class Inner {
        // this@OuterはInnerクラスからOuterクラスへアクセスする方法
        fun getOuterReference(): Outer = this@Outer
    }
}
