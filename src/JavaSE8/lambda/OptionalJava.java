package JavaSE8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalJava {
    public static void main(String[] args) throws Exception {

        /*
        public T orElse(T other)
            存在する場合は値を返し、それ以外の場合はotherを返します。
        パラメータ : other - 存在する値がない場合に返される値、nullも可
        戻り値 : 値(存在する場合)、それ以外の場合はother
        */

        Integer value101 = IntegerList.get(0).orElse(-1) + 100;
        System.out.println("結果：" + value101); // 結果：101

        Integer value102 = IntegerList.get(1).orElse(-1) + 100;
        System.out.println("結果：" + value102); // 結果：102

        Integer value99 = IntegerList.get(2).orElse(-1) + 100;
        System.out.println("結果：" + value99); // 結果：99
    }

}

class IntegerList {
    // nullが含まれるIntegerの配列
    private final static List<Integer> INTEGER_LIST = Arrays.asList(new Integer[]{1, 2, null});

    // 戻り値にnullが含まれる可能性があるためOptionalでラップして返却する
    public static Optional<Integer> get(int index) {
        return Optional.ofNullable(INTEGER_LIST.get(index));
    }
}