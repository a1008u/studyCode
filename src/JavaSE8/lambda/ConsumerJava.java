package JavaSE8.lambda;

import java.util.function.Consumer;

public class ConsumerJava {

    public static void main(String[] args) {

        /*
        void accept(T t)
        指定された引数でこのオペレーションを実行します。
        パラメータ : t - 入力引数
        */
        Consumer<String> consumer = string -> System.out.println("Cunsumer : " + string);
        consumer.accept("hoge"); // 結果：Cunsumer : hoge

        /*
        default Consumer<T> andThen(Consumer<? super T> after)
            このオペレーションを実行した後、続けてafterオペレーションを実行する合成Consumerを返します。
            いずれかのオペレーションの実行時に例外がスローされた場合、その例外は合成オペレーションの呼出し元に中継されます。
            このオペレーションの実行時に例外がスローされた場合、afterオペレーションは実行されません。
            パラメータ : after - このオペレーションの後で実行するオペレーション
            戻り値    : このオペレーションを実行した後、続けてafterオペレーションを実行する合成Consumer
            例外     : NullPointerException - afterがnullの場合
        */
        Consumer<String> hoge = string -> System.out.println("hoge : " + string);
        Consumer<String> fuga = string -> System.out.println("fuga : " + string);

        // 結果：hoge : piyo
        // 結果：fuga : piyo
        hoge.andThen(fuga).accept("piyo");
    }
}
