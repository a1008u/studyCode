package part1.sample;

public class PhysicalMeasurement {

    public static void main(String[] args) {

        System.out.println("【コンストラクタ実装なし】======");

        Human human = new Human();
        human.setName("鈴木　二郎");
        human.setHeight(170);
        human.setWeight(60);
        System.out.println(human.toString());

        System.out.println("============================");



        System.out.println("【コンストラクタ実装あり】======");

        Human2 human2 = new Human2("高田　龍一",162,72);
        System.out.println(human2.toString());

        System.out.println("============================");


    }

}
