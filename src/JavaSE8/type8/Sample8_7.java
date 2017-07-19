package JavaSE8.type8;

import java.io.*;

public class Sample8_7 {
  public static void main(String[] args) {
	  
	// Systemクラスの定数
	// プログラムでコンソールに何か出力を行う場合、「System.out.println()」と記述してきました。
	// System.outはSystemクラスのout定数という意味で、保持しているのはjava.io.PrintStreamクラスのオブジェクトです。
	// つまり、println()メソッドは、PrintStreamクラスで提供されているということになります。  
	 
	//	write()、append()、print()、println() の各メソッドは、すべて書き込み処理を行います。
	//	違いは暗黙でflush()が呼ばれるか否かです。
	//	PrintWriterのインスタンス化を行う際、コンストラクタで自動フラッシュを行うようboolean値で指定（true）すると、
	//	println()、printf()、format() の各メソッドは、処理後、暗黙でflush()メソッドが実行されます。
	  
    try(BufferedReader br =
         new BufferedReader(new FileReader("src/type8/ren/8_7.txt"))) {
    	
      System.out.println(br.readLine());
      // void mark(int readAheadLimit)throws IOException	
      //  ストリームの現在位置にマークを設定する。
      //  引数にはマークを保持しながら読み込むことができる文字数の上限を指定する。
      br.mark(256);
      System.out.println(br.readLine());
      System.out.println(br.readLine());
      
      // void reset() throws IOException	
      //  ストリームを、mark() によりマークされた位置にリセットする
      br.reset();
      System.out.println(br.readLine());
      
      // long skip(long n) throws IOException	
      //  引数で指定された文字数をスキップする
      br.skip(2);
      System.out.println(br.readLine());
    } catch (IOException e) { e.printStackTrace(); }
  }
}

//ファイルの内容：8_7.txt
//apple
//orange
//banana


// Answer
// 	apple
// 	orange
// 	banana
// 	orange
// 	nana


//System クラスの定数
//定数	説明
//public static final InputStream in	標準入力ストリーム
//public static final PrintStream out	標準出力ストリーム
//public static final PrintStream err	標準エラー出力ストリーム

