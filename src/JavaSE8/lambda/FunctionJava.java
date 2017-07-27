package JavaSE8.lambda;

import java.util.function.Function;

public class FunctionJava {
    public static void main(String[] args) {

        // R apply(T)
        Function<String, Integer> function = string -> Integer.parseInt(string);
        System.out.println(function.apply("12345")); // 結果：12345

        /*
        default <V> Function<V,R> compose(Function<? super V,? extends T> before)
        まず入力に関数beforeを適用し、次に結果にこの関数を適用する合成関数を返します。
        いずれかの関数の評価時に例外がスローされた場合、その例外は合成関数の呼出し元に中継されます。
        型パラメータ  : V - before関数および合成関数の入力の型
        パラメータ   :before - この関数を適用する前に適用する関数
        戻り値     :まずbefore関数を適用し、次にこの関数を適用する合成関数
        */
        Function<String, String> wrapDoubleQuotationCompose = str -> "\"" + str + "\"";
        Function<String, String> wrapSingleQuotationCompose = str -> "'" + str + "'";

        Function<String, String> wrapDoubleAndSingleQuotationCompose
                = wrapDoubleQuotationCompose.compose(wrapSingleQuotationCompose);

        // 結果："'hoge'"
        System.out.println(wrapDoubleAndSingleQuotationCompose.apply("hoge"));

        // 結果："'hoge'"
        System.out.println(wrapDoubleQuotationCompose.apply(wrapSingleQuotationCompose.apply("hoge"))); //


        /*
        default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
        まず入力にこの関数を適用し、次に結果に関数afterを適用する合成関数を返します。
        いずれかの関数の評価時に例外がスローされた場合、その例外は合成関数の呼出し元に中継されます。
        型パラメータ : V - after関数および合成関数の出力の型
        パラメータ  : after - この関数を適用した後で適用する関数
        戻り値     : まずこの関数を適用し、次にafter関数を適用する合成関数
        例外      : NullPointerException - afterがnullの場合
        関連項目  : compose(Function)
         */
        Function<String, String> wrapDoubleQuotationandThen = str -> "\"" + str + "\"";
        Function<String, String> wrapSingleQuotationandThen = str -> "'" + str + "'";

        Function<String, String> wrapDoubleAndSingleQuotation
                = wrapDoubleQuotationandThen.andThen(wrapSingleQuotationandThen);

        // 結果：'"hoge"'
        System.out.println(wrapDoubleAndSingleQuotation.apply("hoge"));

        /*
        static <T> Function<T,T> identity()
        常に入力引数を返す関数を返します。
        型パラメータ : T - 関数の入力および出力オブジェクトの型
        戻り値 : 常に入力引数を返す関数
        */
        Function<String, String> functionIdentity = Function.identity();
        // 結果：string message
        System.out.println(functionIdentity.apply("string message"));
    }
}