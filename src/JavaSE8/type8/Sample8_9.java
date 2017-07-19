package JavaSE8.type8;

import java.io.*;

class Foo implements Serializable {
  Foo() { System.out.println("Foo()"); }
}
class Bar extends Foo {
  Bar() { System.out.println("Bar()"); }
}

public class Sample8_9 {
  public static void main(String[] args) {
	  
	// シリアライズの継承
	// あるクラスのオブジェクトをシリアライズする場合、
	//  そのクラスが直接Serializableインタフェースを実装していなくても、
	//  スーパークラスがSerializableインタフェースを実装していればシリアライズ可能です。  
	  
    Bar obj = new Bar();
    System.out.println("----- インスタンス化完了");
    
    try (ObjectOutputStream oos = new ObjectOutputStream(
                 new FileOutputStream("src/type8/ren/8_9.txt"));
         ObjectInputStream ois = new ObjectInputStream(
                 new FileInputStream("src/type8/ren/8_9.txt"))){
    	
	      oos.writeObject(obj);
	      System.out.println("----- シリアライズ完了");
	      
	      Bar readObj = (Bar)ois.readObject();
	      System.out.println("----- デシリアライズ完了");
	      
    } catch (ClassNotFoundException | IOException e){
      e.printStackTrace();
    }
  }
}

// Answer
//  Foo()
//  Bar()
//  ----- インスタンス化完了
//  ----- シリアライズ完了
//  ----- デシリアライズ完了