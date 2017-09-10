package part1.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Pyramid {
    public static void main(String[] args) {
        // part SE7(old)
        for(int i = 0; i<10; i++){
            System.out.printf("%4s", i + ":::");
            for(int j = 0; j < 10-(i+1); j++) System.out.print(" ");
            for(int k = 0; k < (i+1)*2-1; k++) System.out.print("*");
            System.out.print("\n");
        }

        System.out.println("---------------------------");

        // part SE8
        IntStream.rangeClosed(0,9).forEach(n -> {
            System.out.printf("%4s", n + ":::");
            IntStream.rangeClosed(1, 10-(n+1)).forEach(a -> System.out.print(" "));
            IntStream.rangeClosed(1, (n+1)*2-1).forEach(a -> System.out.print("*"));
            System.out.print("\n");
        });
    }
}
