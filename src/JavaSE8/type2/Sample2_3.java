package JavaSE8.type2;

class FFFoo {
  public void method(String... val) {
	  
    int ans = val == null ? 0 : val.length;
    System.out.println(val + " : " + ans);
  }
  
}

class Sample2_3 {
  public static void main(String[] args) {
    FFFoo obj = new FFFoo();
    obj.method("A", "B");
    // obj.method(null); // コンパイルエラー
    obj.method((String[])null);
    obj.method();
    obj.method((String)null);
  }
}

// Answer
// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//
//	at type2.Sample2_3.main(Sample2_3.java:8)

//Answer(part2)
// [Ljava.lang.String;@4e25154f : 2
// null : 0
// [Ljava.lang.String;@70dea4e : 0
// [Ljava.lang.String;@5c647e05 : 1