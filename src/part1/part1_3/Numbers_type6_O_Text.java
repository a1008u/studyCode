package part1.part1_3;

/**
 * Created by AU on 2017/07/04.
 */
public enum Numbers_type6_O_Text {

	Numbers_type6_O_Text("*** タイトル：数当てHit&Brow ***",
					"Rule--------------------------------------\n"
					+ "\t・3回以内にランダムで設定されている数字（1〜9）を当てよ\n"
					+ "\t・打鍵できる回数：3回まで\n"
					+ "\t・入力した数値が想定内の数値の場合：HIT　→　ゲーム終了\n"
					+ "\t・入力した数値が想定内の数値でないの場合：Browのカウントアップ\n"
					+ "\t応援：なるべくBrowのカウントアップせずにクリアしよう\n");

	private final String title;
	private final  String explain;

	private Numbers_type6_O_Text(final String title, final String explain) {
		this.title = title;
		this.explain = explain;
	}

	public String getTitle() {
		return this.title;
	}

	public String getExplain() {
		return this.explain;
	}

}
