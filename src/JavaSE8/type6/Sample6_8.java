package JavaSE8.type6;

import java.io.*;
import java.sql.*;

class Super{ void method() throws IOException{ } }

class SubA extends Super { 
             void method() { } }
class SubB extends Super { 
             void method() throws FileNotFoundException { } }
// class SubC extends Super { void method() throws Exception { } } // NG
// class SubD extends Super { void method() throws SQLException { } } // NG
class SubE extends Super { 
             void method() throws RuntimeException { } }


//　throwsキーワードが使用されているメソッドをオーバーライドして定義するメソッドには、throwsの使用に関して次のルールが追加されます。
//　●　サブクラスのメソッドがスローする例外は、スーパークラスのメソッドがスローする例外クラスと同じか、その例外クラスのサブクラスとする
//　●　ただし、RuntimeExceptionおよびRuntimeExceptionのサブクラスの例外は、スーパークラスのメソッドに関係なくスローできる
//　●　スーパークラスのメソッドにthrowsがあっても、サブクラス側でthrowsを記述しないことは可能

//オーバーライドのルール
//　●　オーバーライドとは、メソッド名、引数リストがまったく同じメソッドをサブクラスで定義すること
//　●　戻り値の型は、スーパークラスと同じものか、もしくはその戻り値の型のサブクラスであれば使用可能
//　●　アクセス修飾子は、スーパークラスと同じものか、それよりも公開範囲が広いものであれば使用可能
//　●　throwsには、スーパークラスのメソッドがthrowsに指定した例外クラスとそのサブクラスが指定できる
//　●　ただし、RuntimeExceptionクラスおよびそのサブクラスは、制約なしにthrowsに指定できる
//　●　スーパークラスのメソッドにthrowsがあっても、throwsを指定しなくてもよい