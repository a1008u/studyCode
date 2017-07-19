package JavaSE8.type2;

class FFoo {
  public void method(String s, int... a) {
    System.out.println(s + " サイズ : " + a.length);
    for(int i : a) {
      System.out.println(" 第2 引数の値 :" + i);
    }
  }
}
class Sample2_2 {
  public static void main(String[] args) {
    FFoo obj = new FFoo();
    int[] ary = {10, 20, 30};
    obj.method("1 回目");         
    obj.method("2 回目", 10);
    obj.method("3 回目", 10, 20); 
    obj.method("4 回目", ary);
    obj.method("5 回目", null);
  }
}

// Answer
// 1 回目 サイズ : 0
// 2 回目 サイズ : 1
//  第2 引数の値 :10
// 3 回目 サイズ : 2
//  第2 引数の値 :10
//  第2 引数の値 :20
// 4 回目 サイズ : 3
//  第2 引数の値 :10
//  第2 引数の値 :20
//  第2 引数の値 :30
// Exception in thread "main" java.lang.NullPointerException
//	 at type2.FFoo.method(Sample2_2.java:5)
//	 at type2.Sample2_2.main(Sample2_2.java:19)


/* 可変長引数のルール
	●データ型の後に「...」と記述する
	●可変長引数とデータ型の異なる引数を併用できる。ただし、可変長引数は最後に置く
	（例）voidmethod(Strings,int...a){}//OK
	     voidmethod(int...a,Strings){}//NG
	●可変長引数は1つしか使用できない
	（例）voidmethod(String...s,int...a){}//NG
	●引数リストを明確に定義したメソッドと、可変長引数を使用したメソッドが定義されている場合、
	 引数リストを明確に定義したメソッドが優先して呼び出される
	（例）参照変数名.method(10,20);と呼び出した場合
		voidmethod(int...a){}
		voidmethod(inta,intb){}//こちらが呼び出される
*/

