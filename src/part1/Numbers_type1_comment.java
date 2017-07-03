package part1;

/**
 * Created by AU on 2017/06/30.
 */
public class Numbers_type1_comment {
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

        System.out.println(title);
        System.out.println(rule);

        //ゲーム開始------------------------------------------------------
        // もう一度ゲームを実行するか判定結果を格納する変数
        Boolean morePlay = false;

        do {
            // 答えの作成
            int answer = new java.util.Random().nextInt(9) + 1;

            // hitとbrowの変数の初期化、ゲームカウントとユーザ入力値の初期化
            int hit = 0, blow = 0, gamePlaycount = 0, userInput;

            for (int k = 0; k < 3; k++) {
                // ゲーム回数を表示(毎回インクリメント)
                System.out.println("*** " + ++gamePlaycount + "回目 ***");

                //インプット------------------------------------------------
                // 入力値の入力回数の初期化
                int inputCount = 0;
                do {
                    // 入力値の入力回数を確認
                    if (inputCount > 0) System.out.println("注意：1~9の数字を入力してください。");

                    // ユーザが数値を入力処理
                    System.out.print("数値を入力 : ");
                    userInput = new java.util.Scanner(System.in).nextInt();
                    inputCount++;

                    // 入力チェック(チェック観点：数値の値)
                } while (userInput >= 10 || userInput == 0);

                //答え判断------------------------------------------------------
                if (userInput == answer) {
                    // 入力値と想定結果が一致
                    hit++;
                } else {
                    // 入力値と想定結果が不一致
                    blow++;
                }
                System.out.println("ヒット" + hit + " ブロー" + blow);

                //終了判断------------------------------------------------------
                String result = "*** 結果 *** ";
                if (hit == 1) {
                    // 入力値と想定結果が一致の場合
                    System.out.println();
                    System.out.println(result);
                    System.out.println("おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ おめでとー(｡･ω･ﾉﾉﾞﾊﾟﾁﾊﾟﾁ");
                    System.out.println();
                    break;
                } else {
                    // 入力値と想定結果が不一致の場合
                    System.out.println();

                    if(hit == 0 && gamePlaycount >=3 ){
                        // 入力値と想定結果が不一致かつゲーム回数が上限を上回った場合
                        System.out.println();
                        System.out.println(result);
                        System.out.println("残念でした(；一ω一||)");
                        System.out.println("答えは【" + answer + "】");
                        System.out.println();
                    }
                }
            }

            //再挑戦するか尋ねる--------------------------------------------------
            System.out.printf("%14s%n", "もう１度ゲームをする場合：1");
            System.out.printf("%16s%n", "            やめまーす：2");
            System.out.printf("%15s"  , "     どちらにしますか？：");
            if(new java.util.Scanner(System.in).nextInt() == 1) morePlay = true;

        }while (morePlay);
    }
}
