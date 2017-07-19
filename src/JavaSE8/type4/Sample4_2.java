package JavaSE8.type4;

import java.util.*;

public class Sample4_2 {
  public static void main(String[] args) {
	  
    List<String> words = Arrays.asList("Tanaka", "Sato");
    
    // 省略パターン
    words.replaceAll( str -> str.toUpperCase() );
    System.out.println(words);
  }
}

// Answer
// [TANAKA, SATO]