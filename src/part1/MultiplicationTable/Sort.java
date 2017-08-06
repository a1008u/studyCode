package part1.MultiplicationTable;

import java.util.Arrays;

public class Sort {
    public static void main(String args[]){

        int[] numbers = {3,1,5,9,2,8,7};

        System.out.println("----sort前----" );
        for (int number : numbers) System.out.print(number +" ");

        System.out.println( "\n" + "\n" + "----sort後の結果----" );

        Arrays.sort(numbers);
        for (int number : numbers) System.out.print(number +" ");

        System.out.println( "\n" + "\n" + "----sort後の結果(stream)----" );
        Arrays.stream(numbers).sorted()
                              .forEach(number -> System.out.print(number +" "));

    }
}
