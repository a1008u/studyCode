package JavaSE8.type2;

abstract class XXX {
  static void methodA() { System.out.println("methodA()"); }
  void methodB() { System.out.println("methodB()"); }
}

class YYY extends XXX { }

class Sample2_7 {
  public static void main(String[] args) {
    XXX.methodA();  //OK
    //  XXX obj1 = new XXX();  
    // obj1.methodB();  //NG
    YYY obj2 = new YYY(); 
    obj2.methodB();  //OK
  }
}

// Answer
// methodA()
// methodB()
