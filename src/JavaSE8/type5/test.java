package JavaSE8.type5;

import java.util.stream.IntStream;

public class test {

    public static void main(String[] args) {
        solution(24);
    }

    private static void solution(int N) {
        // write your code in Java SE 8

        for(int i=1 ; i <= N; i++ ) {

            System.out.println();

            boolean check3 = (i % 3) == 0 ? true : false;
            boolean check5 = (i % 5) == 0 ? true : false;
            boolean check7 = (i % 7) == 0 ? true : false;

            if (check3) {
                System.out.print("Fizz");
                if (check5) System.out.print("Buzz");
                if (check7) System.out.print("Woof");

                continue;
            }

            if (check5) {
                if (check3) System.out.print("Fizz");
                System.out.print("Buzz");
                if (check7) System.out.print("Woof");

                continue;
            }

            if (check7) {
                if (check3) System.out.print("Fizz");
                if (check5) System.out.print("Buzz");
                System.out.print("Woof");

                continue;
            }
            if (!check3 && !check5 && !check7) {
                System.out.print(i);
            }


        }

    }
}
