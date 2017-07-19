package JavaSE8.type8;

import java.io.*;

public class Sample8_3 {
  public static void main(String[] args) {
	  
	// try-with-resources  
    try (FileOutputStream fos =
                  new FileOutputStream(new File("src/type8/ren/8_3.txt"));
         FileInputStream fis =
                  new FileInputStream(new File("src/type8/ren/8_3.txt"))){
      fos.write(0); fos.write("suzuki".getBytes()); fos.write(99);
      int data = 0;
      while ((data = fis.read()) != -1) {
        // 読み込んだデータの表示
        System.out.print(data + " ");
      }
    } catch (FileNotFoundException e){
      System.err.println(" ファイルがありません");
    } catch (IOException e) {
      System.err.println("IO Error");
    }
  }
}

// Answer
// 0 115 117 122 117 107 105 99 

// もしすでにファイルにデータが存在しており、
// 追記で書き込みを行いたい場合は以下のコンストラクタを使用します。
//  構文1：FileOutputStream(File file, boolean append) throws FileNotFoundException
//  構文2：FileOutputStream(String name, boolean append) throws FileNotFoundException
// 	・各コンストラクタの第2引数にはboolean値を指定します。
// 	・trueを指定すると追記となります。
// 	・falseを指定すると先頭から書き込みが行われます。