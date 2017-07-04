package part1_3;


import java.util.InputMismatchException;

/**
 * Created by AU on 2017/06/30.
 */
public class Numbers_type5_O_Number {

    /**
     * ユーザ入力値を取得
     * @return  userInput
     *
     */
    public int getUserInput() {

        int userInput;
        do {
            try{
                System.out.print("数値を入力 : ");
                userInput = new java.util.Scanner(System.in).nextInt();

            } catch(InputMismatchException e)  {
                System.out.println("入力値の型が違います：" + e);
                System.out.println("注意：1~9の数字を入力してください。");

                // 入力値の初期化
                userInput = 0;
            }
            // 入力チェック(チェック観点：数値の値)
        } while (userInput >= 10 || userInput == 0);

        return userInput;
    }

    /**
     * 入力値と設定している答えが一致しているか確認する
     * @param answer
     * @parm userInput
     * @return  userInput
     *
     */
    public void checkUserinput(Numbers_type5_O_player player, int answer, int userInput) {
        if (userInput == answer) {
            int hit = player.getHit();
            player.setHit(++hit);
        } else {
            int blow = player.getBlow();
            player.setBlow(++blow);
        }
        System.out.println("ヒット" + player.getHit() + " ブロー" + player.getBlow());
    }

    /**
     * 数値判定後の結果を表示する。
     * @param answer
     * @param gamePlaycount
     *
     */
    public void resultConfirm(Numbers_type5_O_player player, int answer, int gamePlaycount) {
        String result = "*** 結果 *** ";
        if (player.getHit() == 1) {
            System.out.println();
            System.out.println(result);
            System.out.println("おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ");
            System.out.println();
        } else {
            System.out.println();

            if(player.getHit() == 0 && gamePlaycount >=3 ){
                System.out.println();
                System.out.println(result);
                System.out.println("残念でした(；一ω一||)");
                System.out.println("答えは【" + answer + "】");
                System.out.println();
            }
        }
    }

    /**
     * ゲームを続けるかどうか判定する
     * @return  morePlay
     *
     */
    public boolean isMoreplay(Numbers_type5_O_player player) {

        // 入力値の初期化(終了状態)
        int morePlay = 2;

        try{
            // 入力説明
            System.out.printf("%14s%n", "もう１度ゲームをする場合：1");
            System.out.printf("%16s%n", "            やめまーす：2");
            System.out.printf("%15s"  , "     どちらにしますか？：");

            // 入力値の確認
            do {
                morePlay = new java.util.Scanner(System.in).nextInt();

                if(!(morePlay == 0) && !(morePlay >= 3)) break;

                System.out.println("注意：1(続ける)または2(やめる)どちらかの値を入力してください。");
                System.out.printf("%15s"  , "     どちらにしますか？：");
            } while (true);

            // ゲームを続けるか確認
            if(morePlay == 1) {
                player.setHit(0);
                player.setBlow(0);
                return true;
            }

        } catch(InputMismatchException e)  {
            System.out.println("入力値の型が違います：" + e);
            System.out.println("注意：強制的に終了します。");
        }

        // ゲームをやめる
        return false;
    }
}
