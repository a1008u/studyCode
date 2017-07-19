package JavaSE8.type2;

class Outer3 {
  private static int a = 1;    //static 変数
  private int b = 2;           // インスタンス変数
  
  void methodOuter(final int c, int d) {
    final int e = 5; 
    int f = 6;
    
    class A {
      void method() {
        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
        System.out.print(d + " ");
        System.out.print(e + " ");
        System.out.print(f);
        //e = 100;
        //f = 100;
      }
    }
    
    new A().method();
  }
}
class Sample2_22 {
  public static void main(String[] args) {
    Outer3 o = new Outer3();
    o.methodOuter(3, 4);
  }
}

// Answer
// 1 2 3 4 5 6

// ローカルクラスのルール
//・アクセス修飾子（public、protected、private）を使用できない
//・static修飾子を使用できない
//・abstract修飾子、final修飾子を使用できる
//・外側のクラスのメンバにアクセスできる
//・ローカルクラスから外側のクラスのメソッドの引数およびローカル変数にアクセスするには、各変数がfinal（定数）でなければならない。
// したがって、SE7までは、明示的なfinal修飾子の付与が必要であったが、SE8では、暗黙的にfinalが付与されるため、明示的な付与は不要