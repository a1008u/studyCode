package JavaSE8.type3;

import java.util.*;

class Employee {
  private String name;
  private Integer id;
  
  public Employee(String name, Integer id) {
    this.name = name; this.id = id;
  }
  
  public Integer getId(){ return id; }
  public String getName(){ return name; }
}

//Comparatorインタフェースの利用
//２つのオブジェクトの大小比較をする
//ソートの対象となるオブジェクトから、比較ルールを独立したクラスとして定義する。
//compare()メソッドとequals()メソッドが宣言されているが、compare()メソッドのみ実装でOK
class MyRule implements Comparator<Employee>{
  public int compare(Employee obj1, Employee obj2){
    return obj1.getId().compareTo(obj2.getId());
  }
}

public class Sample3_19 {
  public static void main(String[] args) {
    Employee e1 = new Employee("taro", 20);
    Employee e2 = new Employee("tomoko", 10);
    Employee e3 = new Employee("hiromi", 50);
    ArrayList<Employee> ary = new ArrayList<>();
    ary.add(e1); ary.add(e2); ary.add(e3);
    
    System.out.println("ArrayList のインデックス順での表示");
    print(ary);
    ary.stream().forEach(System.out::println);
    
    System.out.println("MyRuleで定義したidの昇順での表示");
    Collections.sort(ary, new MyRule());
    print(ary);
    ary.stream().map(a -> a.getId()).sorted().forEach(System.out::println);
  }
  
  public static void print(ArrayList<Employee> ary){
    for (Employee obj : ary) {
      System.out.println(obj.getId() + " " + obj.getName());
    }
  }
}

// Answer
// ArrayListのインデックス順での表示
// 20 taro
// 10 tomoko
// 50 hiromi
// MyRuleで定義したid の昇順での表示
// 10 tomoko
// 20 taro
// 50 hiromi

// Comparableインタフェース
// 自分自身と、別のインスタンスの大小比較をする
// クラスの自然順序付けを提供するためのインタフェース
// Comparableインタフェースを実装していないオブジェクトを格納しようとすると実行時エラー
// (CompareTo()メソッドのみ宣言されていないので、これを実装する。)
//
// Comparatorインタフェースの利用
// ２つのオブジェクトの大小比較をする
// ソートの対象となるオブジェクトから、比較ルールを独立したクラスとして定義する。
// compare()メソッドとequals()メソッドが宣言されているが、compare()メソッドのみ実装でOK

