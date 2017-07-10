package part1.Fortune;

import java.util.InputMismatchException;

/**
 * Created by AU on 2017/07/10.
 */
public class Fourtune2 {

	public static void main(String[] args) {

		boolean morePlay = false;

		do {
			System.out.println("あなたの運勢を占います");

			int fortune = new java.util.Random().nextInt(4);

			switch (fortune) {
				case 1:
					System.out.println("大吉");
					break;
				case 2:
					System.out.println("中吉");
					break;
				case 3:
					System.out.println("小吉");
					break;
				default:
					System.out.println("吉");
			}

			//  もう一回やる
			int userIntention = 2;
			try{
				// 入力説明
				System.out.printf("%14s%n", "もう１度ゲームをする場合：1");
				System.out.printf("%16s%n", "            やめまーす：2");
				System.out.printf("%15s"  , "     どちらにしますか？：");

				// 入力値の確認
				do {
					// 入力
					userIntention = new java.util.Scanner(System.in).nextInt();

					// 入力値の判定
					if(!(userIntention == 0) && !(userIntention >= 3)) break;

					// 入力値の型は正しいが値が不正の場合にサイド入力を求める
					System.out.println("注意：1(続ける)または2(やめる)どちらかの値を入力してください。");
					System.out.printf("%15s"  , "     どちらにしますか？：");
				} while (true);

				// もう一度ゲームを実施するか判定(1：ゲームを続ける)
				if(userIntention == 1) morePlay = true;

			} catch(InputMismatchException e)  {
				System.out.println("入力値の型が違います：" + e);
				System.out.println("注意：強制的に終了します。");
			}

		}while (morePlay);

	}
}
