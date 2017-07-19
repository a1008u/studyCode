package JavaSE8.type2;

abstract class X {               // 抽象クラス
  protected abstract void methodA();
}

abstract class Y extends X { }   // 抽象クラス

class Z extends Y {              // 具象クラス
  protected void methodA(){ }
  //public void methodA(){ }  //publicでも公開範囲が広くなるのでOK
  //void methodA(){ }         //これは公開範囲が狭くなるのでNG
}

//　abstractのルール
//　[修飾子]　abstractclass　クラス名{}
//・抽象クラスはクラス宣言にabstractキーワードを指定する
//・処理内容が記述された具象メソッドと抽象メソッドを混在できる
//・抽象クラス自体はnewによるインスタンス化はできないため、利用する際は抽象クラスを継承したサブクラスを作成する
//・抽象クラスを継承したサブクラスが具象クラスの場合、もととなる抽象クラスの抽象メソッドをすべてオーバーライドしなければならない
//・抽象クラスを継承したサブクラスが抽象クラスの場合、もととなる抽象クラスの抽象メソッドのオーバーライドは任意である抽象メソッドの構文と特徴は、次のとおりです。
//
//　構文[修飾子]abstract戻り値メソッド名(引数リスト);
//・メソッド宣言でabstract修飾子を指定する
//・修飾子、戻り値、メソッド名、引数リストは、具象メソッドと同様に記述する
//・抽象メソッドは処理をもたないため、メソッド