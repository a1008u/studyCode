package part1.Fortune;

/**
 * Created by AU on 2017/07/10.
 */
public class Fourtune {

	public static void main(String[] args) {

		// 運勢開始
		System.out.println("あなたの運勢を占います");
		int fortune = new java.util.Random().nextInt(4);

		// 運勢結果
		String result = fortune ==1 ?  "大吉": fortune ==2 ?  "中吉": fortune ==3 ?  "小吉": "吉";
		System.out.println(result);

//		if(fortune == 1) {
//			System.out.println("大吉");
//		} else if(fortune == 2) {
//			System.out.println(" 中吉");
//		} else if(fortune == 3) {
//			System.out.println("小吉");
//		} else {
//			System.out.println("吉");
//		}

	}
}
