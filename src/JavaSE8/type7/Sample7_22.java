package JavaSE8.type7;

import java.time.*;

public class Sample7_22 {
  public static void main(String[] args) throws InterruptedException{
	  
	//　Instantクラスは、単一の時点を扱うクラスです。
	//　UTCでの1970年1月1日0時0分0秒（1970-01-01T00:00:00Z）から測定されるエポック秒を保持します。
	//　具体的には、エポック秒を表すlong値とナノ秒を表すint値（0 と999,999,999 の間になる）を保持します。
	//　なお、エポック後のInstantは正の値を持ち、エポック前のInstantは負の値を持ちます。  
	
	// Instant.now()では、システムUTCクロックを参照して、Instantオブジェクトを作成します。
	// システムUTCクロックとは、UTCタイムゾーンを使ったClockオブジェクトを意味します。
    Instant pointA = Instant.now();
    Thread.sleep(1000);
    Instant pointB = Instant.now();
    Duration duration = Duration.between(pointA, pointB);
    
    System.out.println(pointA);
    System.out.println(pointB);
    System.out.println(duration.toMillis());
  }
}

//　Answer
//　2017-02-18T06:56:29.851Z
//　2017-02-18T06:56:30.856Z
//　1005

