package part1.sample;

public class Human {

    private String name;
    private int height;
    private int weight;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "名前:" + getName()
                + "\n"
                + "身長:" + String.valueOf(getHeight()) + "cm"
                + "\n"
                + "体重:" + String.valueOf(getWeight()) + "kg" ;
    }

}
