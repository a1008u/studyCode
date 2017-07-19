package JavaSE8.type2;

	class SSuper {    // スーパークラス
	  void methodA() { System.out.println("Super:methodA()");}
	  static void methodB() { System.out.println("Super:methodB()");}
	}

	class SSub extends SSuper {  // サブクラス
	  
	  // オーバーライド
	  void methodA() { System.out.println("Sub:methodA()");}
	  // static void methodA() { System.out.println("Sub:methodA()");}
	  
	  // 隠蔽
	  static void methodB() { System.out.println("Sub:methodB()");}
	  // void methodB() { System.out.println("Sub:methodB()");}
	}
	
	class Sample2_1 {
	  public static void main(String[] args) {
	    SSub obj = new SSub();
	    obj.methodA();
	    obj.methodB();
	  }
	}

//	Answer
//	Sub:methodA()
//	Sub:methodB()

//　is-a関係(サブクラスはスーパークラスの一種である)
//　　→SSubクラスはSSuperクラスの一種である
//　has-a関係(part-of関係)
//　　→Sample2_1 has a SSub
	
//オーバーライドのルール
// ・サブクラスがインスタンス化され、オーバーライドされたメソッドが呼び出された際は、
// 　サブクラスで再定義したメソッドが優先的に呼び出されます。
// ・オーバーライドは、メソッド名、引数リストがまったく同じであること、
// 　戻り値は、スーパークラスで定義したメソッドが返す型と同じか、
// 　その型のサブクラス型でなくてはいけません。これを「共変戻り値」と呼びます。
// 　また、アクセス修飾子はスーパークラスと同じものか、それよりも公開範囲が広いものを使用しなければいけません。
