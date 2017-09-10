package part1.sample;

public class Human2 {

    private String name;
    private int height;
    private int weight;

    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "名前:" + getName()
                + "\n"
                + "身長:" + String.valueOf(getHeight()) + "cm"
                + "\n"
                + "体重:" + String.valueOf(getWeight()) + "kg" ;
    }

    /**
     * コンストラクタ
     * @param name
     * @param height
     * @param weight
     */
    public Human2(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}
