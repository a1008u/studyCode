package JavaSE8.type8;

import java.io.*;

class Foo20 {
  Foo20() { System.out.println("Foo20()"); }
}
class Bar2 extends Foo20 implements Serializable{
  Bar2() { System.out.println("Bar2()"); }
}

public class Sample8_10 {
  public static void main(String[] args) {
	  
	// 実行結果を見ると、デシリアライズする際に、スーパークラスのコンストラクタが呼び出されていることがわかります。
	// このようにスーパークラスがSerializableインタフェースを実装していない場合は、
	// デシリアライズの際に引数を取らないコンストラクタを呼び出しインスタンス化します。

	// シリアライズ処理注意点
	// ●　配列（またはその他のコレクション）をシリアライズする場合は、その要素のそれぞれがシリアライズ可能でなければならない
	// ●　シリアライズされたオブジェクトがオブジェクト参照変数によって参照するすべてのオブジェクト
	//   （参照先のオブジェクト）はシリアライズ可能でなければならない
	// ●　static変数およびtransient指定された変数はシリアライズ対象外となる
	// ●　あるクラスがシリアライズ可能であれば、そのクラスをスーパークラスとするすべてのサブクラスは、
	//   たとえ明示的にSerializableインタフェースを実装していなくても、暗黙的にシリアライズ可能である
	// ●　サブクラスがSerializableインタフェースを実装している場合、スーパークラスはデシリアライズの際にインスタンス化される   
	  
    Bar2 obj = new Bar2();
    System.out.println("----- インスタンス化完了");
    
    try (ObjectOutputStream oos = new ObjectOutputStream(
                 new FileOutputStream("src/type8/ren/8_10.txt"));
         ObjectInputStream ois = new ObjectInputStream(
                 new FileInputStream("src/type8/ren/8_10.txt"))){
      oos.writeObject(obj);
      System.out.println("----- シリアライズ完了");
      Bar2 readObj = (Bar2)ois.readObject();
      System.out.println("----- デシリアライズ完了");
    } catch (ClassNotFoundException | IOException e){
      e.printStackTrace();
    }
  }
}

// Foo20()　// デフォルトコンストラクタより
// Bar2()
// ----- インスタンス化完了
// ----- シリアライズ完了
// Foo20() // サブクラスがSerializableインタフェースを実装している場合、スーパークラスはデシリアライズの際にインスタンス化される   
// ----- デシリアライズ完了

