package JavaSE8.type2;

class FAoo {
  public void method(int a) {
    System.out.println("method(int a)");
  }
  public void method(long a) {
    System.out.println("method(long val)");
  }
  public void method(Integer a) {
    System.out.println("method(Integer val)");
  }
  public void method(int... a) {
    System.out.println("method(int... a)");
  }
  // public void method(int[] a) {
  //   System.out.println("method(int... a)");
  // }
}

class Sample2_4 {
  public static void main(String[] args) {
    FAoo obj = new FAoo();
    obj.method(100);
  }
}

// Answer
// method(int a)

// オーバーロードされたメソッドの呼び出し順位
// 完全一致　>　暗黙の型変換　>　Autoboxing　>　可変長引数