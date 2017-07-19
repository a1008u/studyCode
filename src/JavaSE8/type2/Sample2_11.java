package JavaSE8.type2;

interface MyInter1b { void methodA(); }

class Superb { void methodB(){ } }

class MyClassb extends Superb implements MyInter1b {
  @Override
  public void methodA(){ }
}
