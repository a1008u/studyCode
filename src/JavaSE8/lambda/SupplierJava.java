package JavaSE8.lambda;

import java.util.function.Supplier;

public class SupplierJava {

    public static void main(String[] args) {

        /*
        T get()
        結果を取得します。
        戻り値 : 結果
        */
        Supplier<String> supplier = () -> "hoge";
        System.out.println(supplier.get()); // 結果：hoge
    }
}
