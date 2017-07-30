package part1.part1_4;


import java.util.InputMismatchException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Created by AU on 2017/06/30.
 */
public class Numbers_type6_O_Number {

    /**
     * ユーザ入力値を取得
     *
     * @param player
     */
    public void getUserInput(Numbers_type6_O_player player) {

        int userInput;
        do {
            try{
                out.print("数値を入力 : ");
                userInput = new java.util.Scanner(System.in).nextInt();

            } catch(InputMismatchException e)  {
                out.println("入力値の型が違います：" + e);
                out.println("注意：1~9の数字を入力してください。");

                // 入力値の初期化
                userInput = 0;
            }
            // 入力チェック(チェック観点：数値の値)
        } while (userInput >= 10 || userInput == 0);

        player.setInput(userInput);
    }

    /**
     * 入力値と設定している答えが一致しているか確認する
     * @param answer
     * @parm userInput
     * @return  userInput
     *
     */
    public void checkUserinput(Numbers_type6_O_player player, int answer) {


        Stream.of(player).filter(player1 -> player1.getInput() == answer)
                    .forEach(player1 -> player1.setHit(player1.getHit()+1));

        Stream.of(player).filter(player1 -> player1.getInput() != answer)
                .forEach(player1 -> player1.setBlow(player1.getBlow() +1));

        out.println("ヒット" + player.getHit() + " ブロー" + player.getBlow());
    }

    /**
     * 数値判定後の結果を表示する。
     * @param answer
     * @param gamePlaycount
     *
     */
    public boolean resultConfirm(Numbers_type6_O_player player, int answer, int gamePlaycount) {


        Function<Numbers_type6_O_player, Boolean> result = play -> {

            boolean tmpResult = Stream.of(play)
                    .filter(play1 -> play1.getHit() == 1)
                    .peek(play1 -> out.println("\n" + "*** 結果 *** " +
                                               "\n" + "おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ" +
                                               "\n"))
                    .anyMatch(play1 -> play1.getHit() == 1);

            if (!tmpResult) {
                Stream.of(play)
                      .filter(play1 -> play1.getHit() == 0 && gamePlaycount >=3)
                      .forEach(play1 -> out.println(("\n" + "*** 結果 *** " +
                                                     "\n" + "残念でした(；一ω一||)" +
                                                     "\n" + "答えは【" + answer + "】" +
                                                     "\n")));
            }

            return tmpResult;
        };

        return result.apply(player);
    }

    /**
     * ゲームを続けるかどうか判定する
     * @return  morePlay
     *
     */
    public boolean isMoreplay(Numbers_type6_O_player player) {

        Predicate<Numbers_type6_O_player> morePlay = play -> {
            try{
                // 入力値の確認
                Supplier<Integer> userWill = () -> {
                    int input;
                    do {
                        input = new java.util.Scanner(System.in).nextInt();

                        if(!(input == 0 || input >= 3)) break;

                        out.printf("%15s"  , "注意：1(続ける)または2(やめる)どちらかの値を入力してください。")
                           .printf("%15s"  , "     どちらにしますか？：");
                    } while (true);
                    return input;
                };

                // 入力説明
                out.printf("%14s%n", "もう１度ゲームをする場合：1")
                   .printf("%16s%n", "            やめまーす：2")
                   .printf("%15s"  , "     どちらにしますか？：");

                // ゲームを続けるか確認
                if(userWill.get() == 1) {
                    player.setHit(0);
                    player.setBlow(0);
                    return true;
                }

            } catch(InputMismatchException e)  {
                out.println("入力値の型が違います：" + e);
                out.println("注意：強制的に終了します。");
            }

            return false;
        };

        return morePlay.test(player);

    }
}
