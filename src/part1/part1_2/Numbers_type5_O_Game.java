package part1.part1_2;

import java.util.Random;

/**
 * Created by AU on 2017/07/03.
 */
public class Numbers_type5_O_Game {

	public Numbers_type5_O_Game() {

	}

	/**
	 * タイトル：数当てHit&Brow
	 * Rule--------------------------------------
	 * ・3回以内にランダムで設定されている数字（1〜9）を当てよ
	 * ・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了
	 * ・打鍵できる回数：3回まで
	 * ・入力した数値が想定内の数値でないの場合：Browのカウントアップ
	 * 応援：なるべくBrowのカウントアップせずにクリアしよう
	 *
	 * @param player
	 * @param Number
	 *
	 */
	public void numbers(Numbers_type5_O_player player, Numbers_type5_O_Number Number){

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

		do {
			// 答えを作成
			int answer = new Random().nextInt(9) + 1;

			// ユーザが数値を入力し、その結果を判定し、結果を表示する
			for (int gamePlaycount = 1; gamePlaycount < 4; ++gamePlaycount) {
				System.out.println("*** " + gamePlaycount + "回目 ***");

				int userInput = Number.getUserInput();

				Number.checkUserinput(player, answer, userInput);

				Number.resultConfirm(player, answer, gamePlaycount);
			}
		} while (Number.isMoreplay(player));
	}
}
