package JavaSE8.lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorJava {

    public static void main(String[] args) {

        /*
        static <T> UnaryOperator<T> identity()
        常に入力引数を返す単項演算子を返します。
        定義        : インタフェースFunction<T,T>内のidentity
        型パラメータ : T - 演算子の入力および出力の型
        戻り値      : 常に入力引数を返す単項演算子
         */

        UnaryOperator<String> unary = string -> "[" + string + "]";
        System.out.println(unary.apply("hoge")); // 結果：[hoge]
    }

}
