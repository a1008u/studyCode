package JavaSE8.type8;

import java.io.*;

public class Sample8_8 {
  public static void main(String[] args) {
	  
	// シリアライズ(直列化) ⇄　デシリアライズ(直列化復元)
	// ・シリアライズまたは直列化
	// 　独自に定義したクラスから生成したオブジェクト（たとえばEmployeeオブジェクトなど）を、
	// 　オブジェクトのまま出力ストリームに書き出すこと。
	// ・デシリアライズまたは直列化復元
	// 　シリアライズされたオブジェクトを読み込んで、メモリ上に復元すること。
	// 
	// ＊ただし、シリアライズしたいオブジェクトはクラス定義の際に注意が必要です。
	// 　通常のクラス定義ではなく、シリアライズ可能なオブジェクトとなるようにクラス定義しなくてはいけません 。
	//  クラス定義時にimplements Serializableと記述

	// シリアライズ可能なオブジェクトの入出力には、ObjectInputStreamクラス、ObjectOutputStreamクラスを使用します。  
	  
    Employee2 writeEmp = new Employee2(100, "tanaka");
    
	// ObjectInputStream(InputStream in) throws IOException	
	//	 引数で指定されたInputStreamから読み込むObjectInputStream を作成
	// ObjectOutputStream(OutputStream out) throws IOException	
	//	 引数で指定されたOutputStream に書き出すObjectOutputStream を作成
    try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("src/type8/ren/8_8.txt"));
         ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("src/type8/ren/8_8.txt"))){
    	// 書き出し
    	// final void writeObject(Object obj) throws IOException	
		//   	 引数で指定されたオブジェクトをObjectOutputStreamに書き出す。
		//   	 引数のオブジェクトはシリアライズ可能なオブジェクトである必要がある
	    oos.writeObject(writeEmp); 
    	
    	// 読み込み
	    // final Object readObject() throws IOException,  ClassNotFoundException		
	    //		 ObjectInputStreamからオブジェクトを読み込む。戻り値はObject型
    	Employee2 readEmp = (Employee2)ois.readObject(); 
    	
    	System.out.println("ID  : " + readEmp.getId());
    	System.out.println("Name: " + readEmp.getName());
    	
    } catch (ClassNotFoundException | IOException e){
      e.printStackTrace();
    }
  }
}


//クラス定義時にimplements Serializableと記述
class Employee2 implements Serializable{
	private int id;
	private String name;
	public Employee2(int id, String name) {
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

// Answer
// ID  : 100
// Name: tanaka


// ObjectInputStreamクラスとObjectOutputStreamクラスの主なコンストラクタとメソッド
// ObjectInputStream(InputStream in) throws IOException	
//	 引数で指定されたInputStream から読み込むObjectInputStreamを作成
// ObjectOutputStream(OutputStream out) throws IOException	
//	 引数で指定されたOutputStream に書き出すObjectOutputStreamを作成

// メソッド名	説明
// final Object readObject() throws IOException,  ClassNotFoundException	
//	 ObjectInputStreamからオブジェクトを読み込む。戻り値はObject型
// final void writeObject(Object obj) throws IOException	
//	 引数で指定されたオブジェクトをObjectOutputStreamに書き出す。
//	 引数のオブジェクトはシリアライズ可能なオブジェクトである必要がある