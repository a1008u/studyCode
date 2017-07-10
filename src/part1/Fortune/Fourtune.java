package part1.Fortune;

/**
 * Created by AU on 2017/07/10.
 */
public class Fourtune {

	public static void main(String[] args) {

		System.out.println("あなたの運勢を占います");
		int fortune = new java.util.Random().nextInt(4);

		if(fortune == 1) {
			System.out.println("大吉");
		} else if(fortune == 2) {
			System.out.println(" 中吉");
		} else if(fortune == 3) {
			System.out.println("小吉");
		} else {
			System.out.println("吉");
		}

	}
}
