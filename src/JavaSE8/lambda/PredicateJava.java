package JavaSE8.lambda;

import java.util.function.Predicate;

public class PredicateJava {

    public static void main(String[] args) {


        /*
        boolean test(T t)
            指定された引数でこの述語を評価します。
        パラメータ: t - 入力引数
        戻り値   : 入力引数が述語に一致する場合はtrue、それ以外の場合はfalse
        */
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println(predicate.test(""));      // true
        System.out.println(predicate.test("hoge"));  // false

        /*
        static <T> Predicate<T> isEqual(Object targetRef)
            2つの引数が等しいかどうかをObjects.equals(Object, Object)に従ってテストする述語を返します。
        型パラメータ : T - 述語の引数の型
        パラメータ : targetRef - 等しいかどうかの比較対象として使用するオブジェクト参照(nullも可)
        戻り値 : 2つの引数が等しいかどうかをObjects.equals(Object, Object)に従ってテストする述語
        */
        Predicate<String> isHoge = Predicate.isEqual("hoge");
        System.out.println(isHoge.test("hoge")); // true
        System.out.println(isHoge.test("fuga")); // false

        Predicate<Object> isNull = Predicate.isEqual(null);
        System.out.println(isNull.test(null)); // true
        System.out.println(isNull.test("not null")); // false

        /*
        default Predicate<T> and(Predicate<? super T> other)
            この述語と別の述語の短絡論理積を表す合成述語を返します。
            合成述語の評価時にこの述語がfalseだった場合、述語otherは評価されません。
            いずれかの述語の評価時にスローされた例外はすべて呼出し元に中継されます。
            この述語の評価時に例外がスローされた場合、述語otherは評価されません。
        パラメータ : other - この述語との論理積を取る述語
        戻り値    : この述語と述語otherの短絡論理積を表す合成述語
        例外     : NullPointerException - otherがnullの場合
         */
        Predicate<String> isUpperCase = string -> string.matches("[A-Z]+");
        Predicate<String> isAlphabet  = string -> string.matches("[a-zA-Z]+");

        Predicate<String> predicateIs = isAlphabet.and(isUpperCase);
        System.out.println(predicateIs.test("HOGE")); // true
        System.out.println(predicateIs.test("hoge")); // false

        /*
        default Predicate<T> or(Predicate<? super T> other)
            この述語と別の述語の短絡論理和を表す合成述語を返します。
            合成述語の評価時にこの述語がtrueだった場合、述語otherは評価されません。
            いずれかの述語の評価時にスローされた例外はすべて呼出し元に中継されます。
            この述語の評価時に例外がスローされた場合、述語otherは評価されません。
        パラメータ : other - この述語との論理和を取る述語
        戻り値 : この述語と述語otherの短絡論理和を表す合成述語
        例外 : NullPointerException - otherがnullの場合
        */
        Predicate<String> isUpperCase2 = string -> string.matches("[A-Z]+");
        Predicate<String> isNumber    = string -> string.matches("\\d+");

        Predicate<String> predicateOr = isNumber.or(isUpperCase2);
        System.out.println(predicateOr.test("HOGE")); // true
        System.out.println(predicateOr.test("1234")); // true
        System.out.println(predicateOr.test("hoge")); // false

        /*
        default Predicate<T> negate()
            この述語の論理否定を表す述語を返します。
        戻り値 : この述語の論理否定を表す述語
        */
        Predicate<String> isEmpty = string -> string.isEmpty();

        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isNotEmpty.test("hoge")); // true
        System.out.println(isNotEmpty.test(""));     // false
    }
}
