package JavaSE8.type2;

abstract class XX {             
  abstract void methodA();   //抽象メソッド
  void methodB(){ }          //具象メソッド
}
abstract class YY extends XX {
  //8行目はmethodA()をオーバーライドするつもりが
  //間違えてmethod()として定義した場合
  void method(){ }           //具象メソッド
  abstract void methodC();   //抽象メソッド
} 

