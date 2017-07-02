package part1;


import java.util.InputMismatchException;

/**
 * Created by AU on 2017/06/30.
 */
public class Fortune_type3_method_comment {
    /**
     * タイトル：数当てHit&Brow
     * Rule--------------------------------------
     * ・3回以内にランダムで設定されている数字（1〜9）を当てよ
     * ・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了
     * ・打鍵できる回数：3回まで
     * ・入力した数値が想定内の数値でないの場合：Browのカウントアップ
     * 応援：なるべくBrowのカウントアップせずにクリアしよう
     *
     * @param args
     */
    public static void main(String[] args) {
        // タイトル&ルール-----------------------------------------------
        String title = "*** タイトル：数当てHit&Brow ***";
        String rule = "Rule--------------------------------------\n"
                + "\t・3回以内にランダムで設定されている数字（1〜9）を当てよ\n"
                + "\t・打鍵できる回数：3回まで\n"
                + "\t・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了\n"
                + "\t・入力した数値が想定内の数値でないの場合：Browのカウントアップ\n"
                + "\t応援：なるべくBrowのカウントアップせずにクリアしよう\n";

        //タイトルとルールを表示
        System.out.println(title);
        System.out.println(rule);

        //ゲーム開始------------------------------------------------------
        do {
            // 答えを作成
            int answer = new java.util.Random().nextInt(10);

            // hit_browを配列として準備
            int[] hit_blow = new int[2];
            hit_blow[0] = 0;
            hit_blow[1] = 0;

            for (int gamePlaycount = 1; gamePlaycount < 4; ++gamePlaycount) {
                // ゲーム回数を表示(毎回インクリメント)
                System.out.println("*** " + gamePlaycount + "回目 ***");

                // インプット
                int userInput = getUserInput();

                // 答え判断
                checkUserinput(answer, hit_blow, userInput);

                // 終了判断
                resultConfirm(answer, hit_blow, gamePlaycount);
            }
        }while (isMoreplay());
    }

    /**
     * ユーザ入力値を取得
     * @return  userInput
     *
     */
    private static int getUserInput() {

        int userInput;
        do {
            try{
                // 入力説明　+　入力
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
     * @param hit_blow
     * @parm userInput
     * @return  userInput
     *
     */
    private static void checkUserinput(int answer, int[] hit_blow, int userInput) {
        if (userInput == answer) {
            hit_blow[0]++;
        } else {
            hit_blow[1]++;
        }
        System.out.println("ヒット" + hit_blow[0] + " ブロー" + hit_blow[1]);
    }

    /**
     * 数値判定後の結果を表示する。
     * @param answer
     * @param hit_blow
     * @param gamePlaycount
     *
     */
    private static void resultConfirm(int answer, int[] hit_blow, int gamePlaycount) {
        String result = "*** 結果 *** ";
        if (hit_blow[0] == 1) {
            System.out.println();
            System.out.println(result);
            System.out.println("おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ");
            System.out.println();
        } else {
            System.out.println();

            if(hit_blow[0] == 0 && gamePlaycount >=3 ){
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
     * @return  false ゲームをやめる（続ける場合はtrue）
     *
     */
    private static boolean isMoreplay() {

        // 入力値の初期化(終了状態)
        int morePlay = 2;

        try{
            // 入力説明
            System.out.printf("%14s%n", "もう１度ゲームをする場合：1");
            System.out.printf("%16s%n", "            やめまーす：2");
            System.out.printf("%15s"  , "     どちらにしますか？：");

            // 入力値の確認
            do {
                // 入力
                morePlay = new java.util.Scanner(System.in).nextInt();

                // 入力値の判定
                if(!(morePlay == 0) && !(morePlay >= 3)) break;

                // 入力値の型は正しいが値が不正の場合にサイド入力を求める
                System.out.println("注意：1(続ける)または2(やめる)どちらかの値を入力してください。");
                System.out.printf("%15s"  , "     どちらにしますか？：");
            } while (true);

            // もう一度ゲームを実施するか判定(1：ゲームを続ける)
            if(morePlay == 1) return true;

        } catch(InputMismatchException e)  {
            System.out.println("入力値の型が違います：" + e);
            System.out.println("注意：強制的に終了します。");
        }

        // ゲームをやめる
        return false;
    }
}
