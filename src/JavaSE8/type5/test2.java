package JavaSE8.type5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {

    public static void main(String[] args) {
        solution("a0Ba");

        int[] A = {4,6,2,2,6,6,1};
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j]){
                    result = Math.max(result, Math.abs(i - j));
                    break;
                }
       System.out.println(result);
    }

    private static void solution(String S) {
        // write your code in Java SE 8
        Pattern p1 = Pattern.compile("[0-9]");
        Pattern p2 = Pattern.compile("[A-Z]");

        int x = 0;
        int count = 0;

        for(int i=1; i <= S.length(); i++){
            String result = S.substring(x,i);
            Matcher m1 = p1.matcher(result);
            if(m1.find()) {
                x = i;
                count = 0;
                continue;
            }

            Matcher m2 = p2.matcher(S);
            if(m2.find()) {
                count++;
                continue;
            }
        }

        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
