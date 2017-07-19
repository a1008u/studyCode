package JavaSE8.type8;

import java.io.Console;

public class Sample8_12 {
  public static void main(String[] args) {
    Console console = System.console();
    
    //String readLine(String fmt,	Object... args)	
    //	書式設定されたプロンプトを提供し、次にコンソールから単一行のテキストを読み込む
    String name = console.readLine("%s", "name : ");
    System.out.println("You are "+ name);
    
    //char[] readPassword(String fmt,	Object... args)	
    //	書式設定されたプロンプトを提供し、
    //  次にエコーを無効にしたコンソールからパスワードまたはパスフレーズを読み込む
    char[] pw = console.readPassword("%s", "pw: ");
    System.out.print("Your password : ");
    
    for(char c : pw)
      System.out.print(c);
  }
}

// Answer
//  name : aaa // 入力
//  You are aaa
//  pw: // 入力
//  Your password : bbb