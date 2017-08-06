package part1.MultiplicationTable;

import java.util.Arrays;
import java.util.List;

public class MulitplicationTable1 {

    public static void main(String args[]){

        List<Integer> left = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> right = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for(int l : left) {

            System.out.print("["+ l +"]" + "の段：");
            for(int r : right) {
                System.out.print(l*r + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

        left.forEach(l -> {
            System.out.print("[" + l + "]" + "の段：");
            for(int r : right) {
                System.out.print(l*r + " ");
            }
            System.out.println();
        });

        System.out.println("---------------------------------");

        left.forEach(l -> {
            System.out.print("[" + l + "]" + "の段：");
            right.forEach(r -> System.out.print(l*r + " "));
            System.out.println();
        });
    }
}
