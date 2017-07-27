package JavaSE8.lambda;

import java.util.function.BinaryOperator;

public class BinaryOperatorJava {

    public static void main(String[] args) {

        /*
        static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
            指定されたComparatorに従って2つの要素の大きいほうを返すBinaryOperatorを返します。
        型パラメータ : T - コンパレータの入力引数の型
        パラメータ  : comparator - 2つの値を比較するためのComparator
        戻り値     : 指定されたComparatorに従ってオペランドの大きいほうを返すBinaryOperator
        例外      : NullPointerException - 引数がnullの場合
        */
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(Integer::compare);
        System.out.println(maxBy.apply(21, 10)); // 21


        /*
        static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
            指定されたComparatorに従って2つの要素の小さいほうを返すBinaryOperatorを返します。
        型パラメータ : T - コンパレータの入力引数の型
        パラメータ  : comparator - 2つの値を比較するためのComparator
        戻り値     : 指定されたComparatorに従ってオペランドの小さいほうを返すBinaryOperator
        例外      : NullPointerException - 引数がnullの場合
        */
        BinaryOperator<Integer> minBy = BinaryOperator.minBy(Integer::compare);
        System.out.println(minBy.apply(21, 10)); // 10
    }

}
