package JavaSE8.type10;

import java.util.concurrent.*;
import java.util.Date;

public class Sample10_15 {
  public static void main(String[] args){
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<Date> result = service.submit(() -> new Date());
      System.out.println(result.get());
      
    } catch(InterruptedException | ExecutionException e ) { 
      e.printStackTrace(); 
    } finally {
      if(service != null) service.shutdown(); 
    }
  }
}

/*
Answer
	Mon Feb 20 20:29:53 JST 2017
*/

