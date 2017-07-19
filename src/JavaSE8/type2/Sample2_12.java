package JavaSE8.type2;

interface MyInter1c {
  default void method() { 
	  System.out.println("MyInter1"); 
  }
}
class MyClassc implements MyInter1c {
  @Override
  public void method() { 
	  System.out.println("MyClass"); 
  }
}
