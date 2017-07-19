package JavaSE8.type3;

//クラス名の後に型パラメータリスト指定
class Gen<T> {  
  private T var1;
  //private static T var2; //コンパイルエラー
  public Gen(T var1) { this.var1 = var1; }
  public T getVar1() { return var1; }
  public void setVar1(T var1) { this.var1 = var1; }
}

public class Sample3_13 {
  public static void main(String[] args) {
	// 型パラメタは参照型のみ
    Gen<String> g1 = new Gen<>("ABC");
    System.out.print(g1.getVar1());
    
    g1.setVar1("DEF");
    System.out.println(" " + g1.getVar1());
    
    Gen<Integer> g2 = new Gen<>(1);
    System.out.print(g2.getVar1());
    
    g2.setVar1(2);
    System.out.println(" " + g2.getVar1());
  }
}

// Answer
// ABC DEF
// 1 2

// ジェネリックスを用いた独自定義
//　・クラス定義
//　・メソッド定義
//　・インタフェース定義