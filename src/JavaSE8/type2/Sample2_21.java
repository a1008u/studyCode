package JavaSE8.type2;

class Outer2 {  // 外側のクラス
  private int num = 100;
  
  class A {
    public int num = 200;
    void method(int num) {
      System.out.println("num : " + num);
      System.out.println("this.num : " + this.num);
      System.out.println("Outer.this.num : " + Outer2.this.num);
    }
  }
  
}

class Sample2_21 {  // 外部のクラス
  public static void main(String[] args) {
    new Outer2().new A().method(300);
  }
}

// Answer
// num : 300
// this.num : 200
// Outer.this.num : 100