package JavaSE8.type3;

// ジェネリックスを用いた独自クラス
// インタフェースの場合もimplementsではなくextendsを使う
// TはNumberかその実装クラス
class Gen3<T extends Number> {
  private T var;
  public Gen3(T var) { this.var = var; }
  public void display() { System.out.println(var); }
}

// 利用する側のクラス
public class Sample3_16 {
  public static void main(String[] args) {
    // Integerを扱うGenオブジェクトの生成
    Gen3<Integer> g1 = new Gen3<>(100);
    g1.display();
    
    // Doubleを扱うGenオブジェクトの生成
    Gen3<Double> g2 = new Gen3<>(3.14);
    g2.display();
  }
}

// Answer
// 100
// 3.14
