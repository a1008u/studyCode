package JavaSE8.type3;

import java.util.*;

public class Sample3_6 {
  public static void main(String[] args) {
	  
    Queue<String> queue = new ArrayDeque<String>();
    queue.offer("1"); 
    queue.offer("2"); 
    queue.offer("3");
    
    System.out.println(queue);
    System.out.println("peek() : " + queue.peek());
    System.out.println(queue);
    System.out.println("remove() : " + queue.remove());
    System.out.println(queue);
  }
}

// Answer
// [1, 2, 3]
// peek() : 1
// [1, 2, 3]
// remove() : 1
// [2, 3]

// Queueインタフェース(First In First Out)

