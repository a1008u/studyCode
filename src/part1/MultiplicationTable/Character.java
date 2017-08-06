package part1.MultiplicationTable;

import java.util.*;

public class Character {

    public static void main(String args[]){
        String[] characters = {"A","B","C","A","D","E","F","A"};

        System.out.println("重複した文字を削除する前");
        for (String cha : characters) System.out.print(cha +" ");

        System.out.println( "\n" + "---------------------");
        System.out.println("\n" + "\n" + "重複した文字を削除する後 (hashset)");
        Set chaSet = new HashSet<String>();
        for (String cha : characters) chaSet.add(cha);
        for (Iterator chaIte = chaSet.iterator(); chaIte.hasNext(); ) System.out.print(chaIte.next() +" ");

        System.out.println( "\n" + "---------------------");
        System.out.println("\n" + "\n" + "重複した文字を削除する後 (hashset以外)");
        List<String> chaArray = new ArrayList<>();
        for (String cha : characters) if(!chaArray.contains(cha)) chaArray.add(cha);
        for (String cha : chaArray) System.out.print(cha + " ");

        System.out.println( "\n" + "---------------------");
        System.out.println("\n" +  "重複した文字を削除する後(stream)");
        Arrays.stream(characters)
                .distinct()
                .forEach(cha -> System.out.print(cha + " "));

    }
}
