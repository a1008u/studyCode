package part1.part1_4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by AU on 2017/07/03.
 */
public class Numbers_type6_O_Game {

	public Numbers_type6_O_Game() {

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
	public void numbers(Numbers_type6_O_player player, Numbers_type6_O_Number Number){

		// タイトル&ルール-----------------------------------------------

		// タイトルとルールを表示
		Numbers_type6_O_Text text = Numbers_type6_O_Text.Numbers_type6_O_Text;
		System.out.println(text.getTitle());
		System.out.println(text.getExplain());

		do {
			int answer = new Random().nextInt(9) + 1;

			// ユーザが数値を入力し、その結果を判定し、結果を表示する
			for(Integer count : Arrays.asList(1,2,3)){
				System.out.printf("*** %d回目 ***%n", count);

				Number.getUserInput(player);

				Number.checkUserinput(player, answer);

				if(Number.resultConfirm(player, answer, count)) break;
			}

		} while (Number.isMoreplay(player));
	}
}
