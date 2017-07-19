package JavaSE8.type8;

import java.io.Serializable;

// クラス定義時にimplements Serializableと記述
public class Employee implements Serializable{
  private int id;
  private String name;
  public Employee(int id, String name) {
    this.id = id; this.name = name;
  }
  // Serializableインタフェースはメソッドをもたないため
  // オーバーライドしなければならないメソッドはない
  public int getId() {
    return this.id;
  }
  public String getName() {
    return this.name;
  }
}
