package JavaSE8.type2;

interface FSoo {
  static void method() { //暗黙的にpublicが付与される
    System.out.println("Foo : method()");
  }
}
class Sample2_9 {
  public static void main(String[] args) {
    FSoo.method();
    //FSoo obj = new FSoo(); 
    // obj.method(); //コンパイルエラー
  }
}

// Answer
// Foo : method()
