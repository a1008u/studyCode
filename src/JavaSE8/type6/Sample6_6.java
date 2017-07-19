package JavaSE8.type6;

//独自例外クラス
class MyException extends Exception { 
  private int age;
  public void setAge(int age) { this.age = age; }
  public int getAge() { return this.age; }
}

public class Sample6_6 {
  public static void main(String[] args){
	
	// throw
	// 例外はJava実行環境がスローするだけでなく、
	// throwキーワードを使用してプログラム内で明示的にスローすることもできます。
	// throwキーワードを使用すると、Java言語で提供されている例外クラスや
	// 独自例外クラスをインスタンス化した例外オブジェクトを、任意の場所でスローできます。

	//（例1 ）	throw new IOException();
	//（例2 ）	IOException e = new IOException();
	//	        throw e;  
	  
    try {
      int age = -10;
      checkAge(age);
    } catch (MyException e) {
      System.out.println(" 不正な値です。age : " + e.getAge());
    }
  }
  public static void checkAge(int age) throws MyException{
    if (age >= 0) {
      System.out.println("OK");
    } else {
      MyException e = new MyException();
      e.setAge(age);
      throw e;
    }
  }
}

// Answer
// 不正な値です。age : -10